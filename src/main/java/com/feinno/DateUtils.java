/*
 * Fetion Open Platform
 *  
 * Create by GavinHwa 2011-5-9
 * 
 * Copyright (c) 2011 北京新媒传信科技有限公司
 */
package com.feinno;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtils
 * 
 * @author GavinHwa
 */
public class DateUtils {
	/**
	 * 
	 * {获取当前时间并转换成如2011-03-16 12:12:12.586字符串}
	 * 
	 * @return
	 */
	public final static String date2String() {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.util.Date timeDate = calendar.getTime();
		return dateFormat.format(timeDate);
	}
	
	public static String date2String(String format) {
		Calendar calendar = Calendar.getInstance();
		DateFormat dateFormat = new SimpleDateFormat(format, Locale.ENGLISH);
		dateFormat.setLenient(false);
		java.util.Date timeDate = calendar.getTime();
		return dateFormat.format(timeDate);
	}

	public static long date2Long(String date, String format) throws ParseException {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new SimpleDateFormat(format, Locale.ENGLISH).parse(date));
		return calendar.getTimeInMillis();
	}

	/**
	 * 
	 * {将java.sql.Date转换成如2011-03-16字符串}
	 * 
	 * @param date
	 * @return 如果date为空，则返回1900-01-01
	 */
	public final static String date2String(java.sql.Date date) {
		if(date == null){
			return "1900-01-01";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		return dateFormat.format(date);
	}


	/**
	 * 
	 * {将Timestamp转换成如2011-03-16 12:12:12字符串}
	 * 
	 * @param timestamp
	 * @return
	 */
	public final static String timestamp2String(java.sql.Timestamp timestamp) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		return dateFormat.format(timestamp);
	}

	/**
	 * 
	 * {将字符串类型的日期转换成一个Date(java.sql.Date}
	 * 
	 * @param dateString
	 * @return
	 */
	public final static java.sql.Date string2Date(String dateString) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
					Locale.ENGLISH);
			// dateFormat.setLenient(false); //严格解析
			java.util.Date timeDate = dateFormat.parse(dateString);
			java.sql.Date dateTime = new java.sql.Date(timeDate.getTime());
			return dateTime;
		} catch (java.lang.Exception e) {
			return string2Date("1970-01-01");
		}
	}
	/**
	 * 
	 * {将long的日期转换成一个Date(java.sql.Date}
	 * @author shangrenpeng
	 * @param timemilis
	 * @return
	 */
	public final static java.sql.Date long2Date(long timemilis) {
		try {
			java.sql.Date dateTime = new java.sql.Date(timemilis);
			return dateTime;
		} catch (java.lang.Exception e) {
			return string2Date("1970-01-01");
		}
	}
	
	/**
	 * 
	 * {将long的日期转换成一个String
	 * @author shangrenpeng
	 * @param timemilis
	 * @return
	 */
	public final static String long2String(long timemilis) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",
					Locale.ENGLISH);
			dateFormat.setLenient(false);
			java.sql.Date date = new java.sql.Date(timemilis);
			dateFormat.setLenient(false);
			return dateFormat.format(date);
		} catch (Exception e) {
			return "1970-01-01 00:00:00";
		}
		
	}

	/**
	 * 
	 * {将字符串类型的日期转换成一个timestamp(java.sql.Timestamp)}
	 * 
	 * @param dateString
	 * @return
	 */
	public final static java.sql.Timestamp string2Timestamp(String dateString) {
		try {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd H:mm:ss",
					Locale.ENGLISH);
			dateFormat.setLenient(false);
			java.util.Date timeDate = dateFormat.parse(dateString);
			java.sql.Timestamp dateTimestamp = new java.sql.Timestamp(
					timeDate.getTime());
			return dateTimestamp;
		} catch (java.text.ParseException e) {
			return string2Timestamp("1970-01-01 00:00:00");
		}
	}
	
	/**
	 * 
	 * {将java.util.Date转换成如2012-06-13字符串}
	 * 
	 * @param date
	 * @return 如果date为空，则返回1900-01-01
	 */
	public final static String date2String(java.util.Date date) {
		if(date == null){
			return "1900-01-01";
		}
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd",
				Locale.ENGLISH);
		dateFormat.setLenient(false);
		return dateFormat.format(date);
	}
	
	/**
	 * 尝试将字符串转为长整数。如果不能解析，返回0
	 * 
	 * @param time
	 * @return
	 */
	public final static long tryParseDate2Long(String time){
		long timeStamp = 0;
		if (time == null){
			return 0;
		}
		try{
			timeStamp = Long.parseLong(time);
		}catch (Exception e) {
			try{
				timeStamp = getTime(time);
			}catch (Exception e1) {
				try{
					timeStamp = getTimeFromPure(time);
				}catch (Exception e2) {
					try {
						timeStamp = getTimeNoSpace(time);
					} catch (Exception e3) {
						try {
							timeStamp = getDateTime(time);
						} catch (Exception e4) {
							try {
								timeStamp = getPCOnlineTime(time);
							} catch (Exception e5) {
							}
						}
					}
					
				}
				
			}
		}
		
		return timeStamp;
	}
	
	
	private final static long getTime(String GMTtime) throws ParseException {// 将格林威治时间转化成时间戳

		SimpleDateFormat insdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

		Date date = insdf.parse(GMTtime);
		long newTime = date.getTime() / 1000;

		return newTime;
	}
	
	private final static long getTimeNoSpace(String GMTtime) throws ParseException {// 将格林威治时间转化成时间戳

		SimpleDateFormat insdf = new SimpleDateFormat("EEE,dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

		Date date = insdf.parse(GMTtime);
		long newTime = date.getTime() / 1000;

		return newTime;
	}
	
//	private final static long getBaiduTime(String GMTtime) throws ParseException {// 百度的时间里有问题。
//
//		SimpleDateFormat insdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
//
//		Date date = insdf.parse(GMTtime);
//		long newTime = date.getTime() / 1000;
//
//		return newTime;
//	}
	
	public final static long getTimeFromPure(String GMTtime) throws ParseException {// 将时间转化成本地时间，并做一个时间戳

		SimpleDateFormat insdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date date = insdf.parse(GMTtime);
		long newTime = date.getTime() / 1000;

		return newTime;
	}
	
	private final static long getDateTime(String GMTtime) throws ParseException {// 给的时间居然只精确到天。。。去屎吧！

		SimpleDateFormat insdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss", Locale.ENGLISH);

		Date date = insdf.parse(GMTtime);
		long newTime = date.getTime() / 1000;

		return newTime;
	}
	
	private final static long getPCOnlineTime(String GMTtime) throws ParseException {// 给的时间居然只精确到天。。。去屎吧！

		SimpleDateFormat insdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.CHINESE);

		Date date = insdf.parse(GMTtime);
		long newTime = date.getTime() / 1000;

		return newTime;
	}
	
	public static void main(String[] args) throws ParseException {
		System.out.println(tryParseDate2Long("星期四, 6 十二月 2012 11:57:10 +0800"));
		System.out.println(long2String(tryParseDate2Long("星期四, 6 十二月 2012 11:57:10 +0800") * 1000));
	}
}
