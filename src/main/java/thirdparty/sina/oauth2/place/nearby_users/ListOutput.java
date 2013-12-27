/**
 * 
 */
package thirdparty.sina.oauth2.place.nearby_users;


import thirdparty.sina.States;
import thirdparty.sina.User;
import thirdparty.sina.oauth2.SinaOauth2Output;

import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.sina.oauth2.statuses.HomeTimelineMerchandise.java
 *
 * date		| author	| version	|  
 * 2012-9-24	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-9-24 下午5:24:30
 * 
 */
public class ListOutput extends SinaOauth2Output {
	private List<User> users;
	private long total_number;// :2209
    private List<States> states;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }

    public List<States> getStates() {
        return states;
    }

    public void setStates(List<States> states) {
        this.states = states;
    }
}
