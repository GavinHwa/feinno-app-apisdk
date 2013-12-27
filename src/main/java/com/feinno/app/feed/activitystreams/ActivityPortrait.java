/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义头像实体
 * 
 * @author 李会军
 */
public class ActivityPortrait extends ActivityObject {

	public ActivityPortrait() {
		super(ActivityObjectType.PHOTO);
	}

	private String thumbnail;

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String value) {
		this.thumbnail = value;
	}
}
