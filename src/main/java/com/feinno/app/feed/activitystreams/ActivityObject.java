/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

/**
 * 动态对象结构的基类
 * 
 * @author 李会军
 */
public class ActivityObject {

	public ActivityObject(String obj_type) {
		this.obj_type = obj_type;
	}

	private String id;
	private String obj_type;

	public void setId(String value) {
		this.id = value;
	}

	public String getId() {
		return id;
	}

	public void setObjType(String value) {
		this.obj_type = value;
	}

	public String getObjType() {
		return obj_type;
	}
}
