/**
 *
 */
package thirdparty.tencent.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.statuses.HomeTimelineInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-12-11 下午12:03:45
 */
public class HomeTimelineInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        HomeTimelineInput input = new HomeTimelineInput(TencentTestKeys.getAccesstoken()
                , TencentTestKeys.getAccessSecret(), 5);
        HomeTimelineOutput output = TestBase.call(input, HomeTimelineOutput.class);
        assertTrue(output.outputOK());

        input = new HomeTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret());
        assertTrue(output.outputOK());

        input.reNewInput();
        input = new HomeTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret());
        assertTrue(output.outputOK());
    }

}
