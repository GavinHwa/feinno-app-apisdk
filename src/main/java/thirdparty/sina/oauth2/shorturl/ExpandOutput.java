/**
 * 
 */
package thirdparty.sina.oauth2.shorturl;

import thirdparty.ThirdPartyTinyUrl;
import thirdparty.sina.TinyURL;
import thirdparty.sina.oauth2.SinaOauth2Output;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.messages.thirdparty.sina.oauth2.remind.UnreadCount.java
 *
 * date		| author	| version	|  
 * 2012-9-20	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-9-20 下午5:48:44
 *
 */
public class ExpandOutput extends SinaOauth2Output implements ThirdPartyTinyUrl {
	private List<TinyURL> urls = new ArrayList<TinyURL>();

	/* (non-Javadoc)
	 * @see com.feinno.message.ThirdPartyTinyUrl#getOriUrl()
	 */
	@Override
	public String getOriUrl() {
		return getUrls().get(0).getUrl_long();
	}

	public List<TinyURL> getUrls() {
		return urls;
	}

	public void setUrls(List<TinyURL> urls) {
		this.urls = urls;
	}
	
}
