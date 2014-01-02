/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import org.junit.Test;
import thirdparty.TestBase;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth1.statuses.HomeTimelineInput1Test.java
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
 * @date	2013-1-22 下午6:02:47
 *
 */
public class HomeTimelineInput1Test {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		HomeTimelineInput1 input = new HomeTimelineInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),1,0L);
        HomeTimelineOutput1 output = TestBase.call(input,HomeTimelineOutput1.class);
        assertTrue(output.outputOK());
		input.reNewInput();
        output = TestBase.call(input,HomeTimelineOutput1.class);
        assertTrue(output.outputOK());
	}

}
