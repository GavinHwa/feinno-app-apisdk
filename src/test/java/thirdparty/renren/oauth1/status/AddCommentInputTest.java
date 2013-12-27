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
 * @fileName : thirdparty.renren.status.AddCommentInputTest.java
 *
 * date		| author	| version	|  
 * 2013-1-6	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-6 下午5:10:16
 *
 */
public class AddCommentInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		AddCommentInput input = new AddCommentInput(
				RenrenTestKeys.getAccessToken(),RenrenTestKeys.getMessage(),RenrenTestKeys.getStatusFeedId(),RenrenTestKeys.getActor_id());
        AddCommentOutput output = TestBase.call(input,AddCommentOutput.class);
        assertTrue(output.outputOK());
        assertFalse(output.needRetry());
        assertFalse(output.needLog());
        assertTrue(output.getResult() == 1);
	}

}
