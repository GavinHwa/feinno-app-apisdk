/**
 * 
 */
package thirdparty.sina;

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
public class SinaTestKeys extends SnsTestKeys{
	private static String accesstoken = MessageConfig.sinaAccessToken1;
	private static String accessSecret = MessageConfig.sinaAccessSecret1;
	private static String accesstoken2 = MessageConfig.sinaAccessToken2;
	private static String accessSecret2 = MessageConfig.sinaAccessSecret2;
    private static String sinaUid = "3040570084";

    public static String getSinaUid() {
        return sinaUid;
    }

    public static void setSinaUid(String sinaUid) {
        SinaTestKeys.sinaUid = sinaUid;
    }

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
		SinaTestKeys.accesstoken = accesstoken;
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
		SinaTestKeys.accessSecret = accessSecret;
	}
	/**
	 * @return the accesstoken2
	 */
	public static String getAccesstoken2() {
		return accesstoken2;
	}
	/**
	 * @param accesstoken2 the accesstoken2 to set
	 */
	public static void setAccesstoken2(String accesstoken2) {
		SinaTestKeys.accesstoken2 = accesstoken2;
	}
	/**
	 * @return the accessSecret2
	 */
	public static String getAccessSecret2() {
		return accessSecret2;
	}
	/**
	 * @param accessSecret2 the accessSecret2 to set
	 */
	public static void setAccessSecret2(String accessSecret2) {
		SinaTestKeys.accessSecret2 = accessSecret2;
	}
}
