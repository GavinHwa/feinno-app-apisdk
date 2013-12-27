/**
 * 
 */
package thirdparty.kaixin;

import config.MessageConfig;
import thirdparty.Input;
import thirdparty.oauth.AccessToken;
import thirdparty.oauth.OauthHelperOne;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.SinaOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午6:17:46
 *
 */
public abstract class KaixinInput extends Input {
	protected static String api_key = MessageConfig.kaixinAppKey;//申请应用时分配的api_key，调用接口时候代表应用的唯一身份
	protected static String client_secret = MessageConfig.kaixinAppSecret;
	protected static String seperator = ",";
	protected static OauthHelperOne oauthHelper = new OauthHelperOne(api_key, client_secret);
	
	protected AccessToken userAccessToken;

	/* (non-Javadoc)
	 * @see thirdparty.Input#reNewInput()
	 */
	@Override
	public void reNewInput() {
		headers.clear();
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, getUrl(),bodyArgs,
				seperator, userAccessToken));
	}
}
