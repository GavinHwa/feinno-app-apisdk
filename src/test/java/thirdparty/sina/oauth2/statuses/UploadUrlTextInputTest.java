/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import thirdparty.sina.SinaTestKeys;
import org.junit.Test;

import thirdparty.sina.oauth2.SinaOauth2Input;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UploadUrlTextInputTest.java
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
 * @date	2012-10-19 下午7:50:09
 *
 */
public class UploadUrlTextInputTest {

	@Test
	public void test() {
		final String text="这是飞信同步测试，新浪的工作人员请不要删除！";
		SinaOauth2Input input = new UploadUrlTextInput(
                SinaTestKeys.getAccesstoken2(), text,"http://i-imgp.fetionpic.com/fpic/pic1/M00/FF/EE/rBUyIlHe1_jTtCvPAAAN0bGptwE527.jpg");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							return response;
						}
					});
			Response response = (Response)future.get();
            assertNotNull(response.getResponseBody());
            UploadUrlTextOutput output = new UploadUrlTextOutput();
            output.fromHttpResponse(response, null);
            assertEquals(output.getText(), text);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
		} catch (Exception e) {
		}
	}

}
