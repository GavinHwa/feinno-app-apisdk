/**
 * 
 */
package thirdparty.sina.oauth2.statuses;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineOrder.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.sina.oauth2.SinaOauth2Input;

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午6:09:51
 * 
 */
@SuppressWarnings("unused")
public class HomeTimelineInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/statuses/home_timeline.json";
	private String access_token;// 采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
	private long since_id;// 若指定此参数，则返回ID比since_id大的微博（即比since_id时间晚的微博），默认为0。
	private long max_id;// 若指定此参数，则返回ID小于或等于max_id的微博，默认为0。
	private int count;// 单页返回的记录条数，最大不超过100，默认为20。
	private int page;// 返回结果的页码，默认为1。
	private int base_app;// 是否只获取当前应用的数据。0为否（所有数据），1为是（仅当前应用），默认为0。
	private int feature;// 过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
	private int trim_user;// 返回值中user字段开关，0：返回完整user字段、1：user字段仅返回user_id，默认为0。
	
	public HomeTimelineInput(String access_token,long since_id,int count){
		this.access_token = access_token;
		this.since_id = since_id;
		this.count = count;
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("since_id", String.valueOf(since_id)));
		bodyArgs.add(new Arg("count", String.valueOf(count)));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public HomeTimelineInput(String access_token,long since_id){
		this.access_token = access_token;
		this.since_id = since_id;
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("count", "50"));
		bodyArgs.add(new Arg("since_id", String.valueOf(since_id)));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public HomeTimelineInput(String access_token,int count){
		this.access_token = access_token;
		this.since_id = 0;
		this.count = count;
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("count", String.valueOf(count)));
		bodyArgs.add(new Arg("access_token", access_token));
		headers.add(new Arg("Authorization", "OAuth2 " + source));
	}
	
	public HomeTimelineInput(String access_token,long since_id,int count,int page){
		this.access_token = access_token;
		this.since_id = since_id;
		this.count = count;
		this.page = page;
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("since_id", String.valueOf(since_id)));
		bodyArgs.add(new Arg("count", String.valueOf(count)));
		bodyArgs.add(new Arg("page", String.valueOf(page)));
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
