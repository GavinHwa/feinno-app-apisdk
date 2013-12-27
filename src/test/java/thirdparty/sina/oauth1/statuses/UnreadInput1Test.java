/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth1.statuses.UnreadInput1Test.java
 *
 * date		| author	| version	|  
 * 2013-1-21	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-21 上午9:45:50
 *
 */
public class UnreadInput1Test {

	@Test
	public void test() {
			UnreadInput1 input = new UnreadInput1(
                    SinaTestKeys.getAccesstoken(),
					SinaTestKeys.getAccessSecret());
//			input.setDebug(true);
			Request request = input.toHttpRequest();
			AsyncHttpClient httpClient = new AsyncHttpClient();

			try {
				ListenableFuture<Object> future = httpClient.executeRequest(
						request, new AsyncCompletionHandler<Object>() {

							@Override
							public Object onCompleted(Response response)
									throws Exception {
								assertNotNull(response.getResponseBody());
								UnreadOutput1 output = new UnreadOutput1();
								output.fromHttpResponse(response, null);

								return output;
							}
						});
				future.get();
			} catch (Exception e) {
				
		}
	}
}
