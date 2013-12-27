/**
 * 
 */
package thirdparty.rss;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.rss.RssInput;
import thirdparty.rss.RssOutput;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.rss.RssInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-3	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-3 下午12:15:37
 *
 */
public class RssInputTest {

	@Test
	public void test() {
		RssInput input= new RssInput("http://www.fqpai.com/feed");
		Request request = input.toHttpRequest();
		AsyncHttpClient httpClient = new AsyncHttpClient();
		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {				
				@Override
				public Object onCompleted(Response response) throws Exception {
					assertNotNull(response.getResponseBody());
					RssOutput output = new RssOutput("//item", "title", "content:encoded", "pubdate");
					output.fromHttpResponse(response, null);
					assertTrue(output.outputOK());
					return output;
				}
			});
			future.get();
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
