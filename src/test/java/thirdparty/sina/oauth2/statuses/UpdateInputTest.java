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
 * @fileName : thirdparty.sina.oauth2.statuses.UpdateInputTest.java
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
 * @date 2012-10-19 下午6:14:08
 */
public class UpdateInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = SinaTestKeys.getMessage();
        SinaOauth2Input input = new UpdateInput(SinaTestKeys.getAccesstoken2()
                , text);
        UpdateOutput output = TestBase.call(input, UpdateOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

    @Test//可能会因为发布过快导致20016错误
    public void test1() throws InstantiationException, IllegalAccessException {
        final String text = SinaTestKeys.getMessage();
        SinaOauth2Input input = new UpdateInput(
                SinaTestKeys.getAccesstoken2(), text, "{test:\"test\"}");
        UpdateOutput output = TestBase.call(input, UpdateOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

    @Test//可能会因为发布过快导致20016错误
    public void test2() throws InstantiationException, IllegalAccessException {
        final String text = SinaTestKeys.getMessage();
        SinaOauth2Input input = new UpdateInput(
                SinaTestKeys.getAccesstoken2(), text, 45, 45);
        UpdateOutput output = TestBase.call(input, UpdateOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

    @Test//可能会因为发布过快导致20016错误
    public void test3() throws InstantiationException, IllegalAccessException {
        final String text = SinaTestKeys.getMessage();
        SinaOauth2Input input = new UpdateInput(
                SinaTestKeys.getAccesstoken2(), text, 45, 45, "{test:\"test\"}");
        UpdateOutput output = TestBase.call(input, UpdateOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }
}
