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
public class MessInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/direct_messages.json";
	
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private Long sina_Id;
	
	
	public MessInput(String access_token,Long sina_Id){	
		httpMethod = "GET";
		this.access_token = access_token;	
		this.sina_Id = sina_Id;		
		bodyArgs.add(new Arg("sina_Id", String.valueOf(sina_Id)));
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
