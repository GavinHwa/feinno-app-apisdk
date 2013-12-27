/**
 * 
 */
package thirdparty.renren.oauth1.photos;


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
	private static String method = "photos.addComment";
	private String uid;
	private String content;
	private String aid;
	private String pid;
	private String rid;
	private String type;
	
	/**发布一条纯文字的内容
	 * @param access_token
	 * @param content
	 * @param pid
	 */
	public AddCommentInput(String access_token,String uid,  String pid, String content){
		this.access_token = access_token;
		this.content = content;
		this.uid = uid;
		this.pid = pid;
		
		//业务参数
		bodyArgs.add(new Arg("content", content));
		bodyArgs.add(new Arg("uid", uid));
		bodyArgs.add(new Arg("pid", pid));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
