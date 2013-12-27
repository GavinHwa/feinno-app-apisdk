/**
 * 
 */
package thirdparty.renren.oauth1.status;


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
	private static String method = "status.addComment";
	private String status_id;
	private String owner_id;
	private String content;
	private String rid;
	
	/**发布一条纯文字的内容
	 * @param access_token
	 * @param content
	 * @param status_id//这个是source_id
	 * @param owner_id
	 */
	public AddCommentInput(String access_token,String content, String status_id, String owner_id){
		this.access_token = access_token;
		this.content = content;
		this.status_id = status_id;
		this.owner_id = owner_id;
		
		//业务参数
		bodyArgs.add(new Arg("content", content));
		bodyArgs.add(new Arg("status_id", status_id));
		bodyArgs.add(new Arg("owner_id", owner_id));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
