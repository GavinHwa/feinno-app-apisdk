/*
 * Fetion Open Platform
 *  
 * Create by GavinHwa 2011-5-9
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno;

/**
 * StringUtils
 * 
 * @author GavinHwa
 */
public class StringUtils {
	/**
	 * Checks if a String is empty ("") or null.
	 * 
	 * <pre>
	 * StringUtils.isEmpty(null)      = true
	 * StringUtils.isEmpty("")        = true
	 * StringUtils.isEmpty(" ")       = false
	 * StringUtils.isEmpty("bob")     = false
	 * StringUtils.isEmpty("  bob  ") = false
	 * </pre>
	 * 
	 * @param str
	 *            the string to check,may be null
	 * @return <code>true</code> if the String is empty or null
	 */
	public static boolean isEmpty(String str) {
		return str == null || str.length() == 0;
	}

	/**
	 * Checks if a String is not empty ("") or null.
	 * 
	 * <pre>
	 * StringUtils.isNotEmpty(null)      = false
	 * StringUtils.isNotEmpty("")        = false
	 * StringUtils.isNotEmpty(" ")       = true
	 * StringUtils.isNotEmpty("bob")     = true
	 * StringUtils.isNotEmpty("  bob  ") = true
	 * </pre>
	 * 
	 * @param str
	 *            the String to check,may be null
	 * @return <code>true</code> if the String is not empty or null.
	 */
	public static boolean isNotEmpty(String str) {
		return !isEmpty(str);
	}

	/**
	 * <p>
	 * Compares two Strings, returning <code>true</code> if they are equal.
	 * </p>
	 * 
	 * <p>
	 * <code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered to be equal. The comparison is case sensitive.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.equals(null, null)   = true
	 * StringUtils.equals(null, "abc")  = false
	 * StringUtils.equals("abc", null)  = false
	 * StringUtils.equals("abc", "abc") = true
	 * StringUtils.equals("abc", "ABC") = false
	 * </pre>
	 * 
	 * @see java.lang.String#equals(Object)
	 * @param str1
	 *            the first String, may be null
	 * @param str2
	 *            the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case sensitive, or
	 *         both <code>null</code>
	 */
	public static boolean equals(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equals(str2);
	}

	/**
	 * <p>
	 * Compares two Strings, returning <code>true</code> if they are equal
	 * ignoring the case.
	 * </p>
	 * 
	 * <p>
	 * <code>null</code>s are handled without exceptions. Two <code>null</code>
	 * references are considered equal. Comparison is case insensitive.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.equalsIgnoreCase(null, null)   = true
	 * StringUtils.equalsIgnoreCase(null, "abc")  = false
	 * StringUtils.equalsIgnoreCase("abc", null)  = false
	 * StringUtils.equalsIgnoreCase("abc", "abc") = true
	 * StringUtils.equalsIgnoreCase("abc", "ABC") = true
	 * </pre>
	 * 
	 * @see java.lang.String#equalsIgnoreCase(String)
	 * @param str1
	 *            the first String, may be null
	 * @param str2
	 *            the second String, may be null
	 * @return <code>true</code> if the Strings are equal, case insensitive, or
	 *         both <code>null</code>
	 */
	public static boolean equalsIgnoreCase(String str1, String str2) {
		return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
	}

	/**
	 * <p>
	 * Counts the length of String.
	 * </p>
	 * 
	 * <pre>
	 * StringUtils.count(null)			= 0
	 * StringUtils.count("")			= 0
	 * StringUtils.count("a*")			= 2
	 * StringUtils.count("大小small")	= 9
	 * </pre>
	 * 
	 * @param str
	 *            the String to check,may be null
	 * @return the number of String.
	 */
	public static int count(String str) {
		int length = 0;
		str = str.trim();
		if (isEmpty(str)) {
			return length;
		}
		char[] temp = str.toCharArray();
		for (char t : temp) {
			if (String.valueOf(t).matches("^[\\u4e00-\\u9fa5]*$")) {
				length += 2;
			} else if (String.valueOf(t).matches("^\\S*$")) {
				length += 1;
			}
		}
		return length;
	}

	/**
	 * 将一个网页编码转化为unicode符号，比如"&#8212;转为—
	 * 
	 * @param dataStr
	 * @return
	 */
	public static String decodeUnicode(final String dataStr) {
		int start = 0;
		int end = 0;
		final StringBuffer buffer = new StringBuffer();
		while (start > -1) {
			int system = 10;// 进制
			if (start == 0) {
				int t = dataStr.indexOf("&#");
				if (t < 0) {
					return dataStr;
				}
				buffer.append(dataStr.subSequence(0, t));
				if (start != t)
					start = t;
			}
			end = dataStr.indexOf(";", start + 2);
			String charStr = "";
			if (end != -1) {
				charStr = dataStr.substring(start + 2, end);

				// 判断进制
				char s = charStr.charAt(0);
				if (s == 'x' || s == 'X') {
					system = 16;
					charStr = charStr.substring(1);
				}
			}
			// 转换
			try {
				char letter = (char) Integer.parseInt(charStr, system);
				buffer.append(new Character(letter).toString());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			}

			// 处理当前unicode字符到下一个unicode字符之间的非unicode字符
			start = dataStr.indexOf("&#", end);
			if (start - end > 1) {
				buffer.append(dataStr.substring(end + 1, start));
			}

			// 处理最后面的非unicode字符
			if (start == -1) {
				int length = dataStr.length();
				if (end + 1 != length) {
					buffer.append(dataStr.substring(end + 1, length));
				}
			}
		}
		return buffer.toString();
	}

	public static String getSubString(String input, int keepCount /*
																 * 英文算0.5个,汉字算一个
																 */, String tail) {
		if (input == null || input.length() == 0) {
			return input;
		}
		StringBuilder builder = new StringBuilder(keepCount);
		double selectCount = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			builder.append(c);
			if (isChineseChar(c)) {
				selectCount += 1;
			} else {
				selectCount += 0.5;
			}
			if (selectCount >= keepCount) {
				builder.append(tail);
				break;
			}
		}
		return builder.toString();
	}

	private static boolean isChineseChar(char ch) {
		int v = (int) ch;
		if (v >= 19968 && v <= 171941) {
			return true;
		} else {
			return false;
		}
	}
}
