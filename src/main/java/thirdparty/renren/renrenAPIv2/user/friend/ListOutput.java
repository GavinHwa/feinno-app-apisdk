/**
 * 
 */
package thirdparty.renren.renrenAPIv2.user.friend;

import thirdparty.FollowedUsers;
import thirdparty.ThirdPartyUser;
import thirdparty.renren.renrenAPIv2.RenRenOutput;
import thirdparty.renren.renrenAPIv2.User;

import java.util.ArrayList;
import java.util.Collections;
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
public class ListOutput extends RenRenOutput implements FollowedUsers{
	private List<User> response = new LinkedList<User>();

    public List<User> getResponse() {
        return response;
    }

    public void setResponse(List<User> response) {
        this.response = response;
    }

    @Override
    public List<ThirdPartyUser> getFollowedUsers() {
        if (null != response) {
            return new ArrayList<ThirdPartyUser>(response);
        }
        return Collections.emptyList();
    }
}
