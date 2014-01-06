/**
 *
 */
package thirdparty.tencent.t;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.t.CommentInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-12-10 下午7:27:27
 */
public class CommentInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = TencentTestKeys.getMessage();
        CommentInput input = new CommentInput(
                TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret(), text,
                "10.10.175.202", "173373110203362");
        AddOutput output = TestBase.call(input, AddOutput.class);
        assertTrue(output.outputOK());
    }

}
