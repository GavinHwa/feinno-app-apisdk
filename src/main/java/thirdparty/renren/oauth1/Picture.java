/**
 * 
 */
package thirdparty.renren.oauth1;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.photos.Picture.java
 *
 * date		| author	| version	|  
 * 2013-1-5	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

import thirdparty.renren.oauth1.Source;

/**
 * @author	shangrenpeng
 * @date	2013-1-5 下午6:03:45
 *
 */
public class Picture {
	private String pid;//照片的ID
	private String aid;//照片所在相册的ID
	private String uid;//照片的所有者用户ID
	private String url_tiny;//表示一张照片超小的规格
	private String url_head;//表示一张照片小的规格
	private String url_large;//表示一张照片正常的规格
	private String caption;//照片的描述信息
	private String time;//表示照片的上传时间
	private int view_count;//表示照片的查看数
	private int comment_count;//表示照片的评论数
	private Source source;//表示照片的来源
	private String text;//表示照片来源的名称
	private String href;//表示照片来源的url
	/**
	 * @return the pid
	 */
	public String getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(String pid) {
		this.pid = pid;
	}
	/**
	 * @return the aid
	 */
	public String getAid() {
		return aid;
	}
	/**
	 * @param aid the aid to set
	 */
	public void setAid(String aid) {
		this.aid = aid;
	}
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
	 * @return the url_tiny
	 */
	public String getUrl_tiny() {
		return url_tiny;
	}
	/**
	 * @param url_tiny the url_tiny to set
	 */
	public void setUrl_tiny(String url_tiny) {
		this.url_tiny = url_tiny;
	}
	/**
	 * @return the url_head
	 */
	public String getUrl_head() {
		return url_head;
	}
	/**
	 * @param url_head the url_head to set
	 */
	public void setUrl_head(String url_head) {
		this.url_head = url_head;
	}
	/**
	 * @return the url_large
	 */
	public String getUrl_large() {
		return url_large;
	}
	/**
	 * @param url_large the url_large to set
	 */
	public void setUrl_large(String url_large) {
		this.url_large = url_large;
	}
	/**
	 * @return the caption
	 */
	public String getCaption() {
		return caption;
	}
	/**
	 * @param caption the caption to set
	 */
	public void setCaption(String caption) {
		this.caption = caption;
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
	 * @return the view_count
	 */
	public int getView_count() {
		return view_count;
	}
	/**
	 * @param view_count the view_count to set
	 */
	public void setView_count(int view_count) {
		this.view_count = view_count;
	}
	/**
	 * @return the comment_count
	 */
	public int getComment_count() {
		return comment_count;
	}
	/**
	 * @param comment_count the comment_count to set
	 */
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	/**
	 * @return the source
	 */
	public Source getSource() {
		return source;
	}
	/**
	 * @param source the source to set
	 */
	public void setSource(Source source) {
		this.source = source;
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
	 * @return the href
	 */
	public String getHref() {
		return href;
	}
	/**
	 * @param href the href to set
	 */
	public void setHref(String href) {
		this.href = href;
	}
}
