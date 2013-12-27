/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


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

import thirdparty.oauth.Arg;
import thirdparty.sina.SinaEmotionTransformer;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午12:03:09
 *
 */
@SuppressWarnings("unused")
public class UpdateInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/statuses/update.json";
	private String access_token;//用户的token
	private String status;//微博内容，必须做urlencode，不超过140汉字
	private float latitude;//维度，-90到+90，+表示北
	private float longtitude;//经度，-180到+180，+表示东
	private String annotations;//这个可以自己定义一个json串
	
	public UpdateInput(String access_token,String status){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		
		bodyArgs.add(new Arg("status", this.status));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public UpdateInput(String access_token,String status,String annotation){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.annotations = annotation;
		
		bodyArgs.add(new Arg("annotation", annotation));
		bodyArgs.add(new Arg("status", this.status));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public UpdateInput(String access_token,String status,float latitude, float longtitude){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.latitude = latitude;
		this.longtitude = longtitude;
		
		bodyArgs.add(new Arg("lat", String.valueOf(latitude)));
		bodyArgs.add(new Arg("long", String.valueOf(longtitude)));
		bodyArgs.add(new Arg("status", this.status));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public UpdateInput(String access_token,String status,float latitude, float longtitude,String annotations){
		this.access_token = access_token;
		this.status = SinaEmotionTransformer.transform2Sina(status);
		this.latitude = latitude;
		this.longtitude = longtitude;
		this.annotations = annotations;
		
		bodyArgs.add(new Arg("annotation", annotations));
		bodyArgs.add(new Arg("lat", String.valueOf(latitude)));
		bodyArgs.add(new Arg("long", String.valueOf(longtitude)));
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
