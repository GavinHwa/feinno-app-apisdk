/**
 * 
 */
package thirdparty.kaixin.records;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.kaixin.emotion.Show.java
 *
 * date		| author	| version	|  
 * 2012-12-3	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.kaixin.KaixinInput;
import thirdparty.oauth.AccessToken;

/**
 * @author	shangrenpeng
 * @date	2012-12-3 下午4:21:36
 * TODO
 */
public class AddInput extends KaixinInput {
	
	private static String apiURL = "http://api.kaixin001.com/emotion/show.json";

	public AddInput(String accessKey, String accessSecret) {
		httpMethod = "GET";
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
