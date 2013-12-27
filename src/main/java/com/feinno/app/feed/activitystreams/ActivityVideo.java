/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义动态视频实体
 * 
 * @author 李会军
 */
public class ActivityVideo extends ActivityMedia {

	public ActivityVideo() {
		super(ActivityObjectType.VIDEO);
	}

	private String tiny_url;
	private String url;

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tiny_url = tinyUrl;
	}

	public String getTinyUrl() {
		return tiny_url;
	}
}
