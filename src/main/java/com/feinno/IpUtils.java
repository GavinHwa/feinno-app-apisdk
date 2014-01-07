/*
 * Fetion Open Platform
 *  
 * Create by 国兴旺 2011-8-17
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IpUtils
 * 
 * @author XJeffg
 */
public class IpUtils {

	public static String ipLongToString(long ipaddr) {
		StringBuffer sb = new StringBuffer("");
		sb.append(String.valueOf((ipaddr >>> 24)));
		sb.append(".");
		sb.append(String.valueOf((ipaddr & 0x00FFFFFF) >>> 16));
		sb.append(".");
		sb.append(String.valueOf((ipaddr & 0x0000FFFF) >>> 8));
		sb.append(".");
		sb.append(String.valueOf((ipaddr & 0x000000FF)));
		return sb.toString();
	}

	public static long ipStringToLong(String ipaddr) throws Exception {
		if (!Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}")
				.matcher(ipaddr).find()) {
			return 0;
		}
		long[] ip = new long[4];
		int pos1 = ipaddr.indexOf(".");
		int pos2 = ipaddr.indexOf(".", pos1 + 1);
		int pos3 = ipaddr.indexOf(".", pos2 + 1);
		ip[0] = Long.parseLong(ipaddr.substring(0, pos1));
		ip[1] = Long.parseLong(ipaddr.substring(pos1 + 1, pos2));
		ip[2] = Long.parseLong(ipaddr.substring(pos2 + 1, pos3));
		ip[3] = Long.parseLong(ipaddr.substring(pos3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	public static boolean isValidIp(String ipAddress) {
		String ip = "([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		Pattern pattern = Pattern.compile(ip);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}
}
