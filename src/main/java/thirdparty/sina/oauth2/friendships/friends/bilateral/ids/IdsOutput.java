/**
 * 
 */
package thirdparty.sina.oauth2.friendships.friends.bilateral.ids;

import thirdparty.FollowedUserIds;
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
public class IdsOutput extends SinaOauth2Output implements FollowedUserIds {
	private List<String> ids = new ArrayList<String>();
    private int total_number = 0;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public int getTotal_number() {
        return total_number;
    }

    public void setTotal_number(int total_number) {
        this.total_number = total_number;
    }

    @Override
    public List<String> getFollowedUserIds() {
        return ids;
    }
}
