/**
 * 
 */
package thirdparty.sina.oauth1.friends;


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

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午12:03:09
 * 
 */
public class IdsInput1 extends SinaOauth1Input {
	private final static String apiURL = "http://api.t.sina.com.cn/friends/ids.json";
    private String source;//申请应用时分配的AppKey，调用接口时候代表应用的唯一身份。（采用OAuth授权方式不需要此参数）
    private String id;//用户的ID(int64)或者微博昵称(string)。该参数为REST风格的参数，用法参见注意事项。
    private String user_id;//要获取的好友列表所属的用户的ID。
    private String screen_name;//要获取的好友列表所属的用户微博昵称。
    private int count;//默认500，最大5000 单页记录数。
    private int cursor;//默认-1。 游标。单页最多返回5000条记录。通过增加或减少cursor值来获取更多的关注列表。如果提供该参数，返回结果中将给出下一页的起始游标。

	public IdsInput1(String accessKey, String accessSecret) {
		httpMethod = "GET";
		this.userAccessToken = new AccessToken(accessKey, accessSecret);

		headers.add(oauthHelper.generateAuthorizationHeader( httpMethod, apiURL,bodyArgs,
				seperator, userAccessToken));
	}

	public IdsInput1(String accessKey, String accessSecret, int cursor, int count) {
		httpMethod = "GET";
        this.count = count;
        this.cursor = cursor;
		this.userAccessToken = new AccessToken(accessKey, accessSecret);

		bodyArgs.add(new Arg("count", String.valueOf(this.count)));
        bodyArgs.add(new Arg("cursor", String.valueOf(this.cursor)));
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
