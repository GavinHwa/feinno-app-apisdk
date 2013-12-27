/**
 * 
 */
package thirdparty.renren.renrenAPIv2.feed;


import thirdparty.renren.renrenAPIv2.Feed;
import thirdparty.renren.renrenAPIv2.RenRenOutput;

import java.util.LinkedList;
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
public class ListOutput extends RenRenOutput {
	private List<Feed> response = new LinkedList<Feed>();

    public List<Feed> getResponse() {
        return response;
    }

    public void setResponse(List<Feed> response) {
        this.response = response;
    }
}
