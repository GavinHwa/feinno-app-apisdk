/**
 * 
 */
package thirdparty.tencent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.app.sync.sina.SinaEmotionTransformer.java
 *
 * date		| author	| version	|  
 * 2012-12-7	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author shangrenpeng
 * @date 2012-12-7 上午10:33:13
 * 
 */
public class TencentEmotionTransformer {
	protected static final Logger LOGGER = LoggerFactory
			.getLogger(TencentEmotionTransformer.class);
	private static final String ourEmotions[] = { "[/大笑]", "[/微笑]", "[/愤怒]",
			"[/悲伤]", "[/睡觉]", "[/汗]", "[/鄙视]", "[/抓狂]", "[/强]", "[/OK]" };
	private static final String tencentEmotions[] = { "/呲牙", "/微笑", "/发怒",
			"/流泪", "/困", "/擦汗", "/鄙视", "/抓狂", "/强", "/OK" };
	private static final String tencentEmotionsWithQuoter[] = { "[/呲牙]", "[/微笑]", "[/发怒]",
		"[/流泪]", "[/困]", "[/擦汗]", "[/鄙视]", "[/抓狂]", "[/强]", "[/OK]" };

	public static String transform2tencent(String message) {
		for (int i = 0; i < ourEmotions.length; i++) {
			message = message.replace(ourEmotions[i], tencentEmotions[i]);
		}

		return clearSquareQuoter(message);
	}

	public static String transform2Our(String message) {
		try {
			message = EmotionMatcher.addSuareQuoter(message);
		} catch (Exception e) {
			LOGGER.error("");
		}
		for (int i = 0; i < tencentEmotions.length; i++) {
			message = message.replace(tencentEmotionsWithQuoter[i], ourEmotions[i]);
		}

		return message;
	}

	private static Pattern p2ShapMark = Pattern.compile("\\[(/.*?)\\]",
			Pattern.DOTALL);

	private static String clearSquareQuoter(String message) {
		Matcher m = p2ShapMark.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, m.group(1));
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(transform2Our("").equals(""));
		System.out.println(transform2Our("/吃西瓜").equals("[/吃西瓜]"));
		System.out.println(transform2Our("/吃西瓜/").equals("[/吃西瓜]/"));
		System.out.println(transform2Our("/").equals("/"));
		System.out.println(transform2Our("/吃").equals("[/吃]"));
		System.out.println(transform2Our("/吃冬瓜").equals("[/吃]冬瓜"));
		System.out.println(transform2Our("//吃西瓜").equals("/[/吃西瓜]"));	
		System.out.println(transform2Our("/吃西瓜 ").equals("[/吃西瓜] "));
		System.out.println(transform2Our("/吃什么好呢？/吃冬瓜").equals("[/吃]什么好呢？[/吃]冬瓜"));
		System.out.println(transform2Our("/吃什么好呢？/吃冬瓜 ").equals("[/吃]什么好呢？[/吃]冬瓜 "));
		System.out.println(transform2Our("/吃什么好呢？/吃西瓜").equals("[/吃]什么好呢？[/吃西瓜]"));
		System.out.println(transform2Our("/吃什么好呢？/吃西瓜 ").equals("[/吃]什么好呢？[/吃西瓜] "));
		System.out.println(transform2Our("什么好/吃？//吃西瓜").equals("什么好[/吃]？/[/吃西瓜]"));
		System.out.println(transform2Our("什么好/吃？//吃西瓜 ").equals("什么好[/吃]？/[/吃西瓜] "));
		System.out.println(transform2Our("什么好/吃？//吃西瓜呢").equals("什么好[/吃]？/[/吃西瓜]呢"));
		System.out.println(transform2Our("什么好/吃？//吃西瓜 呢").equals("什么好[/吃]？/[/吃西瓜] 呢"));
		System.out.println(transform2Our("什么好/吃？//吃西瓜 ").equals("什么好[/吃]？/[/吃西瓜] "));
		
		System.out.println(transform2tencent("").equals(""));
		System.out.println(transform2tencent("[/吃西瓜]").equals("/吃西瓜"));
		System.out.println(transform2tencent("[/吃西瓜]/").equals("/吃西瓜/"));
		System.out.println(transform2tencent("/").equals("/"));
		System.out.println(transform2tencent("[/吃]").equals("/吃"));
		System.out.println(transform2tencent("[/吃]冬瓜").equals("/吃冬瓜"));
		System.out.println(transform2tencent("/[/吃西瓜]").equals("//吃西瓜"));	
		System.out.println(transform2tencent("[/吃西瓜] ").equals("/吃西瓜 "));
		System.out.println(transform2tencent("[/吃]什么好呢？[/吃]冬瓜").equals("/吃什么好呢？/吃冬瓜"));
		System.out.println(transform2tencent("[/吃]什么好呢？[/吃]冬瓜 ").equals("/吃什么好呢？/吃冬瓜 "));
		System.out.println(transform2tencent("[/吃]什么好呢？[/吃西瓜]").equals("/吃什么好呢？/吃西瓜"));
		System.out.println(transform2tencent("[/吃]什么好呢？[/吃西瓜] ").equals("/吃什么好呢？/吃西瓜 "));
		System.out.println(transform2tencent("什么好[/吃]？/[/吃西瓜]").equals("什么好/吃？//吃西瓜"));
		System.out.println(transform2tencent("什么好[/吃]？/[/吃西瓜] ").equals("什么好/吃？//吃西瓜 "));
		System.out.println(transform2tencent("什么好[/吃]？/[/吃西瓜]呢").equals("什么好/吃？//吃西瓜呢"));
		System.out.println(transform2tencent("什么好[/吃]？/[/吃西瓜] 呢").equals("什么好/吃？//吃西瓜 呢"));
		System.out.println(transform2tencent("什么好[/吃]？/[/吃西瓜] ").equals("什么好/吃？//吃西瓜 "));
	}
}
