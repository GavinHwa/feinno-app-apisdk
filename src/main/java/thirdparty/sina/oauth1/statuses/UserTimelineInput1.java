/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import com.feinno.app.common.IpUtils;
import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.sina.oauth1.SinaOauth1Input;

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

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午6:09:51
 * 
 */
@SuppressWarnings("unused")
public class UserTimelineInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/statuses/user_timeline.json";
	
	private long since_id;// 若指定此参数，则只返回ID比since_id大的微博消息（即比since_id发表时间晚的微博消息）。
	private long max_id;// 若指定此参数，则返回ID小于或等于max_id的微博消息
	private String user_id;//用户ID，主要是用来区分用户ID跟微博昵称。当微博昵称为数字导致和用户ID产生歧义，特别是当微博昵称和用户ID一样的时候，建议使用该参数 
	private int count;// 指定要返回的记录条数。
	private int page;// 指定返回结果的页码。根据当前登录用户所关注的用户数及这些被关注用户发表的微博数，翻页功能最多能查看的总记录数会有所不同，通常最多能查看1000条左右。
	private int base_app;// 是否基于当前应用来获取数据。1为限制本应用微博，0为不做限制。
	private int feature;// 微博类型，0全部，1原创，2图片，3视频，4音乐. 返回指定类型的微博信息内容。
	
	private boolean hasSince_id = false;
	private boolean hasCount = false;
	private long loginIp;
	
	public UserTimelineInput1(String accessKey, String accessSecret, long since_id, int count, long loginIp,String user_id) {
		this.since_id = since_id;
		this.count = count;
		this.hasSince_id = true;
		this.hasCount = true;
		this.user_id = user_id;
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.loginIp = loginIp;
		
		bodyArgs.add(new Arg("since_id",Long.toString(since_id)));
		bodyArgs.add(new Arg("count",Integer.toString(count)));
		bodyArgs.add(new Arg("user_id",user_id));
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
//		addRemoteIP(loginIp);
	}

	
	public UserTimelineInput1(String accessKey, String accessSecret, long since_id, long loginIp,String user_id) {
		this.since_id = since_id;
		this.hasSince_id = true;
		this.user_id = user_id;
		bodyArgs.add(new Arg("since_id",Long.toString(since_id)));
		bodyArgs.add(new Arg("user_id",user_id));
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.loginIp = loginIp;
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
//		addRemoteIP(loginIp);
	}

	public UserTimelineInput1(String accessKey, String accessSecret, int count, long loginIp,String user_id) {
		this.since_id = 0;// 通过since_id是否为0来判断是否第一次抓取
		this.count = count;
		this.user_id = user_id;
		this.hasCount = true;
		bodyArgs.add(new Arg("count",Integer.toString(count)));
		bodyArgs.add(new Arg("user_id",user_id));
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.loginIp = loginIp;
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
//		addRemoteIP(loginIp);
	}
	
	public UserTimelineInput1(String accessKey, String accessSecret, long since_id, int count, long loginIp, int page, String user_id) {
		this.since_id = since_id;
		this.count = count;
		this.hasSince_id = true;
		this.hasCount = true;
		this.user_id = user_id;
		this.userAccessToken = new AccessToken(accessKey, accessSecret);
		this.loginIp = loginIp;
		this.page = page;
		
		bodyArgs.add(new Arg("since_id",Long.toString(since_id)));
		bodyArgs.add(new Arg("count",Integer.toString(count)));
		bodyArgs.add(new Arg("page",Integer.toString(page)));
		bodyArgs.add(new Arg("user_id",user_id));
		httpMethod = "GET";
		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
//		addRemoteIP(loginIp);
	}
	
	private void addRemoteIP(long loginIp) {
		if (loginIp != 0) {// 添加一个自定义头，提高访问次数
			String ipString = null;
			ipString = IpUtils.ipLongToString(loginIp);
			if (ipString != null) {
				bodyArgs.add(new Arg("API-RemoteIP", ipString));
			}
		}
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}	
}
