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
public class RepostInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/statuses/repost.json";
	private String access_token;//用户的token
	private long id;//要转发的微博ID。
	private String status;//添加的转发文本，必须做URLencode，内容不超过140个汉字，不填则默认为“转发微博”。
	private int is_comment;//是否在转发的同时发表评论，0：否、1：评论给当前微博、2：评论给原微博、3：都评论，默认为0 。 
	
	public RepostInput(String access_token,String status,long id){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.id = id;

		bodyArgs.add(new Arg("status", this.status));
		bodyArgs.add(new Arg("id", String.valueOf(id)));
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
