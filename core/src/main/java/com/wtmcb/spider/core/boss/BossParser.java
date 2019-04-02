package com.wtmcb.spider.core.boss;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wtmcb.spider.core.job51.Job51Entity;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by WangGang on 2019-03-30.
 * Email: wanggang1@vipkid.com.cn
 */
@Slf4j
public class BossParser {

    public List<String> parseList(String response) {
        JSONObject responseJson = (JSONObject) JSON.parse(response);
        String html = responseJson.getString("html");
        Document dom = Jsoup.parse(html);
        Elements hrefElements = dom.select(".item a");
        List<String> hrefList = hrefElements.eachAttr("href");
        List<String> fullHrefList = new ArrayList<>();
        for (String href :
                hrefList) {
            fullHrefList.add(BossConfig.REFERER + href);
        }
        return fullHrefList;
    }

    public Job51Entity parseDetail(String url, String response){
        Document dom = Jsoup.parse(response);
        String address = Optional.ofNullable(dom.select(".location-address").first()).map(Element::html).orElse("未知");
        String postDate = Optional.ofNullable(dom.select(".job-tags .time").first()).map(Element::html).orElse("未知");
        String body = Optional.ofNullable(dom.select(".text").first()).map(Element::val).orElse("未知");
        String companyName = Optional.ofNullable(dom.select(".business-info h4'").first()).map(Element::html).orElse("未知");
        String salary = Optional.ofNullable(dom.select(".job-banner .info-primary .name .salary").first()).map(Element::html).map(String::trim).orElse("未知");
        String positionName = Optional.ofNullable(dom.select(".job-banner .info-primary .name h1").first()).map(Element::html).orElse("未知");

        //String positionId = Optional.ofNullable(dom.select(".jp").first()).map(Element::html).orElse("未知");
        String workYear = Optional.ofNullable(dom.select(".job-banner .info-primary p").first()).map(Element::html).orElse("未知");
        String educational = Optional.ofNullable(dom.select(".jd .s_x").first()).map(Element::html).orElse("未知");
        Job51Entity job51Entity = Job51Entity.builder()
                .address(address)
                .salary(salary)
                .body(body)
                .companyName(companyName)
                //.positionId(positionId)
                .positionName(positionName)
                .workYear(workYear)
                .educational(educational)
                .postDate(postDate)
                .createTime(new Date())
                .build();
        return job51Entity;
    }
}
