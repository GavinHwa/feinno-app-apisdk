/**
 * 
 */
package thirdparty.renren.oauth1.photos;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.photos.GetInputTest.java
 *
 * date		| author	| version	|  
 * 2013-1-5	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-5 下午5:35:28
 *
 */
public class GetInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		GetInput input= new GetInput(RenrenTestKeys.getAccessToken(),"389414346","6867969404");
        GetOutput output = TestBase.call(input,GetOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertTrue(output.getPictures().size() == 1);
	}

}
