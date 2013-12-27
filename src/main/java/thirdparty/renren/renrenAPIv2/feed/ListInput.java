/**
 * 
 */
package thirdparty.renren.renrenAPIv2.feed;

import thirdparty.oauth.Arg;
import thirdparty.renren.oauth1.RenrenInput;

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
    private static String apiUrl = "https://api.renren.com/v2/feed/list";
	private String access_token;
	private static final String feedType = "ALL";//SHARE_VIDEO,	分享视频 UPDATE_STATUS,更新状态|PUBLISH_BLOG,发表日志|
	// PUBLISH_ONE_PHOTO,上传单张照片|SHARE_PHOTO,分享照片|SHARE_ALBUM,分享相册|PUBLISH_MORE_PHOTO,上传多张照片|
	// SHARE_LINK,分享链接|SHARE_BLOG,分享日志|ALL,全部类型

	private long userId;// 用户id,不传时表示获取当前用户人人网首页新鲜事，否则获取对应用户的个人主页新鲜事
	private int pageSize;// 页面大小。取值范围1-100，默认大小30
	private int pageNumber;// 页数，取值大于0，默认值为1

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
