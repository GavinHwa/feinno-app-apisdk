/**
 * 
 */
package thirdparty.tencent.t;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.t.ReListInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-12-11 下午7:27:01
 * 
 */
public class ReListInputTest {

	@Test
	public void test() {
		ReListInput input = new ReListInput("3d733cc971944b9286fa5696ee762a71",
				"5deb276d15f5ea8ef33b1f949eb9f4d2", "173373110203362");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							ReListOutput output = new ReListOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}

		input = new ReListInput("3d733cc971944b9286fa5696ee762a71",
				"5deb276d15f5ea8ef33b1f949eb9f4d2", "173373110203362",1355213120L,"133345079590466");
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							ReListOutput output = new ReListOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}
}
