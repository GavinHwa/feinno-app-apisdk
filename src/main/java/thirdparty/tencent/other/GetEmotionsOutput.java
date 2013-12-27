/**
 * 
 */
package thirdparty.tencent.other;

import thirdparty.tencent.Emotion;
import thirdparty.ThirdPartyEmotions;
import thirdparty.oauth.Arg;
import thirdparty.tencent.TencentOutput;

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
 * @author shangrenpeng
 * @date 2012-9-20 下午5:48:44
 * 
 */
public class GetEmotionsOutput extends TencentOutput implements ThirdPartyEmotions {
	private int type;//表示类型,0：默认QQ表情;1：魂儿喵喵;2：阿囧;3：哎呀猩猩;4：爱心龟;5：大眼鼓;6：唛哩唛哩轰;7：细哥细妹;8：想念熊;9：小幺鸡;10：哎哟熊;11：吕查德;12：炮炮兵;13：张小盒;14：阿狸;15：几何猫 ;16：boto;17：emoji
	private int num;//表示本类表情的个数
	private Data data;
	public class Data{
		private List<Emotion> emotions;

		public List<Emotion> getEmotions() {
			return emotions;
		}

		public void setEmotions(List<Emotion> emotions) {
			this.emotions = emotions;
		}
	}

	/**
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * @return the num
	 */
	public int getNum() {
		return num;
	}

	/**
	 * @param num the num to set
	 */
	public void setNum(int num) {
		this.num = num;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	/* (non-Javadoc)
	 * @see com.feinno.message.ThirdPartyEmotions#getEmotions()
	 */
	@Override
	public List<Arg> getEmotions() {
		List<Arg> returnEmotions = new ArrayList<Arg>(data.getEmotions().size());
		for (Emotion emotion : data.getEmotions()) {
			returnEmotions.add(new Arg(emotion.getName(),emotion.getUrl()));
		}
		return returnEmotions;
	}	
}
