import com.wtmcb.spider.core.zhipin.ZhiPinConfig;
import com.wtmcb.spider.util.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.httpclient.Header;
import org.junit.Test;

import java.text.MessageFormat;
import java.util.List;

@Slf4j
public class UtilTest {

    @Test
    public void getResponseTest(){
        List<Header> zhiPinHeader = ZhiPinConfig.getZhiPinHeader();
        String url;
        String response;
        for (int i = 1; i <= 20; i++) {
            url = MessageFormat.format(ZhiPinConfig.URL_PARTTERN, "101020100", "java", i);
            response = HttpUtil.getResponse(url, zhiPinHeader);
            log.info(response);
        }
    }
}
