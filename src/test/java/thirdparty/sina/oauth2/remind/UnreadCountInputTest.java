/**
 *
 */
package thirdparty.sina.oauth2.remind;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.remind.UnreadCountInputTest.java
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
 * @date 2012-10-19 下午3:28:40
 */
public class UnreadCountInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        SinaOauth2Input input = new UnreadCountInput(SinaTestKeys.getAccesstoken2());
        UnreadCountOutput output = TestBase.call(input, UnreadCountOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

}
