/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;
import thirdparty.sina.oauth2.SinaOauth2Input;

import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.*;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UpdateInputTest.java
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
 * @date	2012-10-19 下午6:14:08
 *
 */
public class UpdateInputTest {

	@Test
	public void test() {
		final String text="这是飞信同步转发测试，新浪的工作人员请不要删除！"+new Random().nextInt(50);
		SinaOauth2Input input = new UpdateInput(SinaTestKeys.getAccesstoken2()
				, text);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UpdateOutput output = new UpdateOutput();
							output.fromHttpResponse(response, null);
							assertEquals(output.getText(), text);
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
	
	@Test
	public void test1() {
		SinaOauth2Input input = new UpdateInput(
				SinaTestKeys.getAccesstoken2(), "这是飞信同步测试，新浪的工作人员请不要删除！"
						+ new Random().nextInt(50),"{test:\"test\"}");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UpdateOutput output = new UpdateOutput();
							output.fromHttpResponse(response, null);
							System.out.println(response.getResponseBody());
							System.out.println(output.getCreated_at());
							return output;
						}
					});
			Thread.sleep(5000);
		} catch (IOException e) {
		} catch (InterruptedException e) {
		}
	}

	@Test
	public void test2() {
		SinaOauth2Input input = new UpdateInput(
				SinaTestKeys.getAccesstoken2(), "这是飞信同步测试，新浪的工作人员请不要删除！"
						+ new Random().nextInt(50),45,45);
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UpdateOutput output = new UpdateOutput();
							output.fromHttpResponse(response, null);
							System.out.println(response.getResponseBody());
							System.out.println(output.getCreated_at());
							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}
	

	@Test
	public void test3() {
		SinaOauth2Input input = new UpdateInput(
				SinaTestKeys.getAccesstoken2(), "这是飞信同步测试，新浪的工作人员请不要删除！"
						+ new Random().nextInt(50),45,45,"{test:\"test\"}");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();

		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {

						@Override
						public Object onCompleted(Response response)
								throws Exception {
							assertNotNull(response.getResponseBody());
							UpdateOutput output = new UpdateOutput();
							output.fromHttpResponse(response, null);
							System.out.println(response.getResponseBody());
							System.out.println(output.getCreated_at());
							return output;
						}
					});
			future.get();
		} catch (Exception e) {
		}
	}
}
