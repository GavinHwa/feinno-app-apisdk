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
 * @fileName : thirdparty.tencent.t.AddPicUrlInputTest.java
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
 * @date 2012-12-10 下午7:15:00
 */
public class AddPicUrlInputTest {

    @Test
    public void test() throws InstantiationException, IllegalAccessException {
        final String text = TencentTestKeys.getMessage();
        AddPicUrlInput input = new AddPicUrlInput(
                TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret(), text,
                "http://i-imgh.fetionpic.com/fportrait/portrait1/M00/1B/53/rBUyIU84fDutYqgTAABz_rdvD8w408.jpg",
                "10.10.175.202");
        AddPicUrlOutput output = TestBase.call(input, AddPicUrlOutput.class);
        assertTrue(output.outputOK());
    }

}
