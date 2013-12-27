/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.CreateInputTest.java
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
 * @date	2012-10-19 下午5:01:11
 *
 */
public class CreateInputTest {

	@Test
	public void test() {
		final String text="这是飞信同步评论测试，新浪的工作人员请不要删除！";
		SinaOauth2Input input= new CreateInput(SinaTestKeys.getAccesstoken2(),text + new Random().nextInt(50),3502213525503956L);
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
            CreateOutput output = new CreateOutput();
            output.fromHttpResponse(response, null);
            assertEquals(output.getText(), text);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
		} catch (Exception e) {
		}
	}

}
