package thirdparty.rss;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RssUtils {

	    public static final Pattern PATTERN = Pattern.compile("<img\\s+(?:[^>]*)src\\s*=\\s*([^>]+)",
	    		Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);   
	    
	    public static final Pattern PATTERN1 = Pattern.compile("href\\s*=\\s*([^>]+)",
	    		Pattern.CASE_INSENSITIVE | Pattern.MULTILINE);   
	    
	    public static String replace(String strSource,String strFrom,String strTo)   { 
	        if(strFrom == null || strFrom.equals( " ")) 
	            return strSource; 
	        String strDest = " "; 
	        int intFromLen = strFrom.length(); 
	        int intPos; 
	        while((intPos = strSource.indexOf(strFrom)) != -1)   { 
	           strDest = strDest + strSource.substring(0,intPos); 
	           strDest = strDest + strTo; 
	           strSource = strSource.substring(intPos + intFromLen);
	    }
	        strDest = strDest + strSource;
	        return strDest; 
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
	        Matcher matcher = PATTERN.matcher(html);   
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

	    public   static   List<String>   getHref(String   html)   {   
	        Matcher matcher = PATTERN1.matcher(html);   
	        List<String> list = new ArrayList<String>();   
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

	    public static void main(String[] args) 
		{   
		        String   html   = "<img src=\"http://img3.douban.com/mpic/s6710048.jpg\" style=\"float:right;margin-left:16px\"/><a"+
		        "href=\"http://www.douban.com/people/http://www.douban.com/people/suzhenshu//\">蘇枕書</a>评论: <a href=\"http://www.douban.com/subject/http://book.douban.com/subject/6714015//\">源氏物语</a><br/>"+
		        "<br/>评价: 力荐<br/><br/>以下内容都是胡诌，请方家宽容。"+
		        "<br/>"+
		        "<br/>－－－－－"+
		        "<br/>那位被形容作夕颜花的女子，住在五条蔓草丛生的院内，恰与源氏乳母比邻。源氏欲与六条妃子幽会，途径乳母门前，得知乳母在病中，遂去探病。见到西邻院中开着夕颜花，便摘一朵。院中人隔门赠以白纸扇，遣女童告知曰夕颜花枝软弱，不胜手持。"+
		        "<br/>"+
		        "<br/>（1）扇上有两句诗，原句为：“心あてに それかとぞ見る 白露の 光そへたる 夕顔の花”"+
		        "<br/>"+
		        "<br/>丰子恺译为：“夕颜凝露容光艳，料是伊人驻...";


		        String srcString = "虾米评论: 绞河镇的最后一夜 (http://book.douban.com/subject/6424619/)"+
		        	"评价: 推荐"+

		        	"个人生活和文学创作中的断片乃至八卦被无限放大，似乎是每一个或畅销或经典的作家的必然命运。而身为“两栖”巨星的约翰•欧文显然不以为然，他在甫一出版便";


		        int start = srcString.indexOf("评价");
		        int end = start+6;
		        System.out.println(srcString.substring(0, start)+srcString.substring(end,srcString.length()));
		        System.out.println(getImgSrc(html)); 
		        String href = getHref(html).get(1);
		        System.out.println(href.substring(30, href.length()));
		        
		 }   
}




