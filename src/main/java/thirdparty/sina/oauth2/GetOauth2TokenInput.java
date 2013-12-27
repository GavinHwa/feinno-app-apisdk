/**
 * 
 */
package thirdparty.sina.oauth2;

import thirdparty.sina.oauth1.SinaOauth1Input;
import thirdparty.oauth.AccessToken;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth1.statuses.CommentInput.java
 *
 * date		| author	| version	|  
 * 2012-10-18	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-10-18 下午2:37:58
 *
 */
public class GetOauth2TokenInput extends SinaOauth1Input {
	private static final String apiURL = "https://api.weibo.com/oauth2/get_oauth2_token"; 
	
	public GetOauth2TokenInput(String accessToken, String accessSecret){
		this.userAccessToken = new AccessToken(accessToken, accessSecret);
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader(httpMethod, apiURL,bodyArgs,
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
