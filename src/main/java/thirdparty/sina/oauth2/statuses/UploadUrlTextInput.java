/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UploadUrlText.java
 *
 * date		| author	| version	|  
 * 2012-9-28	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author	shangrenpeng
 * @date	2012-9-28 上午11:32:56
 *
 */
@SuppressWarnings("unused")
public class UploadUrlTextInput extends SinaOauth2Input {
	private final static String apiURL= "https://api.weibo.com/2/statuses/upload_url_text.json";
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private String status;//要发布的微博文本内容，必须做URLencode，内容不超过140个汉字。
	private String url;//图片的URL地址，必须以http开头。
	private float latitude;//lat,纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
	private float longitude;//long,经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
	private String annotations;//元数据，主要是为了方便第三方应用记录一些适合于自己使用的信息，每条微博可以包含一个或者多个元数据，必须以json字串的形式提交，字串长度不超过512个字符，具体内容可以自定。
	
	public UploadUrlTextInput(String access_token,String status,String url){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.url = url;
		
		bodyArgs.add(new Arg("url", url));
		bodyArgs.add(new Arg("status", this.status));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
