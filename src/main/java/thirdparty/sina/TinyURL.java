/**
 * 
 */
package thirdparty.sina;


/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.TinyURL.java
 *
 * date		| author	| version	|  
 * 2012-10-18	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-10-18 下午4:59:17
 * 
 */
public class TinyURL {
	private String url_short;// 短链接
	private String url_long;// 原始长链接
	private int type;// 链接的类型，0：普通网页、1：视频、2：音乐、3：活动、5、投票
	private boolean result;// 短链的可用状态，true：可用、false：不可用。
	private Object fetchVideoOutput;//用来保存fetchvideo的结果
	
	/**
	 * @return the url_short
	 */
	public String getUrl_short() {
		return url_short;
	}
	/**
	 * @param url_short the url_short to set
	 */
	public void setUrl_short(String url_short) {
		this.url_short = url_short;
	}
	/**
	 * @return the url_long
	 */
	public String getUrl_long() {
		return url_long;
	}
	/**
	 * @param url_long the url_long to set
	 */
	public void setUrl_long(String url_long) {
		this.url_long = url_long;
	}
	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}
	/**
	 * @return the result
	 */
	public boolean isResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(boolean result) {
		this.result = result;
	}
	public Object getFetchVideoOutput() {
		return fetchVideoOutput;
	}
	public void setFetchVideoOutput(Object fetchVideoOutput) {
		this.fetchVideoOutput = fetchVideoOutput;
	}
}
