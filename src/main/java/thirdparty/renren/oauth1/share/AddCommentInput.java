/**
 * 
 */
package thirdparty.renren.oauth1.share;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.feed.PublishFeed.java
 *
 * date		| author	| version	|  
 * 2012-11-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.renren.oauth1.RenrenInput;

/**
 * @author	shangrenpeng
 * @date	2012-11-20 下午12:18:52
 *
 */
@SuppressWarnings("unused")
public class AddCommentInput extends RenrenInput {
	private String access_token;
	private static String method = "share.addComment";
	private String user_id;
	private String share_id;
	private String content;
	private String to_user_id;
	
	/**发布一条纯文字的内容
	 * @param access_token
	 * @param user_id
	 * @param content
	 * @param share_id 其实就是post_id
	 */
	public AddCommentInput(String access_token,String user_id, String content,  String share_id){
		this.access_token = access_token;
		this.content = content;
		this.user_id = user_id;
		this.share_id = share_id;
		
		//业务参数
		bodyArgs.add(new Arg("content", content));
		bodyArgs.add(new Arg("user_id", user_id));
		bodyArgs.add(new Arg("share_id", share_id));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
