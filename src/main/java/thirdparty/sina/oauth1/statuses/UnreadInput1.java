/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.oauth1.SinaOauth1Input;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UpdateOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午12:03:09
 * 
 */
@SuppressWarnings("unused")
public class UnreadInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/unread.json";

	private int with_new_status;//1表示结果中包含new_status字段，0表示结果不包含new_status字段。new_status字段表示是否有新微博消息，1表示有，0表示没有
	private long since_id;//参数值为微博id。该参数需配合with_new_status参数使用，返回since_id之后，是否有新微博消息产生 

	private List<Arg> args = new LinkedList<Arg>(); 

	public UnreadInput1(String accessKey, String accessSecret) {
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
