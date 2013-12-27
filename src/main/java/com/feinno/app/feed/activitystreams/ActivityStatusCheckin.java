package com.feinno.app.feed.activitystreams;


/**
 * 签到功能的状态实体
 * 
 * @author youguicheng
 * 
 */
public class ActivityStatusCheckin extends ActivityObject {

	public ActivityStatusCheckin() {
		super(ActivityObjectType.CHECKIN);
	}

	private String summary;
	private String link;
	private ActivityPhoto photo;
	private ActivityVideo video;

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public ActivityPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(ActivityPhoto photo) {
		this.photo = photo;
	}

	public ActivityVideo getVideo() {
		return video;
	}

	public void setVideo(ActivityVideo video) {
		this.video = video;
	}

}
