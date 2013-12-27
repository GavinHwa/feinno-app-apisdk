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
public class GetInput extends RenrenInput {
	private String access_token;
	private static String method = "photos.get";
	private String uid;//照片所有者的用户ID
	private long aid;//相册的id。aid和pids至少传递一个
	private String pids;// 照片id串，以分","割，最多20个。aid和pids至少传递一个，传递pids则无需传递page和count参数
	private String password;// 加密相册的密码。如果相册为加密相册，传递此参数。
	private int page;// 页码，默认值为1，必须大于0，无上限
	private int count;// 每页的容量，默认值为10，必须大于0，小于200 
	
	public GetInput(String access_token,String uid,long aid){
		this.access_token = access_token;
		this.uid = uid;
		this.aid = aid;
		
		//业务参数
		bodyArgs.add(new Arg("uid", uid));
		bodyArgs.add(new Arg("aid", String.valueOf(aid)));
		
		//通用参数
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
	
	public GetInput(String access_token,String uid,String pid){
		this.access_token = access_token;
		this.uid = uid;
		this.pids = pid;
		
		//业务参数
		bodyArgs.add(new Arg("uid", uid));
		bodyArgs.add(new Arg("pids", pids));
		
		//通用参数
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
