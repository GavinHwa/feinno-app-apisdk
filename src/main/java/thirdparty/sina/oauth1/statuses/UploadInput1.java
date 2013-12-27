/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.oauth.OauthHelperOne;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth1.SinaOauth1Input;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.UploadOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午6:36:45
 *
 */
@SuppressWarnings("unused")
public class UploadInput1 extends SinaOauth1Input{
	private final static String apiURL= "http://api.t.sina.com.cn/statuses/upload.json";
	
	private String status;//要发布的微博文本内容，必须做URLencode，内容不超过140个汉字。
	private byte[] pic;//要上传的图片，仅支持JPEG、GIF、PNG格式，图片大小小于5M。
	private float lattitude;//纬度，有效范围：-90.0到+90.0，+表示北纬，默认为0.0。
	private float longtitude;//经度，有效范围：-180.0到+180.0，+表示东经，默认为0.0。
	
	public UploadInput1(String access_token,String access_secret,String status,byte[] pic){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		this.status = OauthHelperOne.encode(SinaEmotionTransformer.transform2Sina(status));
		this.pic = pic;
		bodyArgs.add(new Arg("status", this.status));
		parts.addAll(getMultiParts(pic,bodyArgs));
		bodyArgs.clear();
		headers.add(oauthHelper.generateAuthorizationHeader(httpMethod, apiURL,bodyArgs,
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
