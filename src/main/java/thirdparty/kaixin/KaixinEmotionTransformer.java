/**
 * 
 */
package thirdparty.kaixin;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.kaixin.KaixinEmotionTransformer.java
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
 * @date	2012-12-19 下午4:32:40
 *
 */
public class KaixinEmotionTransformer {
	private static final String ourEmotions[] = {"[/微笑]","[/悲伤]","[/强]"};
	private static final String tencentEmotions[] = {"(#开心)","(#大哭)","(#赞扬)"};
	
	public static String transform2Kaixin(String message) {
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
	
	private static Pattern p2SquareQuoter = Pattern.compile("\\(#(.*?)\\)",Pattern.DOTALL);
	private static Pattern p2ShapMark = Pattern.compile("\\[/(.*?)\\]",Pattern.DOTALL);
	
	private static String replace2SharpMark(String message){
		Matcher m = p2ShapMark.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "(#" + m.group(1) + ")");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(transform2Kaixin("[/大笑]").equals("(#大笑)"));
		System.out.println(transform2Our("(#大笑)").equals("[/大笑]"));
		System.out.println(transform2Kaixin("[/微笑]").equals("(#开心)"));
		System.out.println(transform2Our("(#开心)").equals("[/微笑]"));
		System.out.println(transform2Our("(#大笑)(#开心)(#大哭)(#愤怒)(#汗)(#惊讶)(#鄙视)(#赞扬)(#OK)(#抓狂)(#猫咪)(#围观)(#凋谢)(#药丸)(#地雷)(#雪糕)(#魅力四射)(#药丸)(#猫咪)开心 17:17"));
	}
}
