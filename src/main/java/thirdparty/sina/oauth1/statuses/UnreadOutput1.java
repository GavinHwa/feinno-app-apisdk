/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.ThirdPartyUnreadCounter;
import thirdparty.sina.oauth1.SinaOauth1Output;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.thirdparty.sina.oauth2.statuses.Update.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午8:34:16
 *
 */
public class UnreadOutput1 extends SinaOauth1Output implements ThirdPartyUnreadCounter{
	private int comments;//新评论数量
	private int followers;//新粉丝数量
	private int new_status;//新微博数量
	private int dm;//新私信数量
	/**
	 * @return the comments
	 */
	public int getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(int comments) {
		this.comments = comments;
	}
	/**
	 * @return the followers
	 */
	public int getFollowers() {
		return followers;
	}
	/**
	 * @param followers the followers to set
	 */
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	/**
	 * @return the new_status
	 */
	public int getNew_status() {
		return new_status;
	}
	/**
	 * @param new_status the new_status to set
	 */
	public void setNew_status(int new_status) {
		this.new_status = new_status;
	}
	/**
	 * @return the dm
	 */
	public int getDm() {
		return dm;
	}
	/**
	 * @param dm the dm to set
	 */
	public void setDm(int dm) {
		this.dm = dm;
	}
	/**
	 * @return the mentions
	 */
	public int getMentions() {
		return mentions;
	}
	/**
	 * @param mentions the mentions to set
	 */
	public void setMentions(int mentions) {
		this.mentions = mentions;
	}
	private int mentions;//新@数量
	/* (non-Javadoc)
	 * @see com.feinno.message.ThirdPartyUnreadCounter#getCounter()
	 */
	@Override
	public long getCounter() {
		return comments + followers + dm;
	}
}
