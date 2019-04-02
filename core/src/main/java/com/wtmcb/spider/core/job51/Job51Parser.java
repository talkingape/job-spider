package com.wtmcb.spider.core.job51;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        String address = Optional.ofNullable(dom.select(".jt em").first()).map(Element::html).orElse("未知")
                + " - "
                + Optional.ofNullable(dom.select(".rec span").first()).map(Element::html).orElse("未知") ;
        String salary = Optional.ofNullable(dom.select(".jp").first()).map(Element::html).orElse("未知");
        String postDate = Optional.ofNullable(dom.select(".jt span").first()).map(Element::html).orElse("未知");
        String body = Optional.ofNullable(dom.select(".ain article").first()).map(Element::val).orElse("未知");
        String companyName = Optional.ofNullable(dom.select(".rec .c_444").first()).map(Element::html).orElse("未知");
        //String positionId = Optional.ofNullable(dom.select(".jp").first()).map(Element::html).orElse("未知");
        String positionName = Optional.ofNullable(dom.select(".jt p").first()).map(Element::html).orElse("未知");
        String workYear = Optional.ofNullable(dom.select(".jd .s_n").first()).map(Element::html).orElse("未知");
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
