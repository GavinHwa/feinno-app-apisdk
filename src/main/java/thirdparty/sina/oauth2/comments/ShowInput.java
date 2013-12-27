/**
 * 
 */
package thirdparty.sina.oauth2.comments;


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

import thirdparty.oauth.Arg;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author	shangrenpeng
 * @date	2012-9-28 下午3:36:45
 *
 */
@SuppressWarnings("unused")
public class ShowInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/comments/show.json";
	
	private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private long id;//需要查询的微博ID。
	private long since_id;//若指定此参数，则返回ID比since_id大的评论（即比since_id时间晚的评论），默认为0。
	private String max_id;//若指定此参数，则返回ID小于或等于max_id的评论，默认为0。
	private String count;//单页返回的记录条数，默认为50。
	private String page;//返回结果的页码，默认为1。
	private String filter_by_author;//作者筛选类型，0：全部、1：我关注的人、2：陌生人，默认为0。
	
	public ShowInput(String access_token,long id,long since_id){
		httpMethod = "GET";
		this.access_token = access_token;
		this.id = id;
		this.since_id = since_id;
		
		bodyArgs.add(new Arg("id", Long.toString(id)));
		bodyArgs.add(new Arg("since_id", Long.toString(since_id)));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public ShowInput(String access_token,long id){
		httpMethod = "GET";
		this.access_token = access_token;
		this.id = id;
		
		bodyArgs.add(new Arg("id", Long.toString(id)));
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
