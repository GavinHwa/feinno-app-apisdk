/**
 * 
 */
package thirdparty.tencent.friends;


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

public class Mutual_listInput extends TencentInput {

	final private static String apiURL = "http://open.t.qq.com/api/friends/mutual_list";

	final private int startindex;//起始位置（第一页填0，继续向下翻页：填【reqnum*（page-1）】）
    final private int reqnum;//请求个数(1-300)
    static private int install = 2;//过滤安装应用好友（可选）0-不考虑该参数，1-获取已安装应用好友，2-获取未安装应用好友\
    private String fopenid;//用户openid（可选）
    private String name;//用户帐户名（可选）


	public Mutual_listInput(String access_token, String access_secret, int reqnum, int page, String name){
        this.startindex = reqnum * (page - 1);
        this.reqnum = reqnum;
        this.name = name;
        this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("format",format));
		bodyArgs.add(new Arg("startindex",String.valueOf(startindex)));
        bodyArgs.add(new Arg("reqnum",String.valueOf(this.reqnum)));
//		bodyArgs.add(new Arg("install",String.valueOf(Mutual_listInput.install)));为了和新浪逻辑保持一致
        bodyArgs.add(new Arg("name",name));
		
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
