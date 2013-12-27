/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.sina.oauth1.SinaOauth1Input;
import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;

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
@SuppressWarnings("unused")
public class CommentsInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/comments.json"; 
	
	private long id;//指定要获取的评论列表所属的微博消息ID
	private int count;//单页返回的记录条数。
	private int page;//返回结果的页码。  
	
	public CommentsInput1(String accessToken, String accessSecret, long id){
		httpMethod = "GET";
		this.id = id;
		this.userAccessToken = new AccessToken(accessToken, accessSecret);
		bodyArgs.add(new Arg("id", Long.toString(id)));
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
