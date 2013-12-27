/**
 * 
 */
package thirdparty.sina.oauth2;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.sina.SinaTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.RefreshTokenInputTest.java
 *
 * date		| author	| version	|  
 * 2012-12-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-4 下午5:38:33
 *
 */
public class RefreshTokenInputTest {

	@Test
	public void test() {
		RefreshTokenInput input= new RefreshTokenInput(SinaTestKeys.getAccessSecret2());
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
            RefreshTokenOutput output = new RefreshTokenOutput();
            output.fromHttpResponse(response, null);
            System.out.println(output.getAccessToken());
            System.out.println(output.getRefreshToken());

//			EmotionsOutput output = (EmotionsOutput) future.get();
//			
//			List<Arg> temp = output.getEmotions();
//			
//			Properties websiteDB = CommonConfig
//					.getWebsiteDBProperties();
//			Database fetionwebsiteDB = DatabaseManager.getDatabase(
//					"fetionwebsiteDB", websiteDB);
//			
//			String sqlFmt = "insert into FW_ThirdPartyEmotions (Tag,ServiceId,Url) values (?,?,?)";
//			
//			for (Arg arg : temp) {
//				try{
//					fetionwebsiteDB.executeInsertWithAutoColumn(sqlFmt,arg.getName(),2,arg.getValue());
//				}catch (Exception e) {
//					System.out.print(arg.getName());
//					System.out.println(" " + e.getMessage());
//				}
//			}
		} catch (Exception e) {
		}
	}
}
