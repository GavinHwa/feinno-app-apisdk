/**
 * 
 */
package thirdparty.renren.oauth1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.renren.RenrenEmotionTransformer.java
 *
 * date		| author	| version	|  
 * 2012-12-19	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-19 下午4:05:37
 *
 */
public class RenrenEmotionTransformer {
	protected static final Logger LOGGER = LoggerFactory.getLogger(RenrenEmotionTransformer.class);
	private static final String ourEmotions[] = {"[/愤怒]","[/悲伤]","[/睡觉]","[/强]","[/惊讶]","[/失望]"};
	private static final String tencentEmotions[] = {"(生气)","(哭)","(困)","(good)","(惊恐)","(叹气)"};
	
	public static String transform2Renren(String message) {
		for (int i = 0; i < ourEmotions.length; i++) {
			message = message.replace(ourEmotions[i], tencentEmotions[i]);
		}

		return replace2SharpMark(message);
	}

	public static String transform2Our(String message) {
		for (int i = 0; i < tencentEmotions.length; i++) {
			message = message.replace(tencentEmotions[i], ourEmotions[i]);
		}

		return replace2SquareQuoter(message);
	}
	

	private static String replace2SquareQuoter(String message){
		Matcher m = p2SquareQuoter.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "[/" + m.group(1) + "]");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	private static Pattern p2SquareQuoter = Pattern.compile("\\((.*?)\\)",Pattern.DOTALL);
	private static Pattern p2ShapMark = Pattern.compile("\\[/(.*?)\\]",Pattern.DOTALL);
	
	private static String replace2SharpMark(String message){
		Matcher m = p2ShapMark.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "(" + m.group(1) + ")");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(transform2Renren("[/大笑]").equals("(大笑)"));
		System.out.println(transform2Our("(大笑)").equals("[/大笑]"));
		System.out.println(transform2Renren("[/失望]").equals("(叹气)"));
		System.out.println(transform2Our("(叹气)").equals("[/失望]"));
	}
}
