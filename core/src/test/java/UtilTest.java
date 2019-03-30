import com.wtmcb.spider.core.boss.BossConfig;
import com.wtmcb.spider.core.job51.Job51Config;
import com.wtmcb.spider.core.job51.Job51Parser;
import com.wtmcb.spider.core.lagou.LagouConfig;
import com.wtmcb.spider.core.lagou.LagouParser;
import com.wtmcb.spider.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.Header;
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
        }
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
        List<Header> job51Header = Job51Config.getHeader();
        String url;
        String response;
        for (int i = 1; i <= 1; i++) {
            url = MessageFormat.format(Job51Config.URL_PATTERN, "020000", "java", i);
            response = HttpUtil.getResponse(url, job51Header);
            log.info(response);
            new Job51Parser().parse(response);
        }
    }
}
