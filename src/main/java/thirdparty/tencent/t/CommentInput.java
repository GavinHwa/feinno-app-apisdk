/**
 * 
 */
package thirdparty.tencent.t;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.t.AddVideoInput.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.tencent.TencentEmotionTransformer;
import thirdparty.tencent.TencentInput;

/**
 * @author	shangrenpeng
 * @date	2012-12-10 上午10:54:30
 *
 */
@SuppressWarnings("unused")
public class CommentInput extends TencentInput {

	final private static String apiURL = "http://open.t.qq.com/api/t/comment";
	private String content;//微博内容（若在此处@好友，需正确填写好友的微博账号，而非昵称），不超过140字
	private String clientip;//用户ip（必须正确填写用户侧真实ip，不能为内网ip及以127或255开头的ip，以分析用户所在地）
	private String longitude;//经度，为实数，如113.421234（最多支持10位有效数字，可以填空）
	private String latitude;//纬度，为实数，如22.354231（最多支持10位有效数字，可以填空）
	private String reid;//点评父节点微博id
	final static private int syncflag = 1;//微博同步到空间分享标记（可选，0-同步，1-不同步，默认为0）
	private int compatibleflag;//容错标志，支持按位操作，默认为0。0x10-同旧模式，获取视频信息失败则报错0x20-微博内容长度超过140字则报错0x40-url参数非法（如video_url=aaa）则报错0-以上错误做容错处理，即发表普通微博0x10|0x20|0x40-同旧模式，以上各种情况均报错，不做兼容处理
	
	public CommentInput(String access_token,String access_secret,String content, String clientip, String reid){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		this.content = TencentEmotionTransformer.transform2tencent(content);
		this.clientip = clientip;
		this.reid = reid;
		
		bodyArgs.add(new Arg("format",format));
		bodyArgs.add(new Arg("content",this.content));
		bodyArgs.add(new Arg("clientip",clientip));
		bodyArgs.add(new Arg("reid",reid));
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,apiURL,bodyArgs,
				userAccessToken);
	}
	
	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}

}
