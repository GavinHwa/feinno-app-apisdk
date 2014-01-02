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
 * @fileName : thirdparty.sina.oauth1.statuses.UserTimelineInput1Test.java
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
 * @date	2013-1-22 上午9:50:43
 *
 */
public class UserTimelineInput1Test {

	@Test
	public void test() throws InstantiationException, IllegalAccessException {
		UserTimelineInput1 input = new UserTimelineInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),3536925023246498L,1,0,"3040570084");
        UserTimelineOutput1 output = TestBase.call(input,UserTimelineOutput1.class);
        assertTrue(output.outputOK());
	}
}
