/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

import java.util.List;


/**
 * 定义动态的相册
 * 
 * @author 李会军
 * 
 */
public class ActivityAlbum extends ActivityObject {

	public ActivityAlbum() {
		super(ActivityObjectType.PHOTO_ALBUM);
	}

	private String title;
	private String permalink;
	private List<ActivityPhoto> photos;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String link) {
		this.permalink = link;
	}

	public void setPhotos(List<ActivityPhoto> photos) {
		this.photos = photos;
	}

	public List<ActivityPhoto> getPhotos() {
		return photos;
	}
}
