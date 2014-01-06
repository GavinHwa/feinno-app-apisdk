/**
 * 
 */
package thirdparty.tencent.info;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.info.UpdateInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-11 下午8:08:52
 *
 */
public class UpdateInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		UpdateInput input = new UpdateInput(TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret());
        UpdateOutput output = TestBase.call(input,UpdateOutput.class);
        assertTrue(output.outputOK());
	}

}
