/**
 * 
 */
package thirdparty.kaixin.emotion;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.kaixin.KaixinTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.kaixin.emotion.ShowInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-4 下午5:09:55
 *
 */
public class ShowInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		ShowInput input= new ShowInput(KaixinTestKeys.accessToken,KaixinTestKeys.accessSecret);
		ShowOutput output = TestBase.call(input,ShowOutput.class);
		assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertTrue(output.getEmotions() != null && output.getEmotions().size() > 0);
	}

}
