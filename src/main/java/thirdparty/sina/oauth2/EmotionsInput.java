/**
 * 
 */
package thirdparty.sina.oauth2;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.Emotions.java
 *
 * date		| author	| version	|  
 * 2012-11-15	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;

/**
 * @author	shangrenpeng
 * @date	2012-11-15 上午10:47:17
 *
 */
@SuppressWarnings("unused")
public class EmotionsInput extends SinaOauth2Input{
	
	final private static String apiURL = "https://api.weibo.com/2/emotions.json";
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private String type;//表情类别，face：普通表情、ani：魔法表情、cartoon：动漫表情，默认为face。
	private String language;//语言类别，cnname：简体、twname：繁体，默认为cnname。 
	
	public EmotionsInput(String access_token){
		this.access_token = access_token;
		this.language = "cnname";
		httpMethod = "GET";
		this.type = "face";
		
		bodyArgs.add(new Arg("access_token", access_token));
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("language", language));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public EmotionsInput(String access_token, String type){
		this.access_token = access_token;
		this.language = "cnname";
		httpMethod = "GET";
		this.type = type;
		
		bodyArgs.add(new Arg("access_token", access_token));
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("language", language));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public EmotionsInput(String access_token, String type, String language){
		this.access_token = access_token;
		this.language = language;
		httpMethod = "GET";
		this.type = type;
		
		bodyArgs.add(new Arg("access_token", access_token));
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("language", language));
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
