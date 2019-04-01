package com.wtmcb.spider.core.job51;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

/**
 * Created by WangGang on 2019-03-30.
 * Email: wanggang1@vipkid.com.cn
 */
@Slf4j
public class Job51Parser {

    public List<String> parseList(String response) {
        Document dom = Jsoup.parse(response);
        Elements hrefElements = dom.select(".items a");
        List<String> hrefList = hrefElements.eachAttr("href");
        log.info(JSONObject.toJSONString(hrefList));
        return hrefList;
    }

    /**
     * item['address'] = q('.jt em::text').extract_first() + ' ' +q('.rec span::text').extract_first()
     * item['salary'] = q('.jp::text').extract_first()
     * item['create_time'] = q('.jt span::text').extract_first()
     * item['body']  = q('.ain article').xpath('string(.)').extract_first()
     * item['company_name'] = q('.rec .c_444::text').extract_first()
     * item['position_id'] = response.url.split("/")[-1].split('.')[0]
     * item['position_name'] = q('.jt p::text').extract_first()
     * item['work_year'] = q('.jd .s_n::text').extract_first() or "不限"
     * item['educational']  = q('.jd .s_x::text').extract_first() or "不限"
     */
    public Job51Entity parseDetail(String url, String response){
        Document dom = Jsoup.parse(response);
        String address = dom.select(".jt em text").first().val() + dom.select(".rec span text").first().val();
        String salary = dom.select(".jp text").first().val();
        String createTime = dom.select(".jt span text").first().val();
        String body = dom.select(".ain article").first().val();
        String companyName = dom.select(".rec .c_444 text").first().val();
        String positionId = dom.select(".jp text").first().val();
        String positionName = dom.select(".jt p text").first().val();
        String workYear = dom.select(".jd .s_n text").first().val();
        String educational = dom.select(".jd .s_x text").first().val();
        Job51Entity job51Entity = Job51Entity.builder()
                .address(address)
                .salary(salary)
                .body(body)
                .companyName(companyName)
                .positionId(positionId)
                .positionName(positionName)
                .workYear(Integer.parseInt(workYear))
                .educational(educational)
                .build();
        return job51Entity;
    }
}
