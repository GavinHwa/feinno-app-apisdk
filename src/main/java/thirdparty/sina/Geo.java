/**
 * 
 */
package thirdparty.sina;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.Geo.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-24 下午6:00:26
 *
 */
public class Geo {
	private String type;//"Point",
	private float[] coordinates;//[40.035759,116.417397]
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the coordinates
	 */
	public float[] getCoordinates() {
		return coordinates;
	}
	/**
	 * @param coordinates the coordinates to set
	 */
	public void setCoordinates(float[] coordinates) {
		this.coordinates = coordinates;
	}
}
