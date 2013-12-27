/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义媒体对象
 * 
 * @author 李会军
 */
public abstract class ActivityMedia extends ActivityObject {

	public ActivityMedia(String type) {
		super(type);
	}

	private String title;
	private String summary;
	private String thumbnail;
	private String thumbnail_m;
	private String permalink;
	private int size;
	
	
	private int high;
	private int width;
	
	
	
	public int getHigh() {
		return high;
	}

	public int getWidth() {
		return width;
	}

	///@Column("high")
	public void setHigh(int high) {
		this.high = high;
	}

	///@Column("width")
	public void setWidth(int width) {
		this.width = width;
	}

	public int getSize() {
		return size;
	}

	///@Column("size")
	public void setSize(int size) {
		this.size = size;
	}

	public String getThumbnail_m() {
		return thumbnail_m;
	}

	///@Column("thumbnail_m")
	public void setThumbnail_m(String thumbnail_m) {
		this.thumbnail_m = thumbnail_m;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String value) {
		this.title = value;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String value) {
		this.summary = value;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String value) {
		this.thumbnail = value;
	}

	public String getPermalink() {
		return permalink;
	}

	public void setPermalink(String value) {
		this.permalink = value;
	}
}
