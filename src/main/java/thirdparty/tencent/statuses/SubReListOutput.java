/**
 * 
 */
package thirdparty.tencent.statuses;

import thirdparty.tencent.Status;
import thirdparty.tencent.TencentOutput;

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
public class SubReListOutput extends TencentOutput {
	private String seqid;//不明不白的东西
	private Data data;

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public String getSeqid() {
		return seqid;
	}

	public void setSeqid(String seqid) {
		this.seqid = seqid;
	}
	public class Data{
		private List<Status> info;
		private long timestamp;//服务器时间戳，不能用于翻页
		private int hasnext;//0-表示还有微博可拉取，1-已拉取完毕
		//user//name : nick 当页数据涉及到的用户的帐号与昵称映射
		/**
		 * @return the info
		 */
		public List<Status> getInfo() {
			return info;
		}
		/**
		 * @param info the info to set
		 */
		public void setInfo(List<Status> info) {
			this.info = info;
		}
		/**
		 * @return the timestamp
		 */
		public long getTimestamp() {
			return timestamp;
		}
		/**
		 * @param timestamp the timestamp to set
		 */
		public void setTimestamp(long timestamp) {
			this.timestamp = timestamp;
		}
		/**
		 * @return the hasnext
		 */
		public int getHasnext() {
			return hasnext;
		}
		/**
		 * @param hasnext the hasnext to set
		 */
		public void setHasnext(int hasnext) {
			this.hasnext = hasnext;
		}
	}
}
