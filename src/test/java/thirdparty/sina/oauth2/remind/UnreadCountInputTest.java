/**
 * 
 */
package thirdparty.sina.oauth2.remind;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.remind.UnreadCountInputTest.java
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
 * @date	2012-10-19 下午3:28:40
 *
 */
public class UnreadCountInputTest {

	@Test
	public void test() {
		SinaOauth2Input input= new UnreadCountInput(SinaTestKeys.getAccesstoken2());
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

				@Override
				public Object onCompleted(Response response) throws Exception {
					assertNotNull(response.getResponseBody());
					UnreadCountOutput output = new UnreadCountOutput();
					output.fromHttpResponse(response, null);					
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
