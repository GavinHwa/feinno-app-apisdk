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
 * @fileName : thirdparty.sina.oauth2.statuses.UploadUrlTextInputTest.java
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
 * @date 2012-10-19 下午7:50:09
 */
public class UploadUrlTextInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = "这是飞信同步测试，新浪的工作人员请不要删除！";
        SinaOauth2Input input = new UploadUrlTextInput(
                SinaTestKeys.getAccesstoken2(), text, "http://i-imgp.fetionpic.com/fpic/pic1/M00/FF/EE/rBUyIlHe1_jTtCvPAAAN0bGptwE527.jpg");
        UploadUrlTextOutput output = TestBase.call(input, UploadUrlTextOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

}
