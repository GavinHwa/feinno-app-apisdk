/**
 * 
 */
package thirdparty.sina.oauth1.statuses;

import thirdparty.sina.Status;
import thirdparty.sina.User;
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
public class RepostOutput1 extends SinaOauth1Output{
	private String created_at;//微博创建时间
	private String id;//微博ID
	private String mid;//微博MID
	private String text;//微博信息内容
	private String source;//微博来源
	private String favorited;//是否已收藏，true：是，false：否
	private String truncated;//是否被截断，true：是，false：否
	private String in_reply_to_status_id;//回复ID
	private String in_reply_to_user_id;//回复人UID
	private String in_reply_to_screen_name;//回复人昵称
	private String geo;//地理信息字段
	private User user;//微博作者的用户信息字段
	private Status retweeted_status;
	
	/**
	 * @return the created_at
	 */
	public String getCreated_at() {
		return created_at;
	}
	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the mid
	 */
	public String getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(String mid) {
		this.mid = mid;
	}
	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}
	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return the favorited
	 */
	public String getFavorited() {
		return favorited;
	}
	/**
	 * @param favorited the favorited to set
	 */
	public void setFavorited(String favorited) {
		this.favorited = favorited;
	}
	/**
	 * @return the truncated
	 */
	public String getTruncated() {
		return truncated;
	}
	/**
	 * @param truncated the truncated to set
	 */
	public void setTruncated(String truncated) {
		this.truncated = truncated;
	}
	/**
	 * @return the in_reply_to_status_id
	 */
	public String getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	/**
	 * @param in_reply_to_status_id the in_reply_to_status_id to set
	 */
	public void setIn_reply_to_status_id(String in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	/**
	 * @return the in_reply_to_user_id
	 */
	public String getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	/**
	 * @param in_reply_to_user_id the in_reply_to_user_id to set
	 */
	public void setIn_reply_to_user_id(String in_reply_to_user_id) {
		this.in_reply_to_user_id = in_reply_to_user_id;
	}
	/**
	 * @return the in_reply_to_screen_name
	 */
	public String getIn_reply_to_screen_name() {
		return in_reply_to_screen_name;
	}
	/**
	 * @param in_reply_to_screen_name the in_reply_to_screen_name to set
	 */
	public void setIn_reply_to_screen_name(String in_reply_to_screen_name) {
		this.in_reply_to_screen_name = in_reply_to_screen_name;
	}
	/**
	 * @return the geo
	 */
	public String getGeo() {
		return geo;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(String geo) {
		this.geo = geo;
	}
	/**
	 * @return the retweeted_status
	 */
	public Status getRetweeted_status() {
		return retweeted_status;
	}
	/**
	 * @param retweeted_status the retweeted_status to set
	 */
	public void setRetweeted_status(Status retweeted_status) {
		this.retweeted_status = retweeted_status;
	}
}
