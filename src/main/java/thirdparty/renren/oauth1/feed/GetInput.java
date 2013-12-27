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
 * @author shangrenpeng
 * @date 2012-11-20 下午12:18:52
 * 
 */
@SuppressWarnings("unused")
public class GetInput extends RenrenInput {
	private String access_token;
	private static String method = "feed.get";
	private static final String type = "10,20,21,30,32,33,50,51";
	// 10-更新状态的新鲜事；11-page更新状态的新鲜事
	// ；20-发表日志的新鲜事；21-分享日志的新鲜事；22-page发表日志的新鲜事；23-page分享日志的新鲜事；30-上传照片的新鲜事；
	// 31-page上传照片的新鲜事；32-分享照片的新鲜事；33-分享相册的新鲜事；34-修改头像的新鲜事；35-page修改头像的新鲜事；
	// 36-page分享照片的新鲜事；40-成为好友的新鲜事；41-成为page粉丝的新鲜事；50-分享视频的新鲜事；51-分享链接的新鲜事；
	// 52-分享音乐的新鲜事；53-page分享视频的新鲜事；54-page分享链接的新鲜事；55-page分享音乐的新鲜事。
	private String uid;// 支持传入当前用户的一个好友ID,表示获取此好友的新鲜事，如果不传，默认为获取当前用户的新鲜事
	private int page;// 支持分页，指定页号，页号从1开始，默认值为1
	private int count;// 支持分页，每一页记录数，默认值为30，最大50

	public GetInput(String access_token) {
		this.access_token = access_token;
		// 业务参数
		bodyArgs.add(new Arg("type", type));

		// 通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}

	public GetInput(String access_token, String uid) {
		this.access_token = access_token;
		// 业务参数
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("uid", uid));

		// 通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}

	public GetInput(String access_token, int count) {
		this.access_token = access_token;
		this.count = count;
		// 业务参数
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("count", String.valueOf(count)));

		// 通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}

	public GetInput(String access_token, int count, String uid) {
		this.access_token = access_token;
		this.count = count;
		this.uid = uid;
		// 业务参数
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("count", String.valueOf(count)));
		bodyArgs.add(new Arg("uid", uid));

		// 通用参数
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
//		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
