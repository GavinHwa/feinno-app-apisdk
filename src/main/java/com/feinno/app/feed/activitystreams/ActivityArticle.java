/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 动态中的文章功能
 * 
 * @author 李会军
 */
public class ActivityArticle extends ActivityMedia {

	public ActivityArticle() {
		super(ActivityObjectType.ARTICLE);
	}

	private String large_image;
	private ActivityAuthor author;
	private ActivityTarget target;

	public ActivityTarget getTarget() {
		return target;
	}

	public ActivityArticle setTarget(ActivityTarget target) {
		this.target = target;
		return this;
	}

	public void setLargeImage(String value) {
		this.large_image = value;
	}

	public String getLargeImage() {
		return large_image;
	}

	public void setAuthor(ActivityAuthor author) {
		this.author = author;
	}

	public ActivityAuthor getAuthor() {
		return author;
	}
}
