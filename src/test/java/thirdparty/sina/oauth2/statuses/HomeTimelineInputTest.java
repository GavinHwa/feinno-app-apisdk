/**
 *
 */
package thirdparty.sina.oauth2.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineInputTest.java
 *
 * date		| author	| version	|  
 * 2012-10-19	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-10-19 下午5:19:52
 */
public class HomeTimelineInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        SinaOauth2Input input = new HomeTimelineInput(SinaTestKeys.getAccesstoken2(), 3502213525503956L);
        HomeTimelineOutput output = TestBase.call(input, HomeTimelineOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

    @Test
    public void test2() throws InstantiationException, IllegalAccessException {
        SinaOauth2Input input = new HomeTimelineInput(SinaTestKeys.getAccesstoken2(), 3502213525503956L, 5);
        HomeTimelineOutput output = TestBase.call(input, HomeTimelineOutput.class);
        assertEquals(((HomeTimelineOutput) output)
                .getStatuses().size(), 5);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

    @Test
    public void test3() throws InstantiationException, IllegalAccessException {
        SinaOauth2Input input = new HomeTimelineInput(SinaTestKeys.getAccesstoken2(), 10);
        HomeTimelineOutput output = TestBase.call(input, HomeTimelineOutput.class);
        assertEquals(((HomeTimelineOutput) output)
                .getStatuses().size(), 10);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }
}
