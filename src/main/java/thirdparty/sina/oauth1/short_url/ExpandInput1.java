/**
 * 
 */
package thirdparty.sina.oauth1.short_url;


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


import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.oauth1.SinaOauth1Input;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午12:03:09
 * 
 */
public class ExpandInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/short_url/expand.json";

	Collection<String> url_short;// 需要还原的短链接，需要URLencoded，最多不超过20个

	public ExpandInput1(String accessKey, String accessSecret,
			Collection<String> url_shorts) {
		httpMethod = "GET";
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.url_short = url_shorts;
		for (String url : url_shorts) {
			bodyArgs.add(new Arg("url_short", url.trim()));
		}
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
	}

	public ExpandInput1(String accessKey, String accessSecret, String url) {
		httpMethod = "GET";
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.url_short = new ArrayList<String>();
		bodyArgs.add(new Arg("url_short", url.trim()));
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
