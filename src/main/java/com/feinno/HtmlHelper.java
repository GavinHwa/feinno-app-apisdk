package com.feinno;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlHelper {
	private static Map<String, Character> map = new LinkedHashMap<String, Character>();
	public static final Pattern IMGPATTERN = Pattern.compile("<img\\s+(?:[^>]*)src\\s*=\\s*([^>]+)",
    		Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);   

	static {
		map.put("&quot;", (char) 34);
		map.put("&amp;", (char) 38);
		map.put("&lt;", (char) 60);
		map.put("&gt;", (char) 62);
		map.put("&nbsp;", (char) 160);
//		map.put("&iexcl;", (char) 161);
//		map.put("&cent;", (char) 162);
//		map.put("&pound;", (char) 163);
//		map.put("&curren;", (char) 164);
//		map.put("&yen;", (char) 165);
//		map.put("&brvbar;", (char) 166);
//		map.put("&sect;", (char) 167);
//		map.put("&uml;", (char) 168);
//		map.put("&copy;", (char) 169);
//		map.put("&ordf;", (char) 170);
//		map.put("&laquo;", (char) 171);
//		map.put("&not;", (char) 172);
//		map.put("&shy;", (char) 173);
//		map.put("&reg;", (char) 174);
//		map.put("&macr;", (char) 175);
//		map.put("&deg;", (char) 176);
//		map.put("&plusmn;", (char) 177);
//		map.put("&sup2;", (char) 178);
//		map.put("&sup3;", (char) 179);
//		map.put("&acute;", (char) 180);
//		map.put("&micro;", (char) 181);
//		map.put("&para;", (char) 182);
//		map.put("&middot;", (char) 183);
//		map.put("&cedil;", (char) 184);
//		map.put("&sup1;", (char) 185);
//		map.put("&ordm;", (char) 186);
//		map.put("&raquo;", (char) 187);
//		map.put("&frac14;", (char) 188);
//		map.put("&frac12;", (char) 189);
//		map.put("&frac34;", (char) 190);
//		map.put("&iquest;", (char) 191);
//		map.put("&times;", (char) 215);
//		map.put("&divide;", (char) 247);
//		map.put("&Agrave;", (char) 192);
//		map.put("&Aacute;", (char) 193);
//		map.put("&Acirc;", (char) 194);
//		map.put("&Atilde;", (char) 195);
//		map.put("&Auml;", (char) 196);
//		map.put("&Aring;", (char) 197);
//		map.put("&AElig;", (char) 198);
//		map.put("&Ccedil;", (char) 199);
//		map.put("&Egrave;", (char) 200);
//		map.put("&Eacute;", (char) 201);
//		map.put("&Ecirc;", (char) 202);
//		map.put("&Euml;", (char) 203);
//		map.put("&Igrave;", (char) 204);
//		map.put("&Iacute;", (char) 205);
//		map.put("&Icirc;", (char) 206);
//		map.put("&Iuml;", (char) 207);
//		map.put("&ETH;", (char) 208);
//		map.put("&Ntilde;", (char) 209);
//		map.put("&Ograve;", (char) 210);
//		map.put("&Oacute;", (char) 211);
//		map.put("&Ocirc;", (char) 212);
//		map.put("&Otilde;", (char) 213);
//		map.put("&Ouml;", (char) 214);
//		map.put("&Oslash;", (char) 216);
//		map.put("&Ugrave;", (char) 217);
//		map.put("&Uacute;", (char) 218);
//		map.put("&Ucirc;", (char) 219);
//		map.put("&Uuml;", (char) 220);
//		map.put("&Yacute;", (char) 221);
//		map.put("&THORN;", (char) 222);
//		map.put("&szlig;", (char) 223);
//		map.put("&agrave;", (char) 224);
//		map.put("&aacute;", (char) 225);
//		map.put("&acirc;", (char) 226);
//		map.put("&atilde;", (char) 227);
//		map.put("&auml;", (char) 228);
//		map.put("&aring;", (char) 229);
//		map.put("&aelig;", (char) 230);
//		map.put("&ccedil;", (char) 231);
//		map.put("&egrave;", (char) 232);
//		map.put("&eacute;", (char) 233);
//		map.put("&ecirc;", (char) 234);
//		map.put("&euml;", (char) 235);
//		map.put("&igrave;", (char) 236);
//		map.put("&iacute;", (char) 237);
//		map.put("&icirc;", (char) 238);
//		map.put("&iuml;", (char) 239);
//		map.put("&eth;", (char) 240);
//		map.put("&ntilde;", (char) 241);
//		map.put("&ograve;", (char) 242);
//		map.put("&oacute;", (char) 243);
//		map.put("&ocirc;", (char) 244);
//		map.put("&otilde;", (char) 245);
//		map.put("&ouml;", (char) 246);
//		map.put("&oslash;", (char) 248);
//		map.put("&ugrave;", (char) 249);
//		map.put("&uacute;", (char) 250);
//		map.put("&ucirc;", (char) 251);
//		map.put("&uuml;", (char) 252);
//		map.put("&yacute;", (char) 253);
//		map.put("&thorn;", (char) 254);
//		map.put("&yuml;", (char) 255);
	}

	/**
	 * 
	 * Find the Html Entity and convert it back to a regular character if the
	 * 
	 * entity exists, otherwise return the same string.
	 * 
	 * @param str
	 * 
	 * @return Character represented by HTML Entity or the same string if
	 *         unknown entity.
	 */
	private static String fromHtmlEntity(String str) {
		Character ch = map.get(str);
		return (ch != null) ? ch.toString() : str;
	}

	/**
	 * 
	 * Finds the value and returns the key that corresponds to that value. If
	 * value not found
	 * 
	 * returns null.
	 * 
	 * @param value
	 *            The value to be found.
	 * 
	 * @return The key corresponding to the value that was found or null if
	 *         value not found.
	 */
	private static String findValue(char value) {
		Set<String> keySet = map.keySet();
		Iterator<String> i = keySet.iterator();
		String key = i.next(); // key
		boolean found = false;
		String result = null;
		while (i.hasNext() && !found) {
			if (map.get(key).charValue() == value) {
				found = true;
				result = key;
			}
			key = i.next();
		}
		return result;
	}

	/**
	 * 
	 * Converts special characters in ASCII into html entities (e.g. & -> &amp;)
	 * 
	 * @param encode
	 *            The string to be encoded.
	 * 
	 * @return The encoded string with HTML entities.
	 */
	public static String encode(String encode) {
		StringBuilder str = new StringBuilder(encode);
		String key;
		int i = 0;
		// loop over all the characters in the string
		while (i < str.length()) {
			// try matching a character to an entity
			key = findValue(str.charAt(i));
			if (key != null) {
				str.replace(i, i + 1, key);
				i += key.length();
			} else {
				i++;
			}
		}
		return str.toString();
	}

	/**
	 * 
	 * Converts html entities (e.g. &amp;) into real characters (ASCII
	 * characters, e.g. &amp; -> &)
	 * 
	 * @param decode
	 *            A string to be decoded.
	 * 
	 * @return The string decoded with no HTML entities.
	 */
	public static String decode(String decode) {
		StringBuilder str = new StringBuilder(decode);
		Matcher m = Pattern.compile("&[A-Za-z]+;").matcher(str);
		String replaceStr = null;
		int matchPointer = 0;
		while (m.find(matchPointer)) {
			// check if we have a corresponding key in our map
			replaceStr = fromHtmlEntity(m.group());
			str.replace(m.start(), m.end(), replaceStr);
			matchPointer = m.start() + replaceStr.length();
		}
		return str.toString();
	}

	public static String cleanHtml(String htmlStr) {
		if (htmlStr == null)
			return null;
		return htmlStr.replaceAll("\\<.*?\\>", "");
	}
	
	public static String cleanHtmlExceptP(String htmlStr) {
		if (htmlStr == null)
			return null;
		StringBuffer sb = new StringBuffer();
		Matcher m = htmlPattern.matcher(htmlStr);
		while (m.find()) {
			if (m.group().matches("\\<p.*?\\>")){
				m.appendReplacement(sb, "<p>");
			}else if (m.group().matches("\\</p.*?\\>")){
				m.appendReplacement(sb, "</p>");
			}else{
				m.appendReplacement(sb, "");
			}
		}
		m.appendTail(sb);
		return sb.toString();
	}
	
	private static Pattern jsPattern = Pattern.compile("\\<script.*?\\/script>",Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	private static Pattern htmlPattern = Pattern.compile("\\<.*?\\>",Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	/**
	 * 这个可以避免<html testsrc=\"test>test\">test</html>，但是需要用升级的吗？因为没有类似的bug呢
	 */
	@SuppressWarnings("unused")
	private static Pattern htmlPatternUpdateV1 = Pattern.compile("(\\<.*?([\"'].*?[\"'])+?.*?\\>)|(\\<.*?\\>)",Pattern.DOTALL | Pattern.CASE_INSENSITIVE);
	
	
	public static String cleanJS(String htmlStr) {
		if (htmlStr == null)
			return null;
		return htmlStr.replaceAll("\\<script.*?\\/script>", "");
	}
	
	/**
	 * 处理了多行js标签没有匹配的问题
	 * @param htmlStr
	 * @return
	 */
	public static String cleanMultiLineJS(String htmlStr) {
		if (htmlStr == null)
			return null;
		return jsPattern.matcher(htmlStr).replaceAll("");
	}
	
	/**
     * 根据html内容寻找img
     * @param html
     * @return
     */
    public   static   List<String>   getImgSrc(String   html)   {   
        List<String> list = new ArrayList<String>();
        if (html == null){
        	return list;
        }
        Matcher matcher = IMGPATTERN.matcher(html);   
        while(matcher.find()) {   
            String group = matcher.group(1);   
            if   (group == null)   {   
                continue;   
            }   
            //   这里可能还需要更复杂的判断,用以处理src="...."内的一些转义符   
            if   (group.startsWith("'"))   {   
                list.add(group.substring(1,   group.indexOf("'",   1)));   
            }   else   if   (group.startsWith("\""))   {   
                list.add(group.substring(1,   group.indexOf("\"",   1)));   
            }   else   {   
                list.add(group.split("\\s")[0]);   
            }   
        }   
        return   list;   
    }

	private final static String regxpForHtml = "<([^>]*)>";

	public static String filterHtml(String str) {
		if (str == null)
			return null;
		Pattern pattern = Pattern.compile(regxpForHtml);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		boolean result1 = matcher.find();
		while (result1) {
			matcher.appendReplacement(sb, "");
			result1 = matcher.find();
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	public static String cleanHtmlAndBuildImg(String str){
		if (str == null)
			return null;
		Pattern pattern = Pattern.compile(regxpForHtml);
		Matcher matcher = pattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (matcher.find()) {
			if (matcher.group().startsWith("<img")){
				matcher.appendReplacement(sb, "<div style=\"display:block;text-align:center\">" + buildPageImg(matcher.group()) + "</div>");
			}else if (matcher.group().startsWith("</p") || matcher.group().startsWith("<br")){
				matcher.appendReplacement(sb, "\n");
			}else{
				matcher.appendReplacement(sb, "");
			}
			
		}
		matcher.appendTail(sb);
		return sb.toString();
	}
	
	private final static Pattern ImgPATTERN = Pattern.compile("<img([^>]*)>");
	
	public static List<String> getImgsSrcSafe(String html) {
		List<String> list = new ArrayList<String>();
		if (html == null) {
			return list;
		}
		Matcher matcher = ImgPATTERN.matcher(html);
		while (matcher.find()) {
			String picSrc = "";
			try{
				picSrc = getImgSrcSafe(matcher.group());
				list.add(picSrc);
			}catch (Exception e) {
			}
		}
		return list;
	}
	
	private final static Pattern ImgSrcPATTERN = Pattern.compile("src=(\"|')([^(\"|')]+?)(\"|')");
	
//	public static String fetchFirstPic
	
	/**
	 * 用来匹配一个img标签中src的地址
	 * @param str
	 * @return
	 */
	public static String buildPageImg(String str) {
		try{
			return "<img src=\"" + getImgSrcSafe(str) + "\">";
		}catch (Exception e) {
			return str;
		}
		
	}
	
	/**
	 * 用来匹配一个img标签中src的地址,并且不会出错，比如"<img src=\"http://www.fqpai.com/wp-content/themes/fqp-three/includes/timthumb.php?src=http://www.fqpai.com/wp-content/uploads/2012/12/wusuo.jpg&amp;h=320&amp;w=600&amp;zc=1&amp;q=100\" style=\"width: 570px; height: 304px;\">"
	 * @param str
	 * @return
	 */
	public static String getImgSrcSafe(String str) {
		Matcher m = ImgSrcPATTERN.matcher(str);
		if (m.find()){
			return m.group(2).trim();
		}else{
			throw new RuntimeException("Not Find src!");
		}
	}

	public static void main(String[] args) {
		System.out.println(HtmlHelper.getImgSrc("<img src=\"http://www.fqpai.com/wp-content/themes/fqp-three/includes/timthumb.php?src=http://www.fqpai.com/wp-content/uploads/2012/12/wusuo.jpg&amp;h=320&amp;w=600&amp;zc=1&amp;q=100\" style=\"width: 570px; height: 304px;\">"));
		System.out.println(HtmlHelper.getImgsSrcSafe("<p style='align:center'><img src='http://cp1.douguo.net/upload/caiku/b/e/0/600_be0a1666c4723c99dfc3918b555cb390.jpg'> </p><p>做法步骤</p><p>1、豆腐切块儿备用</p><p>2、准备食材，葱蒜苗切成大块，西红柿切碎</p><p>3、锅内倒入油适量，待油七成熟了下豆腐。</p><p>4、z炸到金黄起锅备用</p><p>5、锅里留油，先炒西红柿。炒成西红柿酱，有抗癌作用。</p><p>6、不用起锅，直接放入葱花蒜苗，花椒（如果怕吃到花椒粒可以前面花椒先过油然后捞出）</p><p>7、别急着放豆腐，先加小碗开水做汁子（这时候有高汤最好，豆腐会有肉香）。再放调料，盐、十三香、海天酱油。</p><p>8、下豆腐，小火焖一会，让豆腐入味儿，大火收汁。加一小勺鸡精。就可以起锅囖！</p><p>小贴士</p><p>有高汤，豆腐更好吃。起锅之前多炖一会，豆腐更香更美味。如果还是喜欢一点辣的口味，少加点郫县豆瓣，别有一种鲜香。</p><p>心情故事</p><p>麻婆豆腐吃腻了，做点不一样的吧。家常豆腐是一道看似简单，依旧可以变化多端的菜。试试我的做法吧！</p>"));
		System.out.println("<html testsrc=\"test>test\">test</html>".replaceAll("(\\<.*?([\"'].*?[\"'])+?.*?\\>)|(\\<.*?\\>)", "-"));
	}
}
