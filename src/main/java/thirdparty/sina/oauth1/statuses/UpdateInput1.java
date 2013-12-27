/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth1.SinaOauth1Input;

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

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午12:03:09
 * 
 */
@SuppressWarnings("unused")
public class UpdateInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/update.json";

	private String status;// 要发布的微博消息文本内容
	private long in_reply_to_status_id;// 要转发的微博消息ID。
	private float latitude;// 纬度。有效范围：-90.0到+90.0，+表示北纬。
	private float longtitude;// 经度。有效范围：-180.0到+180.0，+表示东经。注意：lat和long参数需配合使用，用于标记发表微博消息时所在的地理位置，只有用户设置中geo_enabled=true时候地理位置信息才有效。
	private String annotations;// 元数据，主要是为了方便第三方应用记录一些适合于自己使用的信息。每条微博可以包含一个或者多个元数据。请以json字串的形式提交，字串长度不超过512个字符，具体内容可以自定。

	public UpdateInput1(String accessKey, String accessSecret, String status) {
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.status = SinaEmotionTransformer.transform2Sina(status);
		bodyArgs.add(new Arg("status", this.status));
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
