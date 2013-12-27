/**
 * 
 */
package thirdparty.rss;


/**
 * @author : shangrenpeng
 * @fileName : com.feinno.message.rss.RssInput.java
 *
 * date		| author	| version	|  
 * 2012-11-27	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

import thirdparty.Input;

/**
 * @author	shangrenpeng
 * @date	2012-11-27 下午1:44:00
 *
 */
public class RssInput extends Input {

	private String url;
	
	public RssInput(String url){
		this.url = url;
		httpMethod = "GET";
	}
	
	/* (non-Javadoc)
	 * @see thirdparty.Input#getUrl()
	 */
	@Override
	protected String getUrl() {
		return url;
	}

	/* (non-Javadoc)
	 * @see thirdparty.Input#reNewInput()
	 */
	@Override
	public void reNewInput() {
	}

}
