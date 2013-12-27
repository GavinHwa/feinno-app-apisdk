/**
 * 
 */
package thirdparty.sina.oauth2.direct_messages;

import thirdparty.sina.PrivateMess;
import thirdparty.sina.oauth2.SinaOauth2Output;

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
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class MessOutput extends SinaOauth2Output {
	private List<PrivateMess> direct_messages;

	public List<PrivateMess> getDirect_messages() {
		return direct_messages;
	}

	public void setDirect_messages(List<PrivateMess> direct_messages) {
		this.direct_messages = direct_messages;
	}

	

	
}
