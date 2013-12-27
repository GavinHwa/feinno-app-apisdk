/**
 * 
 */
package thirdparty.renren;

import config.MessageConfig;
import thirdparty.SnsTestKeys;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.RenrenTestKeys.java
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
 * @date	2012-12-24 下午6:01:32
 *
 */
public class RenrenTestKeys extends SnsTestKeys {
	private static String accessToken = MessageConfig.renrenAccessToken;
	private static int userid = 201669111;
    private static int thirdPartyUserId =389414346;
    private static String statusFeedId = "4824149188";
    private static String actor_id = "389414346";

    public static String getStatusFeedId() {
        return statusFeedId;
    }

    public static String getActor_id() {
        return actor_id;
    }

    public static String getAccessToken() {
		return accessToken;
	}

	public static int getUserid() {
		return userid;
	}

    public static int getThirdPartyUserId() {
        return thirdPartyUserId;
    }

    public static void setThirdPartyUserId(int thirdPartyUserId) {
        RenrenTestKeys.thirdPartyUserId = thirdPartyUserId;
    }
}
