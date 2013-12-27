/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


public class ActivityComment extends ActivityObject {

	public ActivityComment() {
		super(ActivityObjectType.COMMENT);
	}

	private String ownerId;
	private String summary;

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String value) {
		this.summary = value;
	}

	public ActivityComment setOwnerId(String ownerId) {
		this.ownerId = ownerId;
		return this;
	}

	public String getOwnerId() {
		return ownerId;
	}
}