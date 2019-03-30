package com.wtmcb.spider.util;


import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.MapUtils;
import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
public class HttpUtil {

    private static final HttpClient HTTP_CLIENT;
    
    static {
        HttpConnectionManagerParams params = new HttpConnectionManagerParams();
        params.setDefaultMaxConnectionsPerHost(20);
        params.setMaxConnectionsPerHost(HostConfiguration.ANY_HOST_CONFIGURATION, MultiThreadedHttpConnectionManager.DEFAULT_MAX_TOTAL_CONNECTIONS);
        MultiThreadedHttpConnectionManager connectionManager = new MultiThreadedHttpConnectionManager();
        connectionManager.setParams(params);
        HTTP_CLIENT = new HttpClient(connectionManager);
    }

    public static String getResponse(String url, List<Header> headerList){
        HttpMethod getMethod = new GetMethod(url);
        if (CollectionUtils.isNotEmpty(headerList)){
            for (Header header :
                    headerList) {
                getMethod.addRequestHeader(header);
            }
        }
        StringBuffer responseBody = new StringBuffer();
        try {
            HTTP_CLIENT.executeMethod(getMethod);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null){
                responseBody.append(line);
            }
        } catch (IOException e) {
            log.error("获取URL-{}内容失败", url, e);
        }
        return responseBody.toString();
    }

    public static List<Header> wrapHeader(Map<String, String> headerMap){
        Header header;
        List<Header> headerList = null;
        if (MapUtils.isNotEmpty(headerMap)){
            headerList = new ArrayList<Header>();
            Set<Map.Entry<String, String>> entries = headerMap.entrySet();
            for (Map.Entry<String, String> entry :
                    entries) {
                header = new Header();
                header.setName(entry.getKey());
                header.setValue(entry.getValue());
                headerList.add(header);
            }
        }
        return headerList;
    }

}
