/**
 * 
 */
package thirdparty.tencent.info;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.info.UpdateInputTest.java
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
 * @date	2012-12-11 下午8:08:52
 *
 */
public class UpdateInputTest {

	@Test
	public void test() {
		UpdateInput input = new UpdateInput(
                TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret());
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UpdateOutput output = new UpdateOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}

}
