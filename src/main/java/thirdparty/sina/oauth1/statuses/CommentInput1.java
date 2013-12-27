/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.sina.oauth1.SinaOauth1Input;
import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;

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
public class CommentInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/comment.json"; 
	
	private long id;//要评论的微博消息ID
	private String comment;//评论内容。必须做URLEncode,信息内容不超过140个汉字。
	private long cid;//要回复的评论ID。
	private int without_mention;//1：回复中不自动加入“回复@用户名”，0：回复中自动加入“回复@用户名”.默认为0.
	private int comment_ori;//当评论一条转发微博时，是否评论给原微博。0:不评论给原微博。1：评论给原微博。默认0. 
	
	public CommentInput1(String accessToken, String accessSecret, String comment, long id){
		this.id = id;
		this.comment = SinaEmotionTransformer.transform2Sina(comment);
		this.userAccessToken = new AccessToken(accessToken, accessSecret);
		bodyArgs.add(new Arg("comment", this.comment));
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
