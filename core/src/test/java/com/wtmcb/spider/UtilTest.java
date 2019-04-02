package com.wtmcb.spider;

import com.alibaba.fastjson.JSON;
import com.wtmcb.spider.core.boss.BossConfig;
import com.wtmcb.spider.core.boss.BossParser;
import com.wtmcb.spider.core.job51.Job51Config;
import com.wtmcb.spider.core.job51.Job51Parser;
import com.wtmcb.spider.core.lagou.LagouConfig;
import com.wtmcb.spider.core.lagou.LagouParser;
import com.wtmcb.spider.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.Header;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
public class UtilTest {

    @Test
    public void getBossResponseTest(){
        List<Header> bossHeader = BossConfig.getHeader();
        String url;
        String response;
        for (int i = 1; i <= 1; i++) {
            url = MessageFormat.format(BossConfig.URL_PATTERN, "101020100", "java", i);
            response = HttpUtil.getResponse(url, bossHeader);
            log.info(response);
            List<String> urlList = new BossParser().parseList(response);
            log.info(JSON.toJSONString(urlList));
        }
    }

    @Test
    public void getBossDetailResponseTest(){
        String response = HttpUtil.getResponse("https://www.zhipin.com/job_detail/8be70087fe31e4a91Xxy29-6EFE~.html");
        Document dom = Jsoup.parse(response);
        Elements select = dom.select(".job-banner .info-primary p");
        log.info(JSON.toJSONString(select));
    }

    @Test
    public void getLagouResponseTest(){
        List<Header> lagouHeader = LagouConfig.getHeader();
        String url;
        String response;
        for (int i = 1; i <= 1; i++) {
            url = MessageFormat.format(LagouConfig.URL_PATTERN, "%E5%85%A8%E5%9B%BD", "java", i);
            response = HttpUtil.getResponse(url, lagouHeader);
            log.info(response);
            new LagouParser().parse(response);
        }
    }

    @Test
    public void get51JobResponseTest(){
        Job51Parser job51Parser = new Job51Parser();
        List<Header> job51Header = Job51Config.getHeader();
        String url;
        String response;
        for (int i = 1; i <= 1; i++) {
            url = MessageFormat.format(Job51Config.URL_PATTERN, "020000", "java", i);
            response = HttpUtil.getResponse(url, job51Header);
            log.info(response);
            List<String> urlList = job51Parser.parseList(response);
            String detailUrl = urlList.get(0);
            String detailResponse = HttpUtil.getResponse(detailUrl);
            log.info(detailResponse);
        }
    }
}
