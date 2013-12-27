/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth1.SinaOauth1Input;

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
public class RepostInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/repost.json"; 
	
	private long id;//要转发的微博ID
	private String status;//添加的转发文本。必须做URLEncode,信息内容不超过140个汉字。如不填则默认为“转发微博”。
	private int is_comment;//是否在转发的同时发表评论。0表示不发表评论，1表示发表评论给当前微博，2表示发表评论给原微博，3是1、2都发表。默认为0。  
	
	public RepostInput1(String accessToken, String accessSecret, String status, long id){
		this.id = id;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.userAccessToken = new AccessToken(accessToken, accessSecret);
		bodyArgs.add(new Arg("status", this.status));
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
