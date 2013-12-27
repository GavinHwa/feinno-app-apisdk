/**
 * 
 */
package thirdparty.renren.oauth1;

import java.util.List;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.Comments.java
 *
 * date		| author	| version	|  
 * 2013-1-4	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-4 下午6:30:11
 *
 */
public class Comments {
	private int count;//表示评论的数量 comments子节点
	private List<Comment> comment;//表示评论的具体内容comments子节点
	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}
	/**
	 * @return the comment
	 */
	public List<Comment> getComment() {
		return comment;
	}
	/**
	 * @param comment the comment to set
	 */
	public void setComment(List<Comment> comment) {
		this.comment = comment;
	}
	
}
