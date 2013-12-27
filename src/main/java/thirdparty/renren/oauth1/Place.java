/**
 * 
 */
package thirdparty.renren.oauth1;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.Place.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-4 下午5:47:12
 *
 */
public class Place {
	private String lbs_id;//表示新鲜事发生地点的ID，place子节点
	private String name;//表示新鲜事发生地点的名称place子节点
	private String address;//表示新鲜事发生地点的地址place子节点
	private String url;//表示新鲜事发生地点所要链接到的URL，place子节点
	private String longitude;//表示新鲜事发生的地点的经度place子节点
	private String latitude;//表示新鲜事发生的地点的纬度place子节点
	/**
	 * @return the lbs_id
	 */
	public String getLbs_id() {
		return lbs_id;
	}
	/**
	 * @param lbs_id the lbs_id to set
	 */
	public void setLbs_id(String lbs_id) {
		this.lbs_id = lbs_id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
}
