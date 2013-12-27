/**
 * 
 */
package thirdparty.sina.oauth2.friendships.friends.bilateral;

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
public class BilateralInput extends SinaOauth2Input {
	final private static String apiURL = "https://api.weibo.com/2/friendships/friends/bilateral.json";

    private String source;//采用OAuth授权方式不需要此参数，其他授权方式为必填参数，数值为应用的AppKey。
    private String access_token;//采用OAuth授权方式为必填参数，其他授权方式不需要此参数，OAuth授权后获得。
    private String uid;//需要获取双向关注列表的用户UID。必选
    private int count;//单页返回的记录条数，默认为50，最大不超过2000。
    private int page;//返回结果的页码，默认为1。
    private int sort;//排序类型，0：按关注时间最近排序，默认为0。

	public BilateralInput(String access_token, String uid){
        this.access_token = access_token;
        this.uid = uid;
        httpMethod = "GET";

        bodyArgs.add(new Arg("access_token", access_token));
        bodyArgs.add(new Arg("uid", uid.trim()));
        headers.add(new Arg("Authorization", "OAuth2 " + source));
	}

    public BilateralInput(String access_token, String uid, int count, int page){
        this(access_token,uid);
        this.count = count;
        this.page = page;

        bodyArgs.add(new Arg("count", String.valueOf(count)));
        bodyArgs.add(new Arg("page", String.valueOf(page)));
    }

	public BilateralInput(String access_token, String uid, int count, int page, int sort){
        this(access_token, uid, count, page);
        this.sort = sort;

        bodyArgs.add(new Arg("sort", String.valueOf(sort)));
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}
}
