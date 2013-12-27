/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


import thirdparty.sina.Annotations;
import thirdparty.sina.Geo;
import thirdparty.sina.Status;
import thirdparty.sina.User;
import thirdparty.sina.oauth2.SinaOauth2Output;

import java.util.List;

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
 * @author shangrenpeng
 * @date 2012-9-20 下午8:34:16
 * 
 */
public class RepostOutput extends SinaOauth2Output {
	private String idstr;// 字符串型的微博ID
	private String created_at;// 创建时间
	private long id;// 微博ID
	private String text;// 微博信息内容
	private String source;// 微博来源
	private boolean favorited;// 是否已收藏
	private boolean truncated;// 是否被截断
	private long in_reply_to_status_id;// 回复ID
	private long in_reply_to_user_id;// 回复人UID
	private String in_reply_to_screen_name;// 回复人昵称
	private long mid;// 微博MID
	private String bmiddle_pic;// 中等尺寸图片地址
	private String original_pic;// 原始图片地址
	private String thumbnail_pic;// 缩略图片地址
	private int reposts_count;// 转发数
	private int comments_count;// 评论数
	private List<Annotations> annotations;// 微博附加注释信息
	private Geo geo;// 地理信息字段
	private User user;// 微博作者的用户信息字段
	private Status retweeted_status;// 转发的微博信息字段
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
	 * @return the favorited
	 */
	public boolean isFavorited() {
		return favorited;
	}
	/**
	 * @param favorited the favorited to set
	 */
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	/**
	 * @return the truncated
	 */
	public boolean isTruncated() {
		return truncated;
	}
	/**
	 * @param truncated the truncated to set
	 */
	public void setTruncated(boolean truncated) {
		this.truncated = truncated;
	}
	/**
	 * @return the in_reply_to_status_id
	 */
	public long getIn_reply_to_status_id() {
		return in_reply_to_status_id;
	}
	/**
	 * @param in_reply_to_status_id the in_reply_to_status_id to set
	 */
	public void setIn_reply_to_status_id(long in_reply_to_status_id) {
		this.in_reply_to_status_id = in_reply_to_status_id;
	}
	/**
	 * @return the in_reply_to_user_id
	 */
	public long getIn_reply_to_user_id() {
		return in_reply_to_user_id;
	}
	/**
	 * @param in_reply_to_user_id the in_reply_to_user_id to set
	 */
	public void setIn_reply_to_user_id(long in_reply_to_user_id) {
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
	 * @return the mid
	 */
	public long getMid() {
		return mid;
	}
	/**
	 * @param mid the mid to set
	 */
	public void setMid(long mid) {
		this.mid = mid;
	}
	/**
	 * @return the bmiddle_pic
	 */
	public String getBmiddle_pic() {
		return bmiddle_pic;
	}
	/**
	 * @param bmiddle_pic the bmiddle_pic to set
	 */
	public void setBmiddle_pic(String bmiddle_pic) {
		this.bmiddle_pic = bmiddle_pic;
	}
	/**
	 * @return the original_pic
	 */
	public String getOriginal_pic() {
		return original_pic;
	}
	/**
	 * @param original_pic the original_pic to set
	 */
	public void setOriginal_pic(String original_pic) {
		this.original_pic = original_pic;
	}
	/**
	 * @return the thumbnail_pic
	 */
	public String getThumbnail_pic() {
		return thumbnail_pic;
	}
	/**
	 * @param thumbnail_pic the thumbnail_pic to set
	 */
	public void setThumbnail_pic(String thumbnail_pic) {
		this.thumbnail_pic = thumbnail_pic;
	}
	/**
	 * @return the reposts_count
	 */
	public int getReposts_count() {
		return reposts_count;
	}
	/**
	 * @param reposts_count the reposts_count to set
	 */
	public void setReposts_count(int reposts_count) {
		this.reposts_count = reposts_count;
	}
	/**
	 * @return the comments_count
	 */
	public int getComments_count() {
		return comments_count;
	}
	/**
	 * @param comments_count the comments_count to set
	 */
	public void setComments_count(int comments_count) {
		this.comments_count = comments_count;
	}
	/**
	 * @return the annotations
	 */
	public List<Annotations> getAnnotations() {
		return annotations;
	}
	/**
	 * @param annotations the annotations to set
	 */
	public void setAnnotations(List<Annotations> annotations) {
		this.annotations = annotations;
	}
	/**
	 * @return the geo
	 */
	public Geo getGeo() {
		return geo;
	}
	/**
	 * @param geo the geo to set
	 */
	public void setGeo(Geo geo) {
		this.geo = geo;
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
