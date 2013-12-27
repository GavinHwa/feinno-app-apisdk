/**
 * 
 */
package thirdparty;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.ThirdPartyUser.java
 *
 * date		| author	| version	|  
 * 2012-9-22	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-22 下午8:23:31
 *
 */
public interface ThirdPartyRefreshToken {
	public String getAccessToken();
	/**
	 * 这个方法返回的是超期的日期，而不是有效时长,单位ms
	 * @return
	 */
	public long getExpireIn();
	public String getRefreshToken();
}
