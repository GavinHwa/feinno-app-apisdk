/**
 * 
 */
package thirdparty.sina.oauth2.users;


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
public class ShowInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/users/show.json";
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private long uid;//需要获取消息未读数的用户UID，必须是当前登录用户。
	private String screen_name;//需要查询的用户昵称。
	
	public ShowInput(long uid,String access_token){
        this.uid = uid;
        this.access_token = access_token;
		httpMethod = "GET";

        bodyArgs.add(new Arg("access_token", access_token));
        bodyArgs.add(new Arg("uid", String.valueOf(uid)));

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
