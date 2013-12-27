/**
 * 
 */
package thirdparty.renren.oauth1;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.Comment.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-4 下午5:48:03
 *
 */
public class Comment {
	private String uid;//表示发表评论用户的id,comment子节点
	private String name;//表示发表评论的用户姓名comment子节点
	private String headurl;//表示发表评论的用户头像 comment子节点
	private String tinyurl;//表示发表评论的用户头像 comment子节点
	private String time;//表示评论的时间 comment子节点
	private String comment_id;//表示评论的id,comment子节点
	private String text;//表示评论的内容 comment子节点
	/**
	 * @return the uid
	 */
	public String getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(String uid) {
		this.uid = uid;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the headurl
	 */
	public String getHeadurl() {
		return headurl;
	}
	/**
	 * @param headurl the headurl to set
	 */
	public void setHeadurl(String headurl) {
		this.headurl = headurl;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the comment_id
	 */
	public String getComment_id() {
		return comment_id;
	}
	/**
	 * @param comment_id the comment_id to set
	 */
	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
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
	public String getTinyurl() {
		return tinyurl;
	}
	public void setTinyurl(String tinyurl) {
		this.tinyurl = tinyurl;
	}
}
