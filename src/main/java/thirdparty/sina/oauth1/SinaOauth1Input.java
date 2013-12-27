/**
 * 
 */
package thirdparty.sina.oauth1;

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
public abstract class SinaOauth1Input extends Input {
	protected static String source = MessageConfig.sinaAppKey;// 采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
	
	protected static OauthHelperOne oauthHelper = new OauthHelperOne(source, MessageConfig.sinaAppSecret);
	
	protected final static String seperator = ",";
	
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
