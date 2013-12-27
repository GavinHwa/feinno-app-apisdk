/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 动态的作者定义
 * 
 * @author 李会军
 */
public class ActivityAuthor extends ActivityObject {

	public ActivityAuthor() {
		super(ActivityObjectType.PERSON);
	}

	private String author_type;
	
	private String name;
	
	private String homepage;
	
	private String portrait;
	
	private String portraitMiddle;
	
	private int fetionId;





	  public int getFetionId() {
		return fetionId;
	}


	///@Column("fetionId")
	public ActivityAuthor setFetionId(int fetionId) {
		this.fetionId = fetionId;
		return this;
	}


	public String getPortraitMiddle() {
		return portraitMiddle;
	}


	public ActivityAuthor setPortraitMiddle(String portraitMiddle) {
		this.portraitMiddle = portraitMiddle;
		return this;
	}


	public ActivityAuthor setAuthorType(String value) {
		  this.author_type = value;
		 return this;
	   }


	public String getAuthorType() {
		return author_type;
	}

	public ActivityAuthor setName(String value) {
		this.name = value;
		return this;
	}

	public String getName() {
		return name;
	}

	public ActivityAuthor setHomepage(String value) {
		this.homepage = value;
		return this;
	}

	public String getHomepage() {
		return homepage;
	}

	public ActivityAuthor setPortrait(String value) {
		this.portrait = value;
		return this;
	}

	public String getPortrait() {
		return portrait;
	}
}
