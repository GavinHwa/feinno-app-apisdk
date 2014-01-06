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
 * @fileName : thirdparty.tencent.t.AddVideoInputTest.java
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
 * @date 2012-12-10 上午11:28:07
 * 
 */
public class AddVideoInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		final String text = TencentTestKeys.getMessage();
		AddVideoInput input = new AddVideoInput(
                TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret(), text,
				"http://v.youku.com/v_show/id_XNDg1NzUzNTI0.html","10.10.175.202");
        AddVideoOutput output = TestBase.call(input,AddVideoOutput.class);
        assertTrue(output.outputOK());
	}

}
