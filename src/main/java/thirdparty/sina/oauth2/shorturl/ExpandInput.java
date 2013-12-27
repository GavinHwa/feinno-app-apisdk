/**
 * 
 */
package thirdparty.sina.oauth2.shorturl;


import thirdparty.oauth.Arg;
import thirdparty.sina.oauth2.SinaOauth2Input;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.shorturl.ExpandOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-28	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-28 下午3:36:45
 *
 */
@SuppressWarnings("unused")
public class ExpandInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/short_url/expand.json";
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private Collection<String> url_shorts = new ArrayList<String>(20);//需要还原的短链接，需要URLencoded，最多不超过20个 。
	
	public ExpandInput(String access_token, String url_short){
		this.access_token = access_token;
		this.url_shorts.add(url_short);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("access_token", access_token));
		bodyArgs.add(new Arg("url_short", url_short.trim()));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}

    public ExpandInput(Collection<String> url_shorts){
        this.url_shorts = url_shorts;
        httpMethod = "GET";

        for (String string : url_shorts) {
            bodyArgs.add(new Arg("url_short", string.trim()));
        }
        bodyArgs.add(new Arg("source",source));

        headers.add(new Arg("Authorization", "OAuth2 " + source));
    }
	
	public ExpandInput(String access_token, Collection<String> url_shorts){
		this.access_token = access_token;
		this.url_shorts = url_shorts;
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("access_token", access_token));
		for (String string : url_shorts) {
			bodyArgs.add(new Arg("url_short", string.trim()));
		}
		
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
