/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义服务动态实体
 * 
 * @author 李会军
 */
public class ActivityService extends ActivityMedia {

	public ActivityService() {
		super(ActivityObjectType.SERVICE);
	}

	private String user_count;

	public void setUserCount(String userCount) {
		this.user_count = userCount;
	}

	public String getUserCount() {
		return user_count;
	}
}
