/**
 * 
 */
package thirdparty.sina;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.Comment.java
 *
 * date		| author	| version	|  
 * 2012-9-28	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-28 下午5:22:11
 *
 */
public class Comment {
	private String created_at;//Fri Sep 28 17:32:04 +0800 2012,
	private String id;//3495286586253777,
	private String text;
	private String source;
	private User user;
	private String mid;//":"21212092859597990",
	private String idstr;//":"3495286586253777",
	private Status status;
	private Comment reply_comment;
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
	 * @return the text
	 */
	public String getText() {
		return text;
	}
	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = SinaEmotionTransformer.transform2Our(text);
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
	 * @return the idstr
	 */
	public String getIdstr() {
		return idstr;
	}
	/**
	 * @param idstr the idstr to set
	 */
	public void setIdstr(String idstr) {
		this.idstr = idstr;
	}
	/**
	 * @return the status
	 */
	public Status getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Status status) {
		this.status = status;
	}
	/**
	 * @return the reply_comment
	 */
	public Comment getReply_comment() {
		return reply_comment;
	}
	/**
	 * @param reply_comment the reply_comment to set
	 */
	public void setReply_comment(Comment reply_comment) {
		this.reply_comment = reply_comment;
	}
}
