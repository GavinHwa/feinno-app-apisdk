/**
 *
 */
package thirdparty.renren.oauth1.feed;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.feed.GetInputTest.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author shangrenpeng
 * @date 2013-1-4 下午5:29:48
 */
public class GetInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        GetInput input = new GetInput(RenrenTestKeys.getAccessToken(), 1);
        GetOutput output = TestBase.call(input, GetOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertEquals(1,output.getStatuses().size());
    }

    @Test
    public void getMyFeeds() throws InstantiationException, IllegalAccessException {
        GetInput input = new GetInput(
                RenrenTestKeys.getAccessToken(), 1, "389414346");
        GetOutput output = TestBase.call(input, GetOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertEquals(1,output.getStatuses().size());
    }
}
