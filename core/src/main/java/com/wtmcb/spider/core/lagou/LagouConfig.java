package com.wtmcb.spider.core.lagou;

import com.wtmcb.spider.util.HttpUtil;
import org.apache.commons.httpclient.Header;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LagouConfig {

    public static final String JOB_DETAIL_URL = "https://m.lagou.com/jobs/{0}.html";
    public static final String URL_PATTERN = "https://m.lagou.com/search.json?city={0}&positionName={1}&pageNo={2}&pageSize=15";
    public static final String ACCEPT = "application/json";
    public static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.9";
    public static final String COOKIE = "user_trace_token=20180729204908-c52cbd0e4d394a3cb58519920e083a0b; JSESSIONID=ABAAABAAAGCABCC79240AC570FA1732FC9159DD43105445; X_HTTP_TOKEN=5338df7c911167920d5f0d7615b94748; _ga=GA1.2.1539481412.1532868549; _gid=GA1.2.309176990.1532868549; Hm_lvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1532398323,1532418933,1532572655,1532868549; LGSID=20180729204908-c8b50abb-932d-11e8-ab47-525400f775ce; PRE_UTM=; PRE_HOST=; PRE_SITE=; PRE_LAND=https%3A%2F%2Fpassport.lagou.com%2Flogin%2Flogin.html%3Fts%3D1532868548009%26serviceId%3Dlagou%26service%3Dhttp%25253A%25252F%25252Fm.lagou.com%25252Fuser%25252Fcollect.json%25253FpositionId%25253D233753%26action%3Dlogin%26signature%3D01759552449CC48F903E9AB889298EAC; LGUID=20180729204908-c8b50c64-932d-11e8-ab47-525400f775ce; _ga=GA1.3.1539481412.1532868549; _gat=1; Hm_lpvt_4233e74dff0ae5bd0a3d81c6ccf756e6=1532868713; LGRID=20180729205153-2ae970a6-932e-11e8-a07d-5254005c3644";
    public static final String REFERER = "https://m.lagou.com/search.html";
    public static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";
    public static final String X_REQUESTED_WITH = "XMLHttpRequest";

    public static List<Header> getHeader(){
        Map<String, String> headerMap = new HashMap<String, String>(8);
        headerMap.put("Accept", ACCEPT);
        headerMap.put("Accept-Language", ACCEPT_LANGUAGE);
        headerMap.put("Cookie", COOKIE);
        headerMap.put("Referer", REFERER);
        headerMap.put("User-Agent", USER_AGENT);
        headerMap.put("X-Requested-With", X_REQUESTED_WITH);
        List<Header> headerList = HttpUtil.wrapHeader(headerMap);
        return headerList;
    }
}
