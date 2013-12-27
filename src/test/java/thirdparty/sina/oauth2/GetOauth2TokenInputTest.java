/**
 * 
 */
package thirdparty.sina.oauth2;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth1.SinaOauth1Input;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.GetOauth2TokenInputTest.java
 *
 * date		| author	| version	|  
 * 2012-10-18	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-10-18 下午8:19:51
 *
 */
public class GetOauth2TokenInputTest {
	@Test
	public void test() {
		SinaOauth1Input input= new GetOauth2TokenInput(SinaTestKeys.getAccesstoken(),SinaTestKeys.getAccessSecret());
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

				@Override
				public Object onCompleted(Response response) throws Exception {
					return response;
				}
			});
            Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            GetOauth2TokenOutput output = new GetOauth2TokenOutput();
            output.fromHttpResponse(response, null);
            assertNotNull(output.getAccess_token());
            assertNotNull(output.getRefresh_token());
		} catch (Exception e) {
		}
	}

}
