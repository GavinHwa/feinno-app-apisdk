/**
 * 
 */
package thirdparty.sina.oauth2.direct_messages;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.shorturl.ExpandOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-28	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author	shangrenpeng
 * @date	2012-9-28 下午3:36:45
 *
 */
@SuppressWarnings("unused")
public class NewInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/direct_messages/new.json";
	
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private String text;
	private Long uid;
	
	public NewInput(String access_token,String text,Long uid){		
		this.access_token = access_token;	
		this.text = text;
		this.uid = uid;
		bodyArgs.add(new Arg("uid", String.valueOf(uid)));
		bodyArgs.add(new Arg("text", text));
		bodyArgs.add(new Arg("access_token", access_token));
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
