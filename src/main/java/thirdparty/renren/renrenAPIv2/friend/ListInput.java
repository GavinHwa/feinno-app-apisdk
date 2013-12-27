/**
 * 
 */
package thirdparty.renren.renrenAPIv2.friend;

import thirdparty.oauth.Arg;
import thirdparty.renren.renrenAPIv2.RenrenInput;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.feed.PublishFeed.java
 *
 * date		| author	| version	|  
 * 2012-11-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-11-20 下午12:18:52
 * 
 */
@SuppressWarnings("unused")
public class ListInput extends RenrenInput {
    private static String apiUrl = "https://api.renren.com/v2/friend/list";
	private String access_token;

    private long userId;// 	long 	false 	用户ID。该字段默认为当前用户
    private int pageSize;// 	int 	false 	页面大小。默认大小500。
    private int pageNumber;// 	int 	false 	页码。取值大于零，默认值为1

	public ListInput(String access_token) {
        httpMethod = "GET";
		this.access_token = access_token;
		// 通用参数
		bodyArgs.add(new Arg("access_token", this.access_token));
	}

    public ListInput(String access_token, int pageSize) {
        this(access_token);
        this.pageSize = pageSize;
        bodyArgs.add(new Arg("pageSize",String.valueOf(this.pageSize)));
    }

    @Override
    protected String getUrl() {
        return apiUrl;
    }
}
