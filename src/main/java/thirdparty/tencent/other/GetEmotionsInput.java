/**
 * 
 */
package thirdparty.tencent.other;


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
public class GetEmotionsInput extends TencentInput {
	
	final private static String apiURL = "http://open.t.qq.com/api/other/get_emotions";
	private int type; // type:
						// 表示类型（附类型说明：）0：默认QQ表情;1：魂儿喵喵;2：阿囧;3：哎呀猩猩;4：爱心龟;5：大眼鼓;6：唛哩唛哩轰;7：细哥细妹;8：想念熊;9：小幺鸡;10：哎哟熊;11：吕查德;12：炮炮兵
						// ;13：张小盒;14：阿狸 ;15：几何猫 ;16：boto;17：emoji
	
	public GetEmotionsInput(String access_token,String access_secret,int type){
		this.type = type;
		this.userAccessToken = new AccessToken(access_token, access_secret);
		httpMethod = "GET";
		
		bodyArgs.add(new Arg("type", String.valueOf(type)));
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
