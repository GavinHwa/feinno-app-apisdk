/**
 * 
 */
package thirdparty.tencent.other;

import com.ning.http.client.*;
import org.junit.Test;
import thirdparty.tencent.TencentTestKeys;

import static org.junit.Assert.assertNotNull;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.other.GetEmotionsInputTest.java
 *
 * date		| author	| version	|  
 * 2012-11-21	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-11-21 下午1:01:54
 *
 */
public class GetEmotionsInputTest {

	@Test
	public void test() {
		for(int i = 0; i <= 17; i++){
			GetEmotionsInput input= new GetEmotionsInput(TencentTestKeys.getAccesstoken(),TencentTestKeys.getAccessSecret(),i);
			Request request = input.toHttpRequest();
			AsyncHttpClient httpClient = new AsyncHttpClient();

			try {
				ListenableFuture<Object> future = httpClient.executeRequest(request,new AsyncCompletionHandler<Object>() {

					@Override
					public Object onCompleted(Response response) throws Exception {					
						assertNotNull(response.getResponseBody());
						GetEmotionsOutput output = new GetEmotionsOutput();
						output.fromHttpResponse(response, null);
				
						return output;
					}
				});
				future.get();
//				GetEmotionsOutput output = (GetEmotionsOutput )future.get();
//				List<Arg> temp = output.getEmotions();
//				
//				Properties websiteDB = CommonConfig
//						.getWebsiteDBProperties();
//				Database fetionwebsiteDB = DatabaseManager.getDatabase(
//						"fetionwebsiteDB", websiteDB);
//				
//				String sqlFmt = "insert into FW_ThirdPartyEmotions (Tag,ServiceId,Url) values (?,?,?)";
//				
//				for (Arg arg : temp) {
//					try{
//						fetionwebsiteDB.executeInsertWithAutoColumn(sqlFmt,"/" + arg.getName(),4,arg.getValue());
//					}catch (Exception e) {
//						System.out.print(arg.getName());
//						System.out.println(" " + e.getMessage());
//					}
//				}
			} catch (Exception e) {
			} 
		}
	}

}
