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
 * @fileName : thirdparty.tencent.t.ReListInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-12-11 下午7:27:01
 * 
 */
public class ReListInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		ReListInput input = new ReListInput(TencentTestKeys.getAccesstoken(),
				TencentTestKeys.getAccessSecret(), "173373110203362");
        ReListOutput output = TestBase.call(input,ReListOutput.class);
        assertTrue(output.outputOK());

		input = new ReListInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(), "173373110203362",1355213120L,"133345079590466");
        output = TestBase.call(input,ReListOutput.class);
        assertTrue(output.outputOK());
	}
}
