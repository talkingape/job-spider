package com.wtmcb.spider.core.job51;

import com.wtmcb.spider.util.HttpUtil;
import org.apache.commons.httpclient.Header;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by WangGang on 2019-03-28.
 * Email: wanggang1@vipkid.com.cn
 */
public class Job51Config {

    public static final String URL_PATTERN = "https://m.51job.com/search/joblist.php?jobarea={0}&keyword={1}&pageno={2}";
    public static final String ACCEPT = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
    public static final String ACCEPT_LANGUAGE = "zh-CN,zh;q=0.9";
    public static final String USER_AGENT = "Mozilla/5.0 (iPhone; CPU iPhone OS 11_0 like Mac OS X) AppleWebKit/604.1.38 (KHTML, like Gecko) Version/11.0 Mobile/15A372 Safari/604.1";
    public static final String REFERER = "https://m.51job.com/";
    public static final String COOKIE = "guid=15313625525334480016; _ujz=OTE2MjUyNjgw; ps=us%3DWmdaOVUpVGABYQFrUSpTYQU2BilQZABlAjxTfQw3DjtcZwBqAmNRYVQ3WjNQMAY3V2EAMlVmAitSHlN1CkwAdloC%26%7C%26needv%3D0; nsearch=jobarea%3D%26%7C%26ord_field%3D%26%7C%26recentSearch0%3D%26%7C%26recentSearch1%3D%26%7C%26recentSearch2%3D%26%7C%26recentSearch3%3D%26%7C%26recentSearch4%3D%26%7C%26collapse_expansion%3D; apxlp=1; partner=tg_yunos_mz; slife=lastlogindate_m%3D20180804%26%7C%26; indexfloatpage=indexlogin%3D20180804%26%7C%26indexwx%3D20180804; 51job=cenglish%3D0%26%7C%26; search=jobarea%7E%60020000%7C%21ord_field%7E%600%7C%21recentSearch0%7E%601%A1%FB%A1%FA020000%2C00%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FAPHP+%BF%AA%B7%A2%A1%FB%A1%FA2%A1%FB%A1%FA%A1%FB%A1%FA-1%A1%FB%A1%FA1532243629%A1%FB%A1%FA0%A1%FB%A1%FA%A1%FB%A1%FA%7C%21recentSearch1%7E%601%A1%FB%A1%FA020000%2C00%A1%FB%A1%FA020300%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA08%2C09%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FAPHP%A1%FB%A1%FA2%A1%FB%A1%FA%A1%FB%A1%FA-1%A1%FB%A1%FA1532333324%A1%FB%A1%FA0%A1%FB%A1%FA%A1%FB%A1%FA%7C%21recentSearch2%7E%601%A1%FB%A1%FA020000%2C00%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA08%2C09%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FAPHP%A1%FB%A1%FA2%A1%FB%A1%FA%A1%FB%A1%FA-1%A1%FB%A1%FA1531708646%A1%FB%A1%FA0%A1%FB%A1%FA%A1%FB%A1%FA%7C%21recentSearch3%7E%601%A1%FB%A1%FA020000%2C00%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA09%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FAPHP%A1%FB%A1%FA2%A1%FB%A1%FA%A1%FB%A1%FA-1%A1%FB%A1%FA1531708638%A1%FB%A1%FA0%A1%FB%A1%FA%A1%FB%A1%FA%7C%21recentSearch4%7E%601%A1%FB%A1%FA020000%2C00%A1%FB%A1%FA000000%A1%FB%A1%FA0000%A1%FB%A1%FA00%A1%FB%A1%FA9%A1%FB%A1%FA99%A1%FB%A1%FA08%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FA99%A1%FB%A1%FAPHP%A1%FB%A1%FA2%A1%FB%A1%FA%A1%FB%A1%FA-1%A1%FB%A1%FA1531708594%A1%FB%A1%FA0%A1%FB%A1%FA%A1%FB%A1%FA%7C%21collapse_expansion%7E%601%7C%21; m_search=keyword%3DPHP+%E5%BC%80%E5%8F%91%26%7C%26areacode%3D020000";

    public static List<Header> getHeader(){
        Map<String, String> headerMap = new HashMap<String, String>(5);
        headerMap.put("Accept", ACCEPT);
        headerMap.put("Accept-Language", ACCEPT_LANGUAGE);
        headerMap.put("Cookie", COOKIE);
        headerMap.put("Referer", REFERER);
        headerMap.put("User-Agent", USER_AGENT);
        List<Header> headerList = HttpUtil.wrapHeader(headerMap);
        return headerList;
    }
}
