/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义的动态的来源
 * 
 * @author 李会军
 */
public class ActivitySource extends ActivityObject {
	public static final String DEFAULT_URL="http://i.feixin.10086.cn";
	
	//public static final String DEFAULT_URL="http://i.fx-inte.com:8082";
	
	//public static final String DEFAULT_URL="http://space.urapport.net";

	public ActivitySource() {
		super(ActivityObjectType.SOURCE);
	}

	private String title;
	private String permalink;
	private String icon;

	public String getTitle() {
		return title;
	}

	public ActivitySource setTitle(String value) {
		this.title = value;
		return this;
	}

	public String getPermalink() {
		return permalink;
	}

	public ActivitySource setPermalink(String value) {
		this.permalink = value;
		return this;
	}

	public String getIcon() {
		return icon;
	}

	public ActivitySource setIcon(String value) {
		this.icon = value;
		return this;
	}

	public static ActivitySource defaultSource = new ActivitySource().setIcon("http://i-res.fetionpic.com/service/icon/pre_feixin_16.png").setPermalink(DEFAULT_URL).setTitle("飞信同窗");
	//public static ActivitySource defaultSource = new ActivitySource().setIcon("http://res.i.fx-inte.com:8082/service/icon/pre_feixin_16.png").setPermalink(DEFAULT_URL).setTitle("飞信同窗");

	public static ActivitySource getDefaultSource() {
		return defaultSource;
	}

	public static int getDefaultSourceId() {
		return 0;
	}
}
