/**
 * 
 */
package thirdparty.tencent;

import config.MessageConfig;
import thirdparty.SnsTestKeys;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.SinaTestKeys.java
 *
 * date		| author	| version	|  
 * 2012-12-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-24 下午12:45:01
 *
 */
public class TencentTestKeys extends SnsTestKeys{
	private static String accesstoken = MessageConfig.tencentAccessToken;
	private static String accessSecret = MessageConfig.tencentAccessSecret;
	/**
	 * @return the accesstoken
	 */
	public static String getAccesstoken() {
		return accesstoken;
	}
	/**
	 * @param accesstoken the accesstoken to set
	 */
	public static void setAccesstoken(String accesstoken) {
		TencentTestKeys.accesstoken = accesstoken;
	}
	/**
	 * @return the accessSecret
	 */
	public static String getAccessSecret() {
		return accessSecret;
	}
	/**
	 * @param accessSecret the accessSecret to set
	 */
	public static void setAccessSecret(String accessSecret) {
		TencentTestKeys.accessSecret = accessSecret;
	}
}
