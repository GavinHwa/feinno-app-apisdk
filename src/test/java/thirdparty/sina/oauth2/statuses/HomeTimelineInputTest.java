/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;
import com.ning.http.client.*;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineInputTest.java
 *
 * date		| author	| version	|  
 * 2012-10-19	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-10-19 下午5:19:52
 *
 */
public class HomeTimelineInputTest {

	@Test
	public void test() {
		SinaOauth2Input input= new HomeTimelineInput(SinaTestKeys.getAccesstoken2(),3502213525503956L);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

				@Override
				public Object onCompleted(Response response) throws Exception {
                    return response;

				}
			});
			Response response = (Response) future.get();
            assertNotNull(response.getResponseBody());
            HomeTimelineOutput output = new HomeTimelineOutput();
            output.fromHttpResponse(response, null);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
		} catch (Exception e) {
		}
	}

	@Test
	public void test2() {
		SinaOauth2Input input= new HomeTimelineInput(SinaTestKeys.getAccesstoken2(),3502213525503956L,5);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

				@Override
				public Object onCompleted(Response response) throws Exception {
					assertNotNull(response.getResponseBody());
					HomeTimelineOutput output = new HomeTimelineOutput();
					output.fromHttpResponse(response, null);
					assertEquals(((HomeTimelineOutput) output)
							.getStatuses().size(), 5);
					assertTrue(output.outputOK());
					assertFalse(output.needRetry());
					assertFalse(output.needLog());
					return output;
				}
			});
			future.get();
		} catch (Exception e) {
		}
	}
	
	@Test
	public void test3() {
		SinaOauth2Input input= new HomeTimelineInput(SinaTestKeys.getAccesstoken2(),10);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

				@Override
				public Object onCompleted(Response response) throws Exception {
					assertNotNull(response.getResponseBody());
					HomeTimelineOutput output = new HomeTimelineOutput();
					output.fromHttpResponse(response, null);
					assertEquals(((HomeTimelineOutput) output)
							.getStatuses().size(), 10);
					assertTrue(output.outputOK());
					assertFalse(output.needRetry());
					assertFalse(output.needLog());
					return output;
				}
			});
			future.get();
		} catch (Exception e) {
		}
	}
}
