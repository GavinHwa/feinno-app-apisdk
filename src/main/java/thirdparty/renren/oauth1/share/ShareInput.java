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
public class ShareInput extends RenrenInput {
	private String access_token;
	private static String method = "share.share";
	private int type;// 	true 	int 	分享的类型：日志为1、照片为2、链接为6、相册为8、视频为10、音频为11、分享为20。
	private String ugc_id;// 	true 	int 	分享人人网站内内容的ID。如日志、照片、相册、分享的ID。
	private String user_id;// 	true 	int 	分享人人网站内内容所有者的ID。如日志、照片、相册、分享所有者的用户ID。
	private String url;// 	true 	string 	分享人人网站外内容的URL。
	private String comment;// 	false 	string 	分享内容时，用户的评论内容。
//	private String source_link = ""; 	//false 	string 	新鲜事中来源信息链接，连接的名字默认为App的名字。该参数为JSON格式，格式如下：{ "text": "App A", "href": "http://appa.com/path"。
//	    当分享日志、照片、相册等人人网站内内容时，ugc_id和user_id为必须参数。
//    当分享优酷视频、站外链接等人人网站外内容时，url为必须参数。此时type只能是：链接为6、视频为10、音频为11。
//    当基于现存分享再次进行分享时（可以获取到分享的ID），type只能是：分享20，ugc_id和user_id为必须参数。 

//例如：

//    分享站内照片需要传递以下参数：
//        type: 2
//        ugc_id: 1234567
//        user_id: 7654321 
//    分享站外视频：
//        type: 10
//        url: http://www.youku.com/12132123.html 
//    基于现存分享再次分享：
//        type: 20
//        ugc_id: 分享的ID
//        user_id: 分享所有者的ID 
	
	public ShareInput(String access_token,String message,String url){
		this.access_token = access_token;
//		this.url = "http://i.feixin.10086.cn/" + userId;
		this.type = 10;
		this.comment = message;
		this.url = url;
		
		//业务参数
		bodyArgs.add(new Arg("type", String.valueOf(type)));
		bodyArgs.add(new Arg("url", url));
		bodyArgs.add(new Arg("comment", message));
		
		//通用参数
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
