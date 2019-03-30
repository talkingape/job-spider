package com.wtmcb.spider.core.lagou;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.Iterator;

/**
 * Created by WangGang on 2019-03-30.
 * Email: wanggang1@vipkid.com.cn
 */
@Slf4j
public class LagouParser implements SpiderParser<LagouEntity> {

    @Override
    public LagouEntity parse(String response) {
        JSONObject responseJson = (JSONObject) JSON.parse(response);
        //js['content']['data']['page']['result']
        JSONObject content = responseJson.getJSONObject("content");
        JSONObject data = content.getJSONObject("data");
        JSONObject page = data.getJSONObject("page");
        JSONArray result = page.getJSONArray("result");
        Iterator<Object> iterator = result.iterator();
        while (iterator.hasNext()){
            JSONObject next = (JSONObject) iterator.next();
            String jobDetailUrl = MessageFormat.format(LagouConfig.JOB_DETAIL_URL, next.getString("positionId"));
            log.info("拉勾-职位详情链接-{}", jobDetailUrl);
        }
        return null;
    }
}
