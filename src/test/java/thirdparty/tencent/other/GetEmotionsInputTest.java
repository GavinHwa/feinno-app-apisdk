/**
 * 
 */
package thirdparty.tencent.other;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.other.GetEmotionsInputTest.java
 *
 * date		| author	| version	|  
 * 2012-11-21	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-11-21 下午1:01:54
 *
 */
public class GetEmotionsInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		for(int i = 0; i <= 17; i++){
			GetEmotionsInput input= new GetEmotionsInput(TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret(),i);
            GetEmotionsOutput output = TestBase.call(input,GetEmotionsOutput.class);
            assertTrue(output.outputOK());
		}
	}

}
