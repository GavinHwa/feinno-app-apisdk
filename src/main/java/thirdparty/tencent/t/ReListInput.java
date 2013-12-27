/**
 * 
 */
package thirdparty.tencent.t;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.t.AddVideoInput.java
 *
 * date		| author	| version	|  
 * 2012-12-10	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.AccessToken;
import thirdparty.oauth.Arg;
import thirdparty.tencent.TencentInput;

/**
 * @author	shangrenpeng
 * @date	2012-12-10 上午10:54:30
 *
 */
@SuppressWarnings("unused")
public class ReListInput extends TencentInput {

	final private static String apiURL = "http://open.t.qq.com/api/t/re_list";

	final private static int flag = 1;// 类型标识。0－转播列表，1－点评列表，2－点评与转播列表
	private String rootid;// 转发或回复的微博根结点id（源微博id）
	private int pageflag = 0;// 分页标识，用于翻页（0：第一页，1：向下翻页，2：向上翻页）(1是向过去，2是向未来)。
	private long pagetime = 0;// 本页起始时间，与pageflag、twitterid共同使用，实现翻页功能（第一页：填0，向上翻页：填上一次请求返回的第一条记录时间，向下翻页：填上一次请求返回的最后一条记录时间）。结果包括当前一条
	private int reqnum = 50;// 每次请求记录的条数（1-100条）,默认为20条
	private String twitterid = "0";// 微博id，与pageflag、pagetime共同使用，实现翻页功能（第1页填0，继续向下翻页，填上一次请求返回的最后一条记录id）第二次之后的获取中这个参数必须填写，否则就会抓重

	/**
	 * 用于第一次获取评论
	 * @param access_token
	 * @param access_secret
	 * @param rootid
	 */
	public ReListInput(String access_token,String access_secret,String rootid){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		this.rootid = rootid;
		
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("format",format));
		bodyArgs.add(new Arg("flag",String.valueOf(flag)));
		bodyArgs.add(new Arg("rootid",rootid));
		bodyArgs.add(new Arg("pageflag",String.valueOf(pageflag)));
		bodyArgs.add(new Arg("pagetime",String.valueOf(pagetime)));
		bodyArgs.add(new Arg("reqnum",String.valueOf(reqnum)));
		bodyArgs.add(new Arg("twitterid",String.valueOf(twitterid)));
		
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,apiURL,bodyArgs,
				userAccessToken);
	}
	
	/**
	 * 用于正常更新，比输入的id更新的
	 * @param access_token
	 * @param access_secret
	 * @param rootid
	 * @param pagetime
	 * @param twitterid
	 */
	public ReListInput(String access_token,String access_secret,String rootid,long pagetime,String twitterid){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		this.rootid = rootid;
		this.pageflag = 2;
		this.pagetime = pagetime;
		
		
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("format",format));
		bodyArgs.add(new Arg("flag",String.valueOf(flag)));
		bodyArgs.add(new Arg("rootid",rootid));
		bodyArgs.add(new Arg("pageflag",String.valueOf(pageflag)));
		bodyArgs.add(new Arg("pagetime",String.valueOf(pagetime)));
		bodyArgs.add(new Arg("reqnum",String.valueOf(reqnum)));
		bodyArgs.add(new Arg("twitterid",String.valueOf(twitterid)));
		
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,apiURL,bodyArgs,
				userAccessToken);
	}
	
	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return apiURL;
	}

}
