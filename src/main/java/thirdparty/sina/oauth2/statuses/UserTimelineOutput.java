/**
 * 
 */
package thirdparty.sina.oauth2.statuses;


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
public class UserTimelineOutput extends SinaOauth2Output {
	private List<Status> statuses;
	private boolean hasvisible;// :false,
	private long previous_cursor;// :0,
	private long next_cursor;// :3495343951700653,
	private long total_number;// :2209
	/**
	 * @return the statuses
	 */
	public List<Status> getStatuses() {
		return statuses;
	}
	/**
	 * @param statuses the statuses to set
	 */
	public void setStatuses(List<Status> statuses) {
		this.statuses = statuses;
	}
	/**
	 * @return the hasvisible
	 */
	public boolean isHasvisible() {
		return hasvisible;
	}
	/**
	 * @param hasvisible the hasvisible to set
	 */
	public void setHasvisible(boolean hasvisible) {
		this.hasvisible = hasvisible;
	}
	/**
	 * @return the previous_cursor
	 */
	public long getPrevious_cursor() {
		return previous_cursor;
	}
	/**
	 * @param previous_cursor the previous_cursor to set
	 */
	public void setPrevious_cursor(long previous_cursor) {
		this.previous_cursor = previous_cursor;
	}
	/**
	 * @return the next_cursor
	 */
	public long getNext_cursor() {
		return next_cursor;
	}
	/**
	 * @param next_cursor the next_cursor to set
	 */
	public void setNext_cursor(long next_cursor) {
		this.next_cursor = next_cursor;
	}
	/**
	 * @return the total_number
	 */
	public long getTotal_number() {
		return total_number;
	}
	/**
	 * @param total_number the total_number to set
	 */
	public void setTotal_number(long total_number) {
		this.total_number = total_number;
	}
}
