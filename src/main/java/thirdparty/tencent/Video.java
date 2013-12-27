/**
 * 
 */
package thirdparty.tencent;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.Video.java
 *
 * date		| author	| version	|  
 * 2012-12-11	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-11 上午11:39:15
 *
 */
public class Video {
	
	private String	picurl;//缩略图,
	private String	player;//播放器地址,
	private String	realurl;//视频原地址,
	private String	shorturl;//视频的短url,
	private String	title;//视频标题
	
	/**
	 * @return the picurl
	 */
	public String getPicurl() {
		return picurl;
	}
	/**
	 * @param picurl the picurl to set
	 */
	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}
	/**
	 * @return the player
	 */
	public String getPlayer() {
		return player;
	}
	/**
	 * @param player the player to set
	 */
	public void setPlayer(String player) {
		this.player = player;
	}
	/**
	 * @return the realurl
	 */
	public String getRealurl() {
		return realurl;
	}
	/**
	 * @param realurl the realurl to set
	 */
	public void setRealurl(String realurl) {
		this.realurl = realurl;
	}
	/**
	 * @return the shorturl
	 */
	public String getShorturl() {
		return shorturl;
	}
	/**
	 * @param shorturl the shorturl to set
	 */
	public void setShorturl(String shorturl) {
		this.shorturl = shorturl;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
