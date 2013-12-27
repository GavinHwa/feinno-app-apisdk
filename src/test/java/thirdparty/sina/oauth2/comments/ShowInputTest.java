/**
 * 
 */
package thirdparty.sina.oauth2.comments;

import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;
import com.ning.http.client.*;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.comments.ShowInputTest.java
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
 * @date	2012-10-18 下午7:54:35
 *
 */
public class ShowInputTest {

	@Test
	public void test() {
		SinaOauth2Input input= new ShowInput(SinaTestKeys.getAccesstoken2(),3502213525503956L);
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
            ShowOutput output = new ShowOutput();
            output.fromHttpResponse(response, null);
            assertNotNull(output.getComments().get(0).getText());
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
		} catch (Exception e) {
		}
	}

}
