/**
 * 
 */
package thirdparty.sina.oauth2.remind;

import thirdparty.ThirdPartyUnreadCounter;
import thirdparty.sina.oauth2.SinaOauth2Output;

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

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午5:48:44
 *
 */
public class UnreadCountOutput extends SinaOauth2Output implements ThirdPartyUnreadCounter {
	private int status;//有几条新feed，不通知
	private int follower;//新粉丝数量，通知
	private int cmt;//新评论数量，通知
	private int dm;//新私信数量，通知
	private int mention_status;//新提及我的微博数，通知 
	private int mention_cmt;//新提及我的评论数，通知
	private int group;//微群消息未读数，不通知
	private int private_group;//私有微群消息未读数，不通知
	private int notice;//新通知未读数，通知
	private int invite;//新邀请未读数，通知
	private int badge;//新勋章数，不通知
	private int photo;//相册消息未读数，通知
	
	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the follower
	 */
	public int getFollower() {
		return follower;
	}

	/**
	 * @param follower the follower to set
	 */
	public void setFollower(int follower) {
		this.follower = follower;
	}

	/**
	 * @return the cmt
	 */
	public int getCmt() {
		return cmt;
	}

	/**
	 * @param cmt the cmt to set
	 */
	public void setCmt(int cmt) {
		this.cmt = cmt;
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
	 * @return the mention_status
	 */
	public int getMention_status() {
		return mention_status;
	}

	/**
	 * @param mention_status the mention_status to set
	 */
	public void setMention_status(int mention_status) {
		this.mention_status = mention_status;
	}

	/**
	 * @return the mention_cmt
	 */
	public int getMention_cmt() {
		return mention_cmt;
	}

	/**
	 * @param mention_cmt the mention_cmt to set
	 */
	public void setMention_cmt(int mention_cmt) {
		this.mention_cmt = mention_cmt;
	}

	/**
	 * @return the group
	 */
	public int getGroup() {
		return group;
	}

	/**
	 * @param group the group to set
	 */
	public void setGroup(int group) {
		this.group = group;
	}

	/**
	 * @return the private_group
	 */
	public int getPrivate_group() {
		return private_group;
	}

	/**
	 * @param private_group the private_group to set
	 */
	public void setPrivate_group(int private_group) {
		this.private_group = private_group;
	}

	/**
	 * @return the notice
	 */
	public int getNotice() {
		return notice;
	}

	/**
	 * @param notice the notice to set
	 */
	public void setNotice(int notice) {
		this.notice = notice;
	}

	/**
	 * @return the invite
	 */
	public int getInvite() {
		return invite;
	}

	/**
	 * @param invite the invite to set
	 */
	public void setInvite(int invite) {
		this.invite = invite;
	}

	/**
	 * @return the badge
	 */
	public int getBadge() {
		return badge;
	}

	/**
	 * @param badge the badge to set
	 */
	public void setBadge(int badge) {
		this.badge = badge;
	}

	/**
	 * @return the photo
	 */
	public int getPhoto() {
		return photo;
	}

	/**
	 * @param photo the photo to set
	 */
	public void setPhoto(int photo) {
		this.photo = photo;
	}

	/**
	 * 返回需要通知用户的计数器的和
	 * @return
	 */
	public long getCounter(){
		return follower + cmt + dm + mention_status + mention_cmt + notice + invite + photo;
	}
}
