/**
 * 
 */
package thirdparty.tencent.statuses;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.statuses.SubReListInputTest.java
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
 * @date	2012-12-11 下午7:43:12
 *
 */
public class SubReListInputTest {

	@Test
	public void test() {
		SubReListInput input = new SubReListInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(), "211215094799768");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							SubReListOutput output = new SubReListOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}

		input = new SubReListInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(), "211215094799768",1355213120L,"133345079590466");
		request = input.toHttpRequest();
		httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							SubReListOutput output = new SubReListOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}

}
