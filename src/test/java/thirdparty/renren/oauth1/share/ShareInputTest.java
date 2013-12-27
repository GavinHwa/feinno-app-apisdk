/**
 * 
 */
package thirdparty.renren.oauth1.share;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.renren.RenrenTestKeys;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.share.ShareInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-25	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-25 上午11:13:27
 *
 */
public class ShareInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		ShareInput input= new ShareInput(RenrenTestKeys.getAccessToken(),RenrenTestKeys.getMessage(),RenrenTestKeys.getVideoUrl());
        ShareOutput output = TestBase.call(input,ShareOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertNotNull(output.getUrl());
	}

}
