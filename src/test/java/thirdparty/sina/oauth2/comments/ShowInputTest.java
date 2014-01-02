/**
 *
 */
package thirdparty.sina.oauth2.comments;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.comments.ShowInputTest.java
 *
 * date		| author	| version	|  
 * 2012-10-18	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-10-18 下午7:54:35
 */
public class ShowInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        SinaOauth2Input input = new ShowInput(SinaTestKeys.getAccesstoken2(), 3502213525503956L);
        ShowOutput output = TestBase.call(input, ShowOutput.class);
        assertNotNull(output.getComments().get(0).getText());
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

}
