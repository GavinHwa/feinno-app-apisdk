package config;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: shangrenpengsq
 * Date: 13-9-25
 * Time: 下午6:00
 * To change this template use File | Settings | File Templates.
 */
public class MessageConfigTest {

    @Test
    public void test() throws Exception {
        assertNotNull(MessageConfig.debugHost);
        assertNotSame(MessageConfig.debugPort,0);
        assertFalse(MessageConfig.debugEnable);
        assertNotNull(MessageConfig.crackGFWHost);
        assertNotSame(MessageConfig.crackGFWHostPort,0);
        assertFalse(MessageConfig.crackGFWHostEnable);
        assertNotNull(MessageConfig.debugHost);
        assertNotNull(MessageConfig.defaultProfileImg);

        assertNotNull(MessageConfig.sinaAppKey);
                assertNotNull(MessageConfig.sinaAppSecret);
                        assertNotNull(MessageConfig.kaixinAppKey);
        assertNotNull(MessageConfig.kaixinAppSecret);
        assertNotNull(MessageConfig.tencentAppKey);
        assertNotNull(MessageConfig.tencentAppSecret);
        assertNotNull(MessageConfig.neteaseAppKey);
        assertNotNull(MessageConfig.neteaseAppSecret);
        assertNotNull(MessageConfig.sohuAppKey);
        assertNotNull(MessageConfig.sohuAppSecret);
        assertNotNull(MessageConfig.mobileAppKey);
        assertNotNull(MessageConfig.mobileAppSecret);
        assertNotNull(MessageConfig.renrenAppKey);
        assertNotNull(MessageConfig.renrenAppSecret);
        assertNotNull(MessageConfig.xinhuaAppKey);
        assertNotNull(MessageConfig.xinhuaAppSecret);

        assertNotNull(MessageConfig.facebookAppId);
        assertNotNull(MessageConfig.youtubeId);
        assertNotNull(MessageConfig.youkuId);
        assertNotNull(MessageConfig.tudouAppKey);
        assertNotNull(MessageConfig.sinaPid);
        assertNotNull(MessageConfig.pomoboType);
        assertNotNull(MessageConfig.xiyouPid);

        assertNotNull(MessageConfig.webHost);

        assertNotNull(MessageConfig.sinaServiceId);
        assertNotNull(MessageConfig.kaixinServiceId);
        assertNotNull(MessageConfig.tencentServiceId);
        assertNotNull(MessageConfig.neteaseServiceId);
        assertNotNull(MessageConfig.sohuServiceId);
        assertNotNull(MessageConfig.mobileServiceId);
        assertNotNull(MessageConfig.renrenServiceId);
        assertNotNull(MessageConfig.xinhuaServiceId);
        assertNotNull(MessageConfig.rssServiceId);

        assertNotNull(MessageConfig.sinaAccessToken1);
        assertNotNull(MessageConfig.sinaAccessSecret1);
        assertNotNull(MessageConfig.sinaAccessToken2);
        assertNotNull(MessageConfig.sinaAccessSecret2);
        assertNotNull(MessageConfig.kaixinAccessToken);
        assertNotNull(MessageConfig.kaixinAccessSecret);
        assertNotNull(MessageConfig.tencentAccessToken);
        assertNotNull(MessageConfig.tencentAccessSecret);
        assertNotNull(MessageConfig.neteaseAccessToken);
        assertNotNull(MessageConfig.neteaseAccessSecret);
        assertNotNull(MessageConfig.sohuAccessToken);
        assertNotNull(MessageConfig.sohuAccessSecret);
        assertNotNull(MessageConfig.mobileAccessToken);
        assertNotNull(MessageConfig.mobileAccessSecret);
        assertNotNull(MessageConfig.renrenAccessToken);
        assertNotNull(MessageConfig.renrenAccessSecret);
        assertNotNull(MessageConfig.xinhuaAccessToken);
        assertNotNull(MessageConfig.xinhuaAccessSecret);
    }
}
