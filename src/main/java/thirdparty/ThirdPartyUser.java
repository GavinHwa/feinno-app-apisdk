/**
 * 
 */
package thirdparty;

import config.MessageConfig;
import com.feinno.app.feed.activitystreams.ActivityAuthor;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.ThirdPartyUser.java
 *
 * date		| author	| version	|  
 * 2012-9-22	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-22 下午8:23:31
 *
 */
public interface ThirdPartyUser {

    static String DEFAULTFETIONHEADIMAGE = MessageConfig.defaultProfileImg;

	/**
	 * 得到外站id
	 * @return
	 */
	public String getThirdUserid();

    /**
     * 用于得到外站atId的，比如腾讯的名字和@id不一样
     * @return
     */
    public String getThirdAtId();

	/**
	 * 得到外站用户名称
	 * @return
	 */
	public String getThirdName();
	
	/**
	 * 得到外站头像
	 * @return
	 */
	public String getThirdPic();
	
	/**
	 * 得到作者在外站的地址
	 * @return
	 */
	public String getThirdDomain();
	
	/**
	 * 得到本站的外站作者
	 * @return
	 */
	public ActivityAuthor getThirdPartyAuthor();
}
