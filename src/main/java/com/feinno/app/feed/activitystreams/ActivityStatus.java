/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

import java.util.List;


/**
 * 定义状态更新实体
 * 
 * @author 李会军
 */
public class ActivityStatus extends ActivityObject {

	public ActivityStatus() {
		super(ActivityObjectType.STATUS);
	}

	private String summary;
	private ActivityPhoto photo;
	private ActivityVideo video;
	private int categoryType;
	private String portraitUrl;
	
	private int schoolId;
	
	private double longitude;
	private double latitude;
	private List<String>  extr;
	
	private String groupId;
	private String groupName;
	
	
	
	
	//private int  type;


	
	

	public String getGroupId() {
		return groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	///@Column("groupId")
	public ActivityStatus setGroupId(String groupId) {
		this.groupId = groupId;
		return this;
	}

	///@Column("groupName")
	public ActivityStatus setGroupName(String groupName) {
		this.groupName = groupName;
		return this;
	}

	public String getSummary() {
		return summary;
	}

	public List<String> getExtr() {
		return extr;
	}

	///@Column("extr")
	public ActivityStatus setExtr(List<String> extr) {
		this.extr = extr;
		return this;
	}

	public int getSchoolId() {
		return schoolId;
	}

	///@Column("schoolId")
	public ActivityStatus setSchoolId(int schoolId) {
		this.schoolId = schoolId;
		return this;
	}
	
	

	public double getLongitude() {
		return longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	///@Column("longitude")
	public ActivityStatus setLongitude(double longitude) {
		this.longitude = longitude;
		return this;
	}

	///@Column("latitude")
	public ActivityStatus setLatitude(double latitude) {
		this.latitude = latitude;
		return this;
	}

	public int getCategoryType() {
		return categoryType;
	}

	///@Column("categoryType")
	public ActivityStatus setCategoryType(int categoryType) {
		this.categoryType = categoryType;
		return this;
	}

	
	
	public String getPortraitUrl() {
		return portraitUrl;
	}

	///@Column("portraitUrl")
	public ActivityStatus setPortraitUrl(String portraitUrl) {
		this.portraitUrl = portraitUrl;
		return this;
	}

	public ActivityStatus setSummary(String summary) {
		this.summary = summary;
		return this;
	}

	public ActivityPhoto getPhoto() {
		return photo;
	}

	public void setPhoto(ActivityPhoto photo) {
		this.photo = photo;
	}

	public ActivityVideo getVideo() {
		return video;
	}

	public void setVideo(ActivityVideo video) {
		this.video = video;
	}
}