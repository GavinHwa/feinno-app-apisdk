/**
 * 
 */
package thirdparty.tencent.info;


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

public class UpdateInput extends TencentInput {

	final private static String apiURL = "http://open.t.qq.com/api/info/update";

	final private static int op = 0;//请求类型0-仅查询，1-查询完毕后将相应计数清0 
	final private static int type = 0;//5-首页未读消息计数，6-@页未读消息计数，7-私信页消息计数，8-新增听众数，9-首页广播数（原创的）op=0时，type默认为0，此时返回所有类型计数；op=1时，需带上某种类型的type，清除该type类型的计数，并返回所有类型计数 

	public UpdateInput(String access_token,String access_secret){
		this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("format",format));
		bodyArgs.add(new Arg("op",String.valueOf(op)));
		bodyArgs.add(new Arg("type",String.valueOf(type)));
		
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
