/**
 * 
 */
package thirdparty.tencent.other;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.other.ShorturlInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-13	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-13 下午4:54:13
 *
 */
public class ShorturlInputTest {

	@Test
	public void test() {
		ShorturlInput input = new ShorturlInput(TencentTestKeys.getAccesstoken(),
                TencentTestKeys.getAccessSecret(), "http://url.cn/8ZortB");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							ShorturlOutput output = new ShorturlOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}

}
