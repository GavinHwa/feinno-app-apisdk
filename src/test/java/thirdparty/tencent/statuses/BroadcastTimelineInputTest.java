/**
 * 
 */
package thirdparty.tencent.statuses;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import thirdparty.tencent.TencentTestKeys;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

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
	public void test() {
		BroadcastTimelineInput input = new BroadcastTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret(),5);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							BroadcastTimelineOutput output = new BroadcastTimelineOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
		
		input = new BroadcastTimelineInput(TencentTestKeys.getAccesstoken(), TencentTestKeys.getAccessSecret());
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							BroadcastTimelineOutput output = new BroadcastTimelineOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}
}
