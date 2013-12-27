/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


public class Activity extends ActivityObject {

	public Activity() {
		super(ActivityObjectType.ACTIVITY);
	}

	private String category;
	private String published;
	private String verb;
	private ActivityObject object;
	private ActivityAuthor author;
	private ActivitySource source;
	private String summary;
	private int category_type;
	
	private String[][] userInfo;
	private String notes;
	private double xpoint;
	private double ypoint;
	private double ghashvalue;
	private int schoolId;
	private int teamId;
	

	public int getTeamId() {
		return teamId;
	}

	///@Column("teamId")
	public Activity setTeamId(int teamId) {
		this.teamId = teamId;
		return this;
	}

	public int getSchoolId() {
		return schoolId;
	}

	///@Column("schoolId")
	public Activity setSchoolId(int schoolId) {
		this.schoolId = schoolId;
		return this;
	}

	public double getXpoint() {
		return xpoint;
	}

	public Activity setXpoint(double xpoint) {
		this.xpoint = xpoint;
		return this;
	}

	public double getYpoint() {
		return ypoint;
	}

	public Activity setYpoint(double ypoint) {
		this.ypoint = ypoint;
		return this;
	}

	public double getGhashvalue() {
		return ghashvalue;
	}

	public Activity setGhashvalue(double ghashvalue) {
		this.ghashvalue = ghashvalue;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public Activity setNotes(String notes) {
		this.notes = notes;
		return this;
	}

	public String[][] getUserInfo() {
		return userInfo;
	}

	public Activity setUserInfo(String[][] userInfo) {
		this.userInfo = userInfo;
		return this;
	}

	//private String[] nickName;
	private int mergerCount;
	
	
	

	public int getMergerCount() {
		return mergerCount;
	}

	public Activity setMergerCount(int mergerCount) {
		this.mergerCount = mergerCount;
		return this;
	}
	public int getCategoryType() {
		return category_type;
	}

	public Activity setCategoryType(int value) {
		this.category_type = value;
		return this;
	}

	public Activity setPublished(String value) {
		this.published = value;
		return this;
	}

	public String getPublished() {
		return published;
	}

	public Activity setVerb(String value) {
		this.verb = value;
		return this;
	}

	public String getVerb() {
		return verb;
	}

	public Activity setCategory(String value) {
		this.category = value;
		return this;
	}

	public String getCategory() {
		return category;
	}

	public Activity setAuthor(ActivityAuthor value) {
		this.author = value;
		return this;
	}

	public ActivityAuthor getAuthor() {
		return author;
	}

	public Activity setSource(ActivitySource value) {
		this.source = value;
		return this;
	}

	public ActivitySource getSource() {
		return source;
	}

	public ActivityObject getObject() {
		return object;
	}

	public Activity setObject(ActivityObject object) {
		this.object = object;
		return this;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getSummary() {
		return summary;
	}


	
	
	
	
	
	
	
}
