/**
 * 
 */
package thirdparty.renren.oauth1.status;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.status.GetEmoticons.java
 *
 * date		| author	| version	|  
 * 2012-11-21	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.oauth.Arg;
import thirdparty.renren.oauth1.RenrenInput;

/**
 * 这个类名不是我真的要写错，是人人网自己的api写错了名字
 * @author	shangrenpeng
 * @date	2012-11-21 上午10:32:22
 *
 */
public class GetEmoticonsInput extends RenrenInput {
	private String access_token;
	private static String method = "status.getEmoticons";
	private String type = "all";
	
	public GetEmoticonsInput(String access_token){
		this.access_token = access_token;
		
		bodyArgs.add(new Arg("type", type));
		bodyArgs.add(new Arg("method", method));
		bodyArgs.add(new Arg("access_token", this.access_token));
		bodyArgs.add(new Arg("format", format));
		bodyArgs.add(new Arg("v", v));
		bodyArgs.add(new Arg("sig", getSignature(bodyArgs)));
	}
}
