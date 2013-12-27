package com.feinno.app.feed.activitystreams;

public class ActivityBeside extends ActivityObject {

	public ActivityBeside() {
		super(ActivityObjectType.BESIDE);
	}

	private ActivityAlbum album;//相册
	private ActivityVideoAlbum videoAlbum;//视频
	private ActivityVoiceAlbum voiceAlbum;//相册
	private String summary;//文字
	private double longitude;//经度,在前
	private double latitude;//纬度，在后
	private int besideType;//身边的动态标签
	private int poiId; //poiId
	private boolean largeSummary; //poiId

	
	
	public boolean isLargeSummary() {
		return largeSummary;
	}
	///@Column("largeSummary")
	public void setLargeSummary(boolean largeSummary) {
		this.largeSummary = largeSummary;
	}
	
	
	public int getBesideType() {
		return besideType;
	}
	public int getPoiId() {
		return poiId;
	}
	///@Column("besideType")
	public void setBesideType(int besideType) {
		this.besideType = besideType;
	}
	///@Column("poiId")
	public void setPoiId(int poiId) {
		this.poiId = poiId;
	}

	public ActivityAlbum getAlbum() {
		return album;
	}
	public void setAlbum(ActivityAlbum album) {
		this.album = album;
	}


	

	

	
	public ActivityVoiceAlbum getVoiceAlbum() {
		return voiceAlbum;
	}
	///@Column("voiceAlbum")
	public void setVoiceAlbum(ActivityVoiceAlbum voiceAlbum) {
		this.voiceAlbum = voiceAlbum;
	}
	public ActivityVideoAlbum getVideoAlbum() {
		return videoAlbum;
	}
	///@Column("videoAlbum")
	public void setVideoAlbum(ActivityVideoAlbum videoAlbum) {
		this.videoAlbum = videoAlbum;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
}
