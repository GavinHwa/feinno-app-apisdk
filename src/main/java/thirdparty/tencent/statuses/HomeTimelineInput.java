/**
 * 
 */
package thirdparty.tencent.statuses;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.Emotions.java
 *
 * date		| author	| version	|  
 * 2012-11-15	| shangrenpeng	| 1.0		|
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
 * @date	2012-11-15 上午10:47:17
 *
 */
@SuppressWarnings("unused")
public class HomeTimelineInput extends TencentInput {
	
	final private static String apiURL = "http://open.t.qq.com/api/statuses/home_timeline";
	final private static int pageflag = 0; //分页标识（0：第一页，1：向下翻页，2：向上翻页）
	private long pagetime; //本页起始时间（第一页：填0，向上翻页：填上一次请求返回的第一条记录时间，向下翻页：填上一次请求返回的最后一条记录时间）
	private long reqnum = 50;//每次请求记录的条数（1-70条）
	final static private int type = 0;// 拉取类型（需填写十进制数字）0x1 原创发表 0x2 转载 如需拉取多个类型请使用|，如(0x1|0x2)得到3，则type=3即可，填零表示拉取所有类型
	final static private int contenttype = 0;// 内容过滤。0-表示所有类型，1-带文本，2-带链接，4-带图片，8-带视频，0x10-带音频 建议不使用contenttype为1的类型，如果要拉取只有文本的微博，建议使用0x80
	
	/**
	 * 用于第一次获取用户timeline的时候
	 * @param access_token
	 * @param access_secret
	 * @param reqnum
	 */
	public HomeTimelineInput(String access_token,String access_secret,int reqnum){
		this.pagetime = 0;
		this.reqnum = reqnum;
		
		this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("pageflag", String.valueOf(pageflag)));
		bodyArgs.add(new Arg("pagetime", String.valueOf(pagetime)));
		bodyArgs.add(new Arg("reqnum", String.valueOf(reqnum)));
		bodyArgs.add(new Arg("format",format));
		oauthHelper.generateAuthorizationHeaderTencent(httpMethod,apiURL,bodyArgs,
				userAccessToken);
	}
	
	/**
	 * 获取50条以后要根据id去排除重复了
	 * @param access_token
	 * @param access_secret
	 */
	public HomeTimelineInput(String access_token,String access_secret){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("pageflag", String.valueOf(pageflag)));
		bodyArgs.add(new Arg("pagetime", String.valueOf(pagetime)));
		bodyArgs.add(new Arg("reqnum", String.valueOf(reqnum)));
		bodyArgs.add(new Arg("format",format));
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
