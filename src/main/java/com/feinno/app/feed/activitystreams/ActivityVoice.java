/*
 * Fetion Open Platform
 *
 * Create by larry 2013-9-12
 *
 * Copyright (c) 2013 北京新媒传信科技有限公司
 */
package com.feinno.app.feed.activitystreams;

/**
 * @Description: TODO
 * @author: larry
 * @date:2013-9-12 上午10:09:09
 */
public class ActivityVoice extends ActivityMedia {
	public ActivityVoice() {
		super(ActivityObjectType.VOICE);
	}

	private String tiny_url;
	private String url;
	private int length;
	private int bitrate;
	
	
	
	
	
	

	public int getBitrate() {
		return bitrate;
	}

	///@Column("bitrate")
	public void setBitrate(int bitrate) {
		this.bitrate = bitrate;
	}

	public int getLength() {
		return length;
	}

	///@Column("length")
	public void setLength(int length) {
		this.length = length;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setTinyUrl(String tinyUrl) {
		this.tiny_url = tinyUrl;
	}

	public String getTinyUrl() {
		return tiny_url;
	}
	
}
