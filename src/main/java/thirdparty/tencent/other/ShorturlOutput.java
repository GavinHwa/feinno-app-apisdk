/**
 * 
 */
package thirdparty.tencent.other;


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

import thirdparty.tencent.TencentOutput;

/**
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class ShorturlOutput extends TencentOutput {
	private Data data;
	public class Data{
		private String longurl;
		private int secu;
		/**
		 * @return the longurl
		 */
		public String getLongurl() {
			return longurl;
		}
		/**
		 * @param longurl the longurl to set
		 */
		public void setLongurl(String longurl) {
			this.longurl = longurl;
		}
		/**
		 * @return the secu
		 */
		public int getSecu() {
			return secu;
		}
		/**
		 * @param secu the secu to set
		 */
		public void setSecu(int secu) {
			this.secu = secu;
		}
	}
	public Data getData() {
		return data;
	}
	public void setData(Data data) {
		this.data = data;
	}	
}
