/**
 * 
 */
package thirdparty.sina.oauth2.place;

import thirdparty.sina.Status;
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
public class NearbyTimelineOutput extends SinaOauth2Output {
	private List<Status> statuses;
	private long total_number;// :2209

    public List<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Status> statuses) {
        this.statuses = statuses;
    }

    public long getTotal_number() {
        return total_number;
    }

    public void setTotal_number(long total_number) {
        this.total_number = total_number;
    }
}
