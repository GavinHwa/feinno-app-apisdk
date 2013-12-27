/**
 * 
 */
package thirdparty.sina.oauth2;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.Emotions.java
 *
 * date		| author	| version	|  
 * 2012-11-15	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import config.MessageConfig;
import thirdparty.oauth.Arg;

/**
 * @author	shangrenpeng
 * @date	2012-11-15 上午10:47:17
 *
 */
@SuppressWarnings("unused")
public class RefreshTokenInput extends SinaOauth2Input{
	
	final private static String apiURL = "https://api.weibo.com/oauth2/access_token";
	private String client_id = source;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private String client_secret = MessageConfig.sinaAppSecret;//app secret
	private String grant_type = "refresh_token";//刷新的方式
	private String refresh_token;//刷新token
	
	public RefreshTokenInput(String refresh_token){
		this.refresh_token = refresh_token;
	
		bodyArgs.add(new Arg("client_id", client_id));
		bodyArgs.add(new Arg("client_secret", client_secret));
		bodyArgs.add(new Arg("grant_type", grant_type));
		bodyArgs.add(new Arg("refresh_token", refresh_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
