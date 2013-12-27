/**
 * 
 */
package thirdparty.tencent.t;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import java.util.Random;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.t.CommentInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-10 下午7:27:27
 *
 */
public class CommentInputTest {
	
	@Test
	public void test() {
		final String text = "这是飞信同步评论测试，腾讯的工作人员请不要删除！";
		CommentInput input = new CommentInput(
                TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret(), text
						+ new Random().nextInt(50),
				"10.10.175.202","173373110203362");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(
					request, new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							AddOutput output = new AddOutput();
							output.fromHttpResponse(response, null);

							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}

}
