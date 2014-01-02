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
 * @fileName : thirdparty.sina.oauth2.statuses.CreateInputTest.java
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
 * @date 2012-10-19 下午5:01:11
 */
public class CreateInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = SinaTestKeys.getMessage();
        SinaOauth2Input input = new CreateInput(SinaTestKeys.getAccesstoken2(), text, 3502213525503956L);
        CreateOutput output = TestBase.call(input, CreateOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

}
