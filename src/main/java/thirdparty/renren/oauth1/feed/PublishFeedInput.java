/**
 * 
 */
package thirdparty.renren.oauth1.feed;

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
public class PublishFeedInput extends RenrenInput {
	private String access_token;
	private static String method = "feed.publishFeed";
	private static String name = "飞信新鲜事";
	private static String description = " ";
	private String url;
	private String message;
	private String image;
	private String caption;
	private static String action_name = "更多飞信新鲜事";
	private String action_link;
	
	/**发布一条纯文字的内容
	 * @param access_token
	 * @param message
	 * @param userId
	 */
	public PublishFeedInput(String access_token,String message,int userId){
		this.access_token = access_token;
		this.url = "http://i.feixin.10086.cn/" + userId;
		this.action_link = "http://i.feixin.10086.cn/" + userId;
		this.message = message;
		//业务参数
		bodyArgs.add(new Arg("name", name));
		bodyArgs.add(new Arg("description", description));
		bodyArgs.add(new Arg("url", url));
		bodyArgs.add(new Arg("message", message));
		bodyArgs.add(new Arg("action_name", action_name));
		bodyArgs.add(new Arg("action_link", action_link));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
	
	/**
	 * 发布一条带有图片的内容
	 * @param access_token
	 * @param message
	 * @param picUrl
	 * @param userId
	 */
	public PublishFeedInput(String access_token, String message, String picUrl,
			int userId) {
		this.access_token = access_token;
		this.url = "http://i.feixin.10086.cn/" + userId;
		this.action_link = "http://i.feixin.10086.cn/" + userId;
		this.image = picUrl;
		this.message = message;
		//业务参数
		bodyArgs.add(new Arg("name", name));
		bodyArgs.add(new Arg("description", description));
		bodyArgs.add(new Arg("url", url));
		bodyArgs.add(new Arg("message", message));
		bodyArgs.add(new Arg("image", image));
		bodyArgs.add(new Arg("action_name", action_name));
		bodyArgs.add(new Arg("action_link", action_link));
		//通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
