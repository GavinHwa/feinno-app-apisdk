/**
 * 
 */
package thirdparty.sina;

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
public class SinaEmotionTransformer {
	private static final String ourEmotions[] = {"[/大笑]","[/微笑]","[/悲伤]","[/愤怒]","[/睡觉]","[/OK]","[/强]"};
	private static final String sinaEmotions[] = {"[哈哈]","[呵呵]","[泪]","[怒]","[困]","[ok]","[good]"};

	public static String transform2Sina(String message) {

		for (int i = 0; i < ourEmotions.length; i++) {
			message = message.replace(ourEmotions[i], sinaEmotions[i]);
		}

		return clearSquareQuoter(message);
	}

	public static String transform2Our(String message) {

		for (int i = 0; i < sinaEmotions.length; i++) {
			message = message.replace(sinaEmotions[i], ourEmotions[i]);
		}

		return replace2SquareQuoter(message);
	}
	

	private static String replace2SquareQuoter(String message){
		Matcher m = p2SquareQuoter.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			if (m.group().startsWith("[/")){
				m.appendReplacement(sb, m.group());
			}else {
				m.appendReplacement(sb, "[/" + m.group(1) + "]");
			}
			
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	private static Pattern p2SquareQuoter = Pattern.compile("\\[(.*?)\\]",Pattern.DOTALL);
	private static Pattern p2ShapMark = Pattern.compile("\\[/(.*?)\\]",
			Pattern.DOTALL);

	private static String clearSquareQuoter(String message) {
		Matcher m = p2ShapMark.matcher(message);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement(sb, "[" + m.group(1) + "]");
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out
				.println(transform2Our(
						"#微身份勋章#[哈哈][呵呵][汗][泪][怒][鄙视][困][抓狂][ok][good][笑哈哈][有鸭梨][moc晚安][gst干嘛噜][ala得意][xb指指][lxhx走][cai羞羞][din戴熊][lb哭]")
						.equals("#微身份勋章#[/大笑][/微笑][/汗][/悲伤][/愤怒][/鄙视][/睡觉][/抓狂][/OK][/强][/笑哈哈][/有鸭梨][/moc晚安][/gst干嘛噜][/ala得意][/xb指指][/lxhx走][/cai羞羞][/din戴熊][/lb哭]"));
		System.out.println(transform2Sina("[/大笑]").equals("[哈哈]"));
		System.out.println(transform2Our("[哈哈]").equals("[/大笑]"));
		System.out.println(transform2Sina("[/汗]").equals("[汗]"));
		System.out.println(transform2Our("[汗]").equals("[/汗]"));
	}
}
