/**
 * 
 */
package thirdparty.tencent.statuses;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.statuses.HomeTimelineInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-11 下午12:03:45
 *
 */
public class HomeTimelineInputTest {

	@Test
	public void test() {
		HomeTimelineInput input = new HomeTimelineInput(TencentTestKeys.getAccesstoken()
				,
                TencentTestKeys.getAccessSecret(), 5);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
                            return response;

						}
					});
			Response response = (Response) future.get();

            assertNotNull(response.getResponseBody());
            HomeTimelineOutput output = new HomeTimelineOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
		} catch (Exception e) {
		}
		
		input = new HomeTimelineInput(
				TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret());
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							return response;
						}
					});
            Response response = (Response) future.get();

            assertNotNull(response.getResponseBody());
            HomeTimelineOutput output = new HomeTimelineOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
		} catch (Exception e) {
		}
		
		input.reNewInput();
		
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							return response;
						}
					});
            Response response = (Response) future.get();

            assertNotNull(response.getResponseBody());
            HomeTimelineOutput output = new HomeTimelineOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
		} catch (Exception e) {
		}
	}

}
