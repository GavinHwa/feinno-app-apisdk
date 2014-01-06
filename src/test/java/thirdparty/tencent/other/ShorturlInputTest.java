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
 * @fileName : thirdparty.tencent.other.ShorturlInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-13	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-13 下午4:54:13
 *
 */
public class ShorturlInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		ShorturlInput input = new ShorturlInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(), "http://url.cn/8ZortB");
        ShorturlOutput output = TestBase.call(input,ShorturlOutput.class);
        assertTrue(output.outputOK());
	}

}
