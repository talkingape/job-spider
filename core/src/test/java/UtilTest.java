import com.wtmcb.spider.core.boss.BossConfig;
import com.wtmcb.spider.core.lago.LagoConfig;
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
    public void getLagoResponseTest(){
        List<Header> lagoHeader = LagoConfig.getHeader();
        String url;
        String response;
        for (int i = 1; i <= 2; i++) {
            url = MessageFormat.format(LagoConfig.URL_PATTERN, "%E5%85%A8%E5%9B%BD", "java", i);
            response = HttpUtil.getResponse(url, lagoHeader);
            log.info(response);
        }
    }
}
