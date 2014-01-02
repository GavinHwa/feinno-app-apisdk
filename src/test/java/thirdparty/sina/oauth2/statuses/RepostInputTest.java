/**
 *
 */
package thirdparty.sina.oauth2.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.RepostInputTest.java
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
 * @date 2012-10-19 下午5:49:59
 */
public class RepostInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = "这是飞信同步转发测试，新浪的工作人员请不要删除！" + new Random().nextInt(50);
        SinaOauth2Input input = new RepostInput(
                SinaTestKeys.getAccesstoken2(), text
                , 3502213525503956L);
        RepostOutput output = TestBase.call(input, RepostOutput.class);
        assertEquals(output.getText(), text);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
    }

}
