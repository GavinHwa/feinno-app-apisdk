/**
 * 
 */
package thirdparty.tencent;

//import com.feinno.app.common.CommonConfig;
//import com.feinno.database.DataTable;
//import com.feinno.database.Database;
//import com.feinno.database.DatabaseManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author : shangrenpeng
 * @fileName : thirdparty.tencent.EmotionMatcher.java
 *
 * date		| author	| version	|  
 * 2012-12-12	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2012
 */

/**
 * @author	shangrenpeng
 * @date	2012-12-12 上午10:54:44
 *
 */
public class EmotionMatcher {
	public static class EmotionNode{
		private Character character;
		private Map<Character,EmotionNode> map= new LinkedHashMap<Character,EmotionNode>();
		
		public EmotionNode(Character character){this.character = character;}
		
		public void add(String string){
			if (string.length() > 0){
				EmotionNode node = map.get(string.charAt(0));
				if (node == null){
					node = new EmotionNode(string.charAt(0));
					map.put(string.charAt(0), node);
				}
				node.add(string.substring(1));
			}else{
				map.put(' ', new EmotionNode(' '));//用这个对象表明到此已经构成一个完整的表情。
			}
		}
		
		public StringBuilder find(String string, int begin) throws NotAEmotion{
			StringBuilder sb = new StringBuilder();
			if (lengthExceeds(string, begin) || findSpace(string, begin) || matchEnds(string, begin)){
				EmotionNode node = map.get(' ');//在trie树中用来表示结束的
				if (node == null){
					throw new NotAEmotion();
				}
				sb.append(character);
				return sb;
			}else{
				EmotionNode node = map.get(string.charAt(begin));
				sb.append(character);
				sb.append(node.find(string, begin + 1));
				return sb;
			}
		}

		/**
		 * @param string
		 * @param begin
		 * @return
		 */
		private boolean matchEnds(String string, int begin) {
			return map.get(string.charAt(begin)) == null;
		}

		/**
		 * @param string
		 * @param begin
		 * @return
		 */
		private boolean findSpace(String string, int begin) {
			return string.charAt(begin) == ' ';
		}

		/**
		 * @param string
		 * @param begin
		 * @return
		 */
		private boolean lengthExceeds(String string, int begin) {
			return string.length() - begin <= 0;
		}
	}
	
	protected static final Logger LOGGER = LoggerFactory.getLogger(EmotionMatcher.class);

	private static EmotionNode root;


    //FIXME This is not needed for users, since we save emotions in SQL. You can manually add emotions
    //to root by root.add("偷笑");
	static {
		root = new EmotionNode('/');
        root.add("偷笑");
//		Properties websiteDB = CommonConfig
//				.getWebsiteDBProperties();
//		Database fetionwebsiteDB = DatabaseManager.getDatabase(
//                "fetionwebsiteDB", websiteDB);
//
//		String sqlFmt = "SELECT Tag from FW_ThirdPartyEmotions where serviceid = ?";
//
//		DataTable table;
//		try {
//			table = fetionwebsiteDB.executeTable(sqlFmt,4);
//			for (int i = 0; i < table.getRowCount(); i++) {
//				String tag = table.getRow(i).getString(1);
//				root.add(tag.substring(1));
//			}
//		} catch (SQLException e) {
//			LOGGER.error(e.getMessage());
//		}
	}
	
	public static String addSpace(String message){
		if (message.indexOf('/') == -1){
			return message;
		}else{
			int begin = message.indexOf('/');
			try {
				String emotion = root.find(message, message.indexOf('/') + 1).toString();
//				if (emotionNotTheLastString(message, begin, emotion) || needToAddSuffixSpace(message, begin, emotion)){
				if (!emotionIsTheLastString(message, begin, emotion)){//表情后边还有字符呢，可以进行下边的判断了
					if (needToAddSuffixSpace(message, begin, emotion)){//表情后边不是空格
						message = message.replaceFirst(emotion, " " + emotion + " ");
					}else{//表情后边是空格
						message = message.replaceFirst(emotion, " " + emotion);
					}
					begin += 2;//用来跳过空格和‘/’
				}else{//表情后边没有字符啦，记得要加上后缀空格
					message = message.replaceFirst(emotion, " " + emotion + " ");
					begin += 2;//用来跳过当前的‘/’
				}
			} catch (NotAEmotion e) {//没能匹配，也要跳过一开始的‘/’
				begin += 1;
			}
			
			int next = message.indexOf('/', begin);
			if (next != -1){
				message = message.substring(0,next) + addSpace(message.substring(next));
			}
		}
		
		return message;
	}
	
	public static String addSuareQuoter(String message){
		if (message.indexOf('/') == -1){
			return message;
		}else{
			int begin = message.indexOf('/');
			try {
				String emotion = root.find(message, message.indexOf('/') + 1).toString();
					message = message.replaceFirst(emotion, "[" + emotion + "]");
					begin += 2;//用来跳过当前的‘/’
			} catch (NotAEmotion e) {//没能匹配，也要跳过一开始的‘/’
				begin += 1;
			}
			
			int next = message.indexOf('/', begin);
			if (next != -1){
				message = message.substring(0,next) + addSuareQuoter(message.substring(next));
			}
		}
		
		return message;
	}

	/**
	 * 只是为了能够找表情后边的空格
	 * @param message
	 * @param begin
	 * @param emotion
	 * @return
	 */
	private static boolean emotionIsTheLastString(String message, int begin,
			String emotion) {
		return begin + emotion.length() >= message.length();
	}

	/**
	 * @param message
	 * @param begin
	 * @param emotion
	 * @return
	 */
	private static boolean needToAddSuffixSpace(String message, int begin,
			String emotion) {
		return message.charAt(begin + emotion.length()) != ' ';
	}

	public static class NotAEmotion extends Exception{

		/**
		 * 
		 */
		private static final long serialVersionUID = 2149646994082307347L;
		
	}
}
