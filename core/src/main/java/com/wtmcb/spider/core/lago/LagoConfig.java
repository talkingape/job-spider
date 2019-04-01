package com.wtmcb.spider.core.lago;

import com.wtmcb.spider.util.HttpUtil;
import org.apache.commons.httpclient.Header;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LagoConfig {

    public static final String URL_PATTERN = "https://m.lagou.com/search.json?city={0}&positionName={1}&pageNo={2}&pageSize=15";
    public static final String ACCEPT = "application/json";
    public static final String ACCEPT_ENCODING = "br, gzip, deflate";
    public static final String ACCEPT_LANGUAGE = "zh-cn";
    public static final String CONNECTION = "close";
    public static final String COOKIE = "Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1553614435; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1553614435; LGRID=20190326233355-90c3788a-4fdc-11e9-9a22-525400f775ce; LGSID=20190326233355-90c3771b-4fdc-11e9-9a22-525400f775ce; LGUID=20190326233355-90c378e6-4fdc-11e9-9a22-525400f775ce; PRE_HOST=; PRE_LAND=https%3A%2F%2Fm.lagou.com%2Fsearch.html; PRE_SITE=; PRE_UTM=; _ga=GA1.2.1213757381.1553614435; _gid=GA1.2.2051913187.1553614435; user_trace_token=20190326233354-ae8ff1951a7042f48d10544cd6474cc6; _ga=GA1.3.1213757381.1553614435; _gat=1; JSESSIONID=ABAAABAAAGCABCC2C7F2B7070AEB364694FEDBF796D1798";
    public static final String HOST = "m.lagou.com";
    public static final String REFERER = "https://m.lagou.com/search.html";
    public static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 12_1_4 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Mobile/16D57 MicroMessenger/7.0.3(0x17000321) NetType/WIFI Language/zh_CN";
    public static final String X_REQUESTED_WITH = "XMLHttpRequest";

    public static List<Header> getHeader(){
        Map<String, String> headerMap = new HashMap<String, String>(6);
        headerMap.put("Accept", ACCEPT);
        headerMap.put("Accept-Encoding", ACCEPT_ENCODING);
        headerMap.put("Accept-Language", ACCEPT_LANGUAGE);
        headerMap.put("Connection", CONNECTION);
        headerMap.put("Cookie", COOKIE);
        headerMap.put("Host", HOST);
        headerMap.put("Referer", REFERER);
        headerMap.put("User-Agent", USER_AGENT);
        headerMap.put("X-Requested-With", X_REQUESTED_WITH);
        List<Header> headerList = HttpUtil.wrapHeader(headerMap);
        return headerList;
    }
}
