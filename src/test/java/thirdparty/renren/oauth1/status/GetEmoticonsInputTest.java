/**
 * 
 */
package thirdparty.renren.oauth1.status;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.status.GetEmoticonsTest.java
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
 * @date	2012-11-21 上午11:29:24
 *
 */
public class GetEmoticonsInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		GetEmoticonsInput input= new GetEmoticonsInput(RenrenTestKeys.getAccessToken());
        GetEmoticonsOutput output = TestBase.call(input, GetEmoticonsOutput.class);

        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertTrue(output.getEmotions().size() != 0);
	}

}
