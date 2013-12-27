/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


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

import thirdparty.sina.Comment;
import thirdparty.sina.Status;
import thirdparty.sina.User;
import thirdparty.sina.oauth2.SinaOauth2Output;

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午8:34:16
 *
 */
public class CreateOutput extends SinaOauth2Output {
	private String created_at;//评论创建时间
	private long id;//评论的ID
	private String text;//评论的内容
	private String source;//评论的来源
	private User user;//评论作者的用户信息字段
	private String mid;//评论的MID
	private String idstr;//字符串型的评论ID
	private Status status;//评论的微博信息字段
	private Comment reply_comment;//评论来源评论，当本评论属于对另一评论的回复时返回此字段
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
	public long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
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
