/*
 * Fetion Connect
 *  
 * Create by Zhaobingkun 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


public class ActivityTarget extends ActivityMedia {

	public ActivityTarget() {
		super(ActivityObjectType.TARGET);
	}

	private String name;
	private String permalink;
	private int userid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String permalink) {
		this.permalink = permalink;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}
}
