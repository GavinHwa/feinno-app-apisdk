/**
 * 
 */
package thirdparty.sina.oauth1.friends;


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

import thirdparty.FollowedUserIds;
import thirdparty.sina.oauth1.SinaOauth1Output;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用status的数组形式就行，不用类封装了
 * 
 * @author shangrenpeng
 * @date 2012-9-24 下午5:24:30
 * 
 */

public class IdsOutput1 extends SinaOauth1Output implements FollowedUserIds {

    private List<String> ids = new ArrayList<String>();
    private int next_cursor = 0;
    private int previous_cursor = 0;

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = ids;
    }

    public int getNext_cursor() {
        return next_cursor;
    }

    public void setNext_cursor(int next_cursor) {
        this.next_cursor = next_cursor;
    }

    public int getPrevious_cursor() {
        return previous_cursor;
    }

    public void setPrevious_cursor(int previous_cursor) {
        this.previous_cursor = previous_cursor;
    }

    @Override
    public List<String> getFollowedUserIds() {
        return ids;
    }
}