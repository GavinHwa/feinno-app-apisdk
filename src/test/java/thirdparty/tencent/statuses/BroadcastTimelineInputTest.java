/**
 * 
 */
package thirdparty.tencent.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.statuses.BroadcastTimelineInputTest.java
 *
 * date		| author	| version	|  
 * 2013-1-22	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-22 上午11:13:16
 *
 */
public class BroadcastTimelineInputTest {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		BroadcastTimelineInput input = new BroadcastTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret(),5);
        BroadcastTimelineOutput output = TestBase.call(input,BroadcastTimelineOutput.class);
        assertTrue(output.outputOK());

		input = new BroadcastTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret());
        output = TestBase.call(input,BroadcastTimelineOutput.class);
        assertTrue(output.outputOK());
	}
}
