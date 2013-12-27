/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


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

import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午12:03:09
 *
 */
@SuppressWarnings("unused")
public class CreateInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/comments/create.json";
	private String access_token;//用户的token
	private String comment;//评论内容，必须做URLencode，内容不超过140个汉字。
	private long id;//需要评论的微博ID。
	private int comment_ori;//当评论转发微博时，是否评论给原微博，0：否、1：是，默认为0。 
	
	public CreateInput(String access_token,String comment,long id){
		this.access_token = access_token;
		this.comment = SinaEmotionTransformer.transform2Sina(comment);
		this.id = id;
		
		bodyArgs.add(new Arg("access_token", access_token));
		bodyArgs.add(new Arg("comment", this.comment));
		bodyArgs.add(new Arg("id", String.valueOf(id)));
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
