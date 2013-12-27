/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import static org.junit.Assert.*;

import org.junit.Test;

import thirdparty.sina.SinaTestKeys;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

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
	public void test() {
		HomeTimelineInput1 input = new HomeTimelineInput1(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret(),1,0L);
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
							HomeTimelineOutput1 output = new HomeTimelineOutput1();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
		
		input.reNewInput();
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();
		final HomeTimelineOutput1 output = new HomeTimelineOutput1();
		output.setRetryInput(input);
		output.setRetryTimes(3);

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}

}
