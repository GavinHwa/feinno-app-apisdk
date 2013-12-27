/*
 * Fetion Connect
 *  
 * Create by XJeffg 2011-8-30
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;


/**
 * 定义动态图像的实体
 * 
 * @author 李会军
 */
public class ActivityPhoto extends ActivityMedia {

	public ActivityPhoto() {
		super(ActivityObjectType.PHOTO);
	}

    public ActivityPhoto(String url,String permalink,String thumbnail){
        this();
        this.url = url;
        super.setPermalink(permalink);
        super.setThumbnail(thumbnail);
    }

	private String url;
	private String large_image;
	private int categoryType;
	


	private int type;
	

	public int getType() {
		return type;
	}

	///@Column("type")
	public void setType(int type) {
		this.type = type;
	}



	

	public int getCategoryType() {
		return categoryType;
	}

	///@Column("categoryType")
	
	public void setCategoryType(int categoryType) {
		this.categoryType = categoryType;
	}

	public String getLarge_image() {
		return large_image;
	}

	public void setLarge_image(String large_image) {
		this.large_image = large_image;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}
}
