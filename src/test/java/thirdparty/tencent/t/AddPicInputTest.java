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
 * @fileName : thirdparty.tencent.t.AddPicInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-10 下午4:13:03
 *
 */
public class AddPicInputTest {
	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		final String text = TencentTestKeys.getMessage();
		AddPicInput input = new AddPicInput(
                TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret(), text,
						TencentTestKeys.getPic(),"10.10.175.202");

        AddPicOutput output = TestBase.call(input,AddPicOutput.class);
        assertTrue(output.outputOK());
	}

}
