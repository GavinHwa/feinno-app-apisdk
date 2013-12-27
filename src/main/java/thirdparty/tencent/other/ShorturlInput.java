/**
 * 
 */
package thirdparty.tencent.other;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.other.ShorturlInput.java
 *
 * date		| author	| version	|  
 * 2012-12-13	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.tencent.TencentInput;

/**
 * @author	shangrenpeng
 * @date	2012-12-13 下午4:47:57
 *
 */
@SuppressWarnings("unused")
public class ShorturlInput  extends TencentInput {

	final private static String apiURL = "http://open.t.qq.com/api/other/shorturl";
	private String url;//短url后辍	

	ShorturlInput(String access_token,String access_secret,String url){
		this.url = url;
		this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("url", url));
		bodyArgs.add(new Arg("format",format));
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,apiURL,bodyArgs,
				userAccessToken);
	}
	
	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}

}
