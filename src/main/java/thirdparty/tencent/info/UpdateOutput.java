/**
 * 
 */
package thirdparty.tencent.info;

import thirdparty.ThirdPartyUnreadCounter;
import thirdparty.tencent.TencentOutput;

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
public class UpdateOutput extends TencentOutput implements ThirdPartyUnreadCounter{
	private String seqid;// 不明不白的东西
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

	public class Data {
		private int home;// ：首页未读消息计数
		private int Private;// 私信页未读消息计数
		private int fans;// 新增听众数
		private int mentions;// 提及我的未读消息计数
		private int create;// 首页广播（原创）更新数
		
		/**
		 * @return the home
		 */
		public int getHome() {
			return home;
		}
		/**
		 * @param home the home to set
		 */
		public void setHome(int home) {
			this.home = home;
		}
		/**
		 * @return the sprivate
		 */
		public int getPrivate() {
			return Private;
		}
		/**
		 * @param sprivate the sprivate to set
		 */
		public void setPrivate(int sprivate) {
			this.Private = sprivate;
		}
		/**
		 * @return the fans
		 */
		public int getFans() {
			return fans;
		}
		/**
		 * @param fans the fans to set
		 */
		public void setFans(int fans) {
			this.fans = fans;
		}
		/**
		 * @return the mentions
		 */
		public int getMentions() {
			return mentions;
		}
		/**
		 * @param mentions the mentions to set
		 */
		public void setMentions(int mentions) {
			this.mentions = mentions;
		}
		/**
		 * @return the create
		 */
		public int getCreate() {
			return create;
		}
		/**
		 * @param create the create to set
		 */
		public void setCreate(int create) {
			this.create = create;
		}
	}

	/* (non-Javadoc)
	 * @see com.feinno.message.ThirdPartyUnreadCounter#getCounter()
	 */
	@Override
	public long getCounter() {
		if (data != null){
			return data.getPrivate() + data.getFans() + data.getMentions();	
		}
		return 0;
	}
}
