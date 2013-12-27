/*
 * Fetion Connect
 *  
 * Create by Zhaobingkun 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

import java.util.List;


public class ActivityApp extends ActivityMedia {

	public ActivityApp() {
		super(ActivityObjectType.APP);
	}
	
	private String appSummary;
	//private String name;
	private String largeImage; // 日志的图片地址


	private String guestName;  //日志的作者昵称  
	private String guestPermalink; //日志作者主页的连接 

	private int categoryType;
	private List<String>  extr;
	private List<String> permalinkUrl;


	
	
	
	
	public int getCategoryType() {
		return categoryType;
	}

	public ActivityApp setCategoryType(int categoryType) {
		this.categoryType = categoryType;
		return this;
	}
	
	

	public List<String> getPermalinkUrl() {
		return permalinkUrl;
	}

	///@Column("permalinkUrl")
	public ActivityApp setPermalinkUrl(List<String> permalinkUrl) {
		this.permalinkUrl = permalinkUrl;
		return this;
	}

	public List getExtr() {
		return extr;
	}

	public ActivityApp setExtr(List extr) {
		this.extr = extr;
		return this;
	}

	public String getAppSummary() {
		return appSummary;
	}

	public ActivityApp setAppSummary(String appSummary) {
		this.appSummary = appSummary;
		return this;
	}

	public String getLargeImage() {
		return largeImage;
	}

	public String getGuestName() {
		return guestName;
	}

	public String getGuestPermalink() {
		return guestPermalink;
	}

	///@Column("largeImage")
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	///@Column("guestName")
	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	///@Column("guestPermalink")
	public void setGuestPermalink(String guestPermalink) {
		this.guestPermalink = guestPermalink;
	}
	
	
	
	

}
