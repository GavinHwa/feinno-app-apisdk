/**
 * 
 */
package thirdparty.tencent;

import config.MessageConfig;
import thirdparty.Input;
import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.oauth.OAuthTencent;

import java.util.Iterator;

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
public abstract class TencentInput extends Input {
	protected static final String appkey = MessageConfig.tencentAppKey;// 采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
	
	protected static final OAuthTencent oauthHelper = new OAuthTencent(appkey, MessageConfig.tencentAppSecret);
	
	protected static final String format = "json";
	
	protected final static String seperator = "&";
	
	protected AccessToken userAccessToken;

	/* (non-Javadoc)
	 * @see thirdparty.Input#reNewInput()
	 */
	@Override
	public void reNewInput() {
		Iterator<Arg> iterator = bodyArgs.iterator();
		while (iterator.hasNext()) {
			Arg arg = (Arg) iterator.next();
			try {
				if (arg.getName().contains("oauth_")){
					iterator.remove();
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		}
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,getUrl(),bodyArgs,
				userAccessToken);
	}
}
