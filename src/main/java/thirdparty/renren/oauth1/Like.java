/**
 * 
 */
package thirdparty.renren.oauth1;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.Like.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author shangrenpeng
 * @date 2013-1-4 下午6:27:51
 * 
 */
public class Like {
	private int friend_count;
	private int user_like;
	private int total_count;
	/**
	 * @return the friend_count
	 */
	public int getFriend_count() {
		return friend_count;
	}
	/**
	 * @param friend_count the friend_count to set
	 */
	public void setFriend_count(int friend_count) {
		this.friend_count = friend_count;
	}
	/**
	 * @return the user_like
	 */
	public int getUser_like() {
		return user_like;
	}
	/**
	 * @param user_like the user_like to set
	 */
	public void setUser_like(int user_like) {
		this.user_like = user_like;
	}
	/**
	 * @return the total_count
	 */
	public int getTotal_count() {
		return total_count;
	}
	/**
	 * @param total_count the total_count to set
	 */
	public void setTotal_count(int total_count) {
		this.total_count = total_count;
	}
}
