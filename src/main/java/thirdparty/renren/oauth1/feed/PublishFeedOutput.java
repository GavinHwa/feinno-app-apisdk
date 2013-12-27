/**
 * 
 */
package thirdparty.renren.oauth1.feed;


/**
 * @author : shangrenpeng
 * @fileName : com.feinno.messages.thirdparty.sina.oauth2.remind.UnreadCount.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.renren.oauth1.RenRenOutput;

/**
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class PublishFeedOutput extends RenRenOutput {
	private int post_id;

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}
}
