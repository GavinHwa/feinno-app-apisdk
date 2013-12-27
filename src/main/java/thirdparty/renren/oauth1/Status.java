/**
 * 
 */
package thirdparty.renren.oauth1;

import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.Status.java
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
 * @date	2013-1-4 下午5:38:02
 *
 */
public class Status {
	private String post_id;//表示新鲜事的id
	private String source_id;//表示新鲜事内容主体的id，例如日志id、相册id和分享id等等
	private String feed_type;//表示新鲜事类型
	// 10-更新状态的新鲜事；11-page更新状态的新鲜事
	// ；20-发表日志的新鲜事；21-分享日志的新鲜事；22-page发表日志的新鲜事；23-page分享日志的新鲜事；30-上传照片的新鲜事；
	// 31-page上传照片的新鲜事；32-分享照片的新鲜事；33-分享相册的新鲜事；34-修改头像的新鲜事；35-page修改头像的新鲜事；
	// 36-page分享照片的新鲜事；40-成为好友的新鲜事；41-成为page粉丝的新鲜事；50-分享视频的新鲜事；51-分享链接的新鲜事；
	// 52-分享音乐的新鲜事；53-page分享视频的新鲜事；54-page分享链接的新鲜事；55-page分享音乐的新鲜事。 
	private String update_time;//表示新鲜事更新时间
	private String actor_id;//表示新鲜事用户的id
	private String name;//表示新鲜事用户的姓名
	private String actor_type;//表示新鲜事发起者的类型，目前有“user”，“page”。user代表人人网用户新鲜事，page代表公共主页新鲜事。
	private String headurl;//表示新鲜事用户的头像
	private String prefix;//表示新鲜事内容的前缀
	private String message;//表示新鲜事用户自定义输入内容，状态
	private String title;//表示新鲜事的主题内容
	private String href;//表示新鲜事主题的相关链接
	private String description;//表示新鲜事的具体内容
	private List<FeedMedia> attachment;//表示新鲜事中包含的媒体内容，例如照片、视频等
	private Comments comments;//表示新鲜事中包含的评论内容，目前返回最新和最早的评论
	private Like likes;//表示赞相关的信息
	private String uid;//表示赞操作的用户id
	private Source source;//表示消息来源,不一定全有啊
	private Place place;//表示新鲜事发生的地点 
	/**
	 * @return the post_id
	 */
	public String getPost_id() {
		return post_id;
	}
	/**
	 * @param post_id the post_id to set
	 */
	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}
	/**
	 * @return the source_id
	 */
	public String getSource_id() {
		return source_id;
	}
	/**
	 * @param source_id the source_id to set
	 */
	public void setSource_id(String source_id) {
		this.source_id = source_id;
	}
	/**
	 * @return the feed_type
	 */
	public String getFeed_type() {
		return feed_type;
	}
	/**
	 * @param feed_type the feed_type to set
	 */
	public void setFeed_type(String feed_type) {
		this.feed_type = feed_type;
	}
	/**
	 * @return the update_time
	 */
	public String getUpdate_time() {
		return update_time;
	}
	/**
	 * @param update_time the update_time to set
	 */
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	/**
	 * @return the actor_id
	 */
	public String getActor_id() {
		return actor_id;
	}
	/**
	 * @param actor_id the actor_id to set
	 */
	public void setActor_id(String actor_id) {
		this.actor_id = actor_id;
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
	 * @return the actor_type
	 */
	public String getActor_type() {
		return actor_type;
	}
	/**
	 * @param actor_type the actor_type to set
	 */
	public void setActor_type(String actor_type) {
		this.actor_type = actor_type;
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
	 * @return the prefix
	 */
	public String getPrefix() {
		return prefix;
	}
	/**
	 * @param prefix the prefix to set
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
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
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the attachment
	 */
	public List<FeedMedia> getAttachment() {
		return attachment;
	}
	/**
	 * @param attachment the attachment to set
	 */
	public void setAttachment(List<FeedMedia> attachment) {
		this.attachment = attachment;
	}
	/**
	 * @return the comments
	 */
	public Comments getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(Comments comments) {
		this.comments = comments;
	}
	/**
	 * @return the likes
	 */
	public Like getLikes() {
		return likes;
	}
	/**
	 * @param likes the likes to set
	 */
	public void setLikes(Like likes) {
		this.likes = likes;
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
	 * @return the place
	 */
	public Place getPlace() {
		return place;
	}
	/**
	 * @param place the place to set
	 */
	public void setPlace(Place place) {
		this.place = place;
	}
}
