/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import thirdparty.sina.SinaTestKeys;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

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
	public void test() {
		UserTimelineInput1 input = new UserTimelineInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),3536925023246498L,1,0,"3040570084");
//		input.setDebug(true);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UserTimelineOutput1 output = new UserTimelineOutput1();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}
}
