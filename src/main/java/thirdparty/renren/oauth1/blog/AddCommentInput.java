/**
 * 
 */
package thirdparty.renren.oauth1.blog;


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
	private static String method = "blog.addComment";
	private String id;
	private String uid;
	private String page_id;
	private String content;
	private String rid;
	private String type;
	
	/**发布一条纯文字的内容
	 * @param access_token
	 * @param uid
	 * @param id
     * @param content
	 */
	public AddCommentInput(String access_token,String id,String uid, String content){
		this.access_token = access_token;
		this.content = content;
		this.id = id;
		this.uid = uid;
		
		//业务参数
		bodyArgs.add(new Arg("id", id));
		bodyArgs.add(new Arg("uid", uid));
		bodyArgs.add(new Arg("content", content));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
