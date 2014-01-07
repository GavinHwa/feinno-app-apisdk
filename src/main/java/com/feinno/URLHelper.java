/**
 * 
 */
package com.feinno;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : shangrenpeng
 * @fileName : com.feinno.app.common.URLHelper.java
 *
 * date		| author	| version	|  
 * 2013-1-9	| shangrenpeng	| 1.0		|
 *
 * @describe :
 *
 * ALL RIGHTS RESERVED,COPYRIGHT(C) FEINNO LIMITED 2013
 */

/**
 * @author	shangrenpeng
 * @date	2013-1-9 上午9:50:07
 *
 */
public class URLHelper {
	/**
	 * @param url
	 * @return
	 */
	public static String clearParameter(String url) {
		int i = url.indexOf('?');
		if (i != -1){
			return url.substring(0,i);
		}
		return url;
	}
	
	/** 清除第一个#后边的链接
	 * @param url
	 * @return
	 */
	public static String clearAnchor(String url) {
		int i = url.indexOf('#');
		if (i != -1){
			return url.substring(0,i);
		}
		return url;
	}
	
	/** 清除第二个#后边的链接
	 * @param url
	 * @return
	 */
	public static String clearSecondAnchor(String url) {
		int i = url.indexOf('#');
		int j = 1 + url.substring(i + 1).indexOf('#');//加1是为了跳过当前的#，j要再加1是为了补上跳过的#号的位置
		if (j != 0){
			return url.substring(0,i + j);
		}
		return url;
	}

    /**
     * 返回一段url的域名，
     * @param url
     * @return
     */
	public static String getMainPartOfURL(String url) {
		StringBuilder ans = new StringBuilder(12);
		
		int i;
		if ((i = url.indexOf("://")) != -1) {
			for (i += 3; i < url.length(); i++) {// 6是为了从http://后开始
				if (url.charAt(i) == '/') {
					return ans.toString();
				} else {
					ans.append(url.charAt(i));
				}
			}
		}

		return ans.toString();// http://www.youku.com.cn.123.321形式，没有遇到第二个/；以及不是xxxx://的地址
	}
	
	public static Map<String, String> getParameters(String url){
		Map<String, String> parametersMap = new HashMap<String, String>();
		int begin = url.indexOf("?");
		if (begin != -1 && begin < url.length() - 1){
			String parameters = url.substring(begin + 1);
			String[] parameterArray = parameters.split("&");
			for (String string : parameterArray) {
				String[] kv = string.split("=");
				if (kv.length == 2){
					parametersMap.put(kv[0], kv[1]);
				}
			}
		}
		
		return parametersMap;
	}

    public static String getDomain(String url){
        String mainPart = getMainPartOfURL(url);
        int pointCounter = 0;
        int i = mainPart.length() - 1;
        for ( ; i >= 0; i--){
            if (mainPart.charAt(i) == '.'){
                pointCounter++;
                if (pointCounter == 2) {
                    break;
                }
            }
        }

        return mainPart.substring(i + 1);
    }
}
