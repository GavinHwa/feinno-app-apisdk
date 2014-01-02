/**
 *
 */
package thirdparty.sina.oauth1.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth1.statuses.UnreadInput1Test.java
 *
 * date		| author	| version	|  
 * 2013-1-21	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author shangrenpeng
 * @date 2013-1-21 上午9:45:50
 */
public class UnreadInput1Test {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        UnreadInput1 input = new UnreadInput1(SinaTestKeys.getAccesstoken(), SinaTestKeys.getAccessSecret());
        UnreadOutput1 output = TestBase.call(input, UnreadOutput1.class);
        assertTrue(output.outputOK());
    }


}
