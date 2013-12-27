/*
 * Fetion Open Platform
 *
 * Create by larry 2013-7-29
 *
 * Copyright (c) 2013 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

import java.util.List;

/**
 * @Description: TODO
 * @author: larry
 * @date:2013-7-29 下午2:00:40
 */
public class ActivityVideoAlbum  extends ActivityObject{
	
	public ActivityVideoAlbum() {
		super(ActivityObjectType.VIDEO_ALBUM);
	}
	
	private String title;
	private String permalink;
	private List<ActivityVideo> videos;
	public String getTitle() {
		return title;
	}
	public String getPermalink() {
		return permalink;
	}
	public List<ActivityVideo> getVideos() {
		return videos;
	}
	///@Column("title")
	public void setTitle(String title) {
		this.title = title;
	}
	///@Column("permalink")
	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}
	///@Column("videos")
	public void setVideos(List<ActivityVideo> videos) {
		this.videos = videos;
	}

	
	
}
