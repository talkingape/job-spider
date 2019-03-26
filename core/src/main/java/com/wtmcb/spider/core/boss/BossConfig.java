package com.wtmcb.spider.core.boss;

import com.wtmcb.spider.util.HttpUtil;
import org.apache.commons.httpclient.Header;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossConfig {

    public static final String URL_PATTERN = "https://www.boss.com/mobile/jobs.json?city={0}&query={1}&page={2}";
    public static final String ACCEPT = "application/json";
    public static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.9";
    public static final String USER_AGENT = "Mozilla/5.0 (Linux; Android 9.0; Pixel 2 Build/OPD3.170816.012) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.117 Mobile Safari/537.36";
    public static final String REFERER = "https://www.boss.com/";
    public static final String X_REQUESTED_WITH = "XMLHttpRequest";
    public static final String COOKIE = "lastCity=101020100; JSESSIONID=\"\"; Hm_lvt_194df3105ad7148dcf2b98a91b5e727a=1532401467,1532435274,1532511047,1532534098; __c=1532534098; __g=-; __l=l=%2Fwww.boss.com%2F&r=; toUrl=https%3A%2F%2Fwww.boss.com%2Fc101020100-p100103%2F; Hm_lpvt_194df3105ad7148dcf2b98a91b5e727a=1532581213; __a=4090516.1532500938.1532516360.1532534098.11.3.7.11";

    public static List<Header> getHeader(){
        Map<String, String> headerMap = new HashMap<String, String>(6);
        headerMap.put("Accept", ACCEPT);
        headerMap.put("Accept-Language", ACCEPT_LANGUAGE);
        headerMap.put("User-Agent", USER_AGENT);
        headerMap.put("Referer", REFERER);
        headerMap.put("X-Requested-With", X_REQUESTED_WITH);
        headerMap.put("Cookie", COOKIE);
        List<Header> headerList = HttpUtil.wrapHeader(headerMap);
        return headerList;
    }
}
