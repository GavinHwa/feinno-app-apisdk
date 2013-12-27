/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import thirdparty.sina.SinaTestKeys;
import org.junit.Test;

import thirdparty.sina.oauth2.SinaOauth2Input;
import com.ning.http.client.AsyncCompletionHandler;
import com.ning.http.client.AsyncHttpClient;
import com.ning.http.client.AsyncHttpClientConfigBean;
import com.ning.http.client.ListenableFuture;
import com.ning.http.client.Request;
import com.ning.http.client.Response;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UploadInputTest.java
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
 * @date	2012-10-19 下午6:31:31
 *
 */
public class UploadInputTest {

	@Test
	public void test() {
		byte[] pic = { -1, -40, -1, -32, 0, 16, 74, 70, 73, 70, 0, 1, 2, 0, 0,
				100, 0, 100, 0, 0, -1, -20, 0, 17, 68, 117, 99, 107, 121, 0, 1,
				0, 4, 0, 0, 0, 70, 0, 0, -1, -18, 0, 14, 65, 100, 111, 98, 101,
				0, 100, -64, 0, 0, 0, 1, -1, -37, 0, -124, 0, 4, 3, 3, 3, 3, 3,
				4, 3, 3, 4, 6, 4, 3, 4, 6, 7, 5, 4, 4, 5, 7, 8, 6, 6, 7, 6, 6,
				8, 10, 8, 9, 9, 9, 9, 8, 10, 10, 12, 12, 12, 12, 12, 10, 12,
				12, 13, 13, 12, 12, 17, 17, 17, 17, 17, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 1, 4, 5, 5, 8, 7, 8, 15, 10, 10, 15, 20, 14,
				14, 14, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20,
				20, 20, 20, 20, -1, -64, 0, 17, 8, 0, 50, 0, 50, 3, 1, 17, 0,
				2, 17, 1, 3, 17, 1, -1, -60, 0, 111, 0, 0, 2, 3, 1, 0, 3, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 3, 4, 5, 7, 1, 2, 8, 1, 1, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 1, 3, 3, 2, 4,
				2, 8, 7, 0, 0, 0, 0, 0, 0, 0, 1, 0, 2, 3, 17, 49, 4, 33, 5, 97,
				18, 50, 6, -127, 34, -16, 65, -111, -79, -63, -47, -31, 19, 82,
				98, 114, 83, 20, 53, -107, 17, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, -1, -38, 0, 12, 3, 1, 0, 2, 17, 3, 17, 0, 63,
				0, -6, 65, 0, -126, -2, 30, -49, -97, -100, 57, -95, -114,
				-111, -2, -29, -4, -83, 65, -91, 47, 106, 100, -74, 62, 104,
				-91, 107, -92, -90, -84, 58, 107, -64, -96, -62, -102, 25, 113,
				-28, 116, 51, 52, -78, 70, -35, -91, 4, 104, 4, 2, 13, -18,
				-35, -38, 91, -106, -13, -105, -112, -38, -63, 25, -93, 26,
				108, -25, 124, -126, 7, 0, 0, 0, 1, 64, 44, 16, 8, 49, -73,
				-19, -92, 103, 67, -4, -120, -88, 50, 98, 30, -67, 57, -102,
				53, 33, 2, 82, 1, 0, -125, -96, 108, -51, 107, 54, -52, 96,
				-45, 80, 88, 15, -119, -44, -96, -68, -128, 65, -31, -51, 107,
				-38, -26, 56, 85, -82, 4, 17, -64, -96, -26, -39, 12, -5, 115,
				-55, 24, 20, 13, 113, 20, -67, -118, 8, -48, 8, 28, 59, 91, 32,
				-55, -124, -8, 28, 106, 97, 118, -125, -14, -69, 95, 125, 80,
				111, 32, 16, 69, -109, 48, -57, -126, 73, -35, 104, -38, 93,
				-81, 0, -125, -99, 79, 41, -98, 105, 38, 32, 3, 35, -117, -120,
				22, -44, -96, -115, 0, -126, -26, -35, -72, 73, -73, -52, -23,
				99, 39, -52, -34, 82, 5, -118, 7, -36, 108, -122, 101, 99, -57,
				-111, 25, -85, 36, 104, 35, -30, 16, 74, -127, 127, -70, 115,
				29, 22, 52, 120, -84, 52, 51, 26, -65, -12, -73, -22, -127, 69,
				0, -125, 127, 96, -39, -30, -51, -114, 73, -14, -29, 38, 30,
				-104, -115, 72, -87, 23, -78, 13, 121, 123, 107, 108, -110,
				-100, -83, 116, 116, -4, 38, -2, -44, 26, 24, 88, 112, -32, 66,
				32, -126, -65, 110, -75, -13, 26, -22, 80, 88, 65, 71, 116,
				-37, 33, -36, -31, 17, -56, 75, 30, -61, 86, 60, 92, 112, 64,
				-117, 62, 44, -8, -14, 62, 57, 35, 115, 92, -62, 65, -88, 65,
				10, 7, -3, -105, -6, -68, 91, 116, 14, -97, 75, -96, -66, -128,
				64, 32, 16, 122, 73, -48, -18, -101, 30, -85, 120, -96, 93, -1,
				0, 50, -24, 63, -1, -39 };
		final String text="这是飞信同步转发测试，新浪的工作人员请不要删除！"+new Random().nextInt(50);
		SinaOauth2Input input = new UploadInput(
                SinaTestKeys.getAccesstoken2(),text, pic);
		Request request = input.toHttpRequest();
		AsyncHttpClientConfigBean config = new AsyncHttpClientConfigBean();
        config.setIdleConnectionInPoolTimeoutInMs(6000);
        config.setRequestTimeoutInMs(40000);
		config.setAllowPoolingConnection(false);
        config.setAllowSslConnectionPool(false);//好像不开这个就会发不出去图
        config.setCompressionEnabled(true);
        config.setRequestCompressionLevel(6);
        config.setMaxRequestRetry(0);
		AsyncHttpClient httpClient = new AsyncHttpClient(config);
		try {
			ListenableFuture<Object> future = httpClient.executeRequest(request,
					new AsyncCompletionHandler<Object>() {
				
						@Override
						public Object onCompleted(Response response)
								throws Exception {
							return response;
						}
						
					});
            Response response = (Response) future.get();
            assertNotNull(response.getResponseBody());
            UploadOutput output = new UploadOutput();
            output.fromHttpResponse(response, null);
            assertEquals(output.getText(), text);
            assertTrue(output.outputOK());
            assertFalse(output.needRetry());
            assertFalse(output.needLog());
		} catch (Exception e) {
		}
	}

}
