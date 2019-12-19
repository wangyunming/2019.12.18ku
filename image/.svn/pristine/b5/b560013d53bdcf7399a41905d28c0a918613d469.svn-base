package com.haoyin.image.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;


/**
 * 日期、时间工具类
 * 
 * @author summer
 * 
 */
public class DateUtils {
	
	/** 字符串转换为日期格式 format默认为yyyy-MM-dd */
	public static String formatDate(Date date, String format) {
		if (date == null)
			return null;
		if (StringUtils.isEmpty(format))
			format = "yyyy-MM-dd";
		return new SimpleDateFormat(format).format(date);
	}

	/**
	 * 从给定字符串的开始解析文本，以生成一个日期
	 * 
	 * @param pattern
	 * @param strDateTime
	 * @return
	 */
	public static Date parse(String pattern, String strDateTime) {
		java.util.Date date = null;
		if (strDateTime == null || pattern == null) {
			return null;
		}
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			formatter.setLenient(false);
			date = formatter.parse(strDateTime);
		} catch (ParseException e) {
			return null;
		}
		return date;
	}

	/**
	 * 前<code> before </code>个月的今天
	 * 
	 * @param before
	 * @return
	 */
	public static Date beforeMonthAsToday(int before) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - before);
		return calendar.getTime();
	}

	/**
	 * 当月的第一天的 0点0时
	 * 
	 * @return
	 */
	public static Date firstDayOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		return calendar.getTime();
	}

	/**
	 * 当月的最后一天的最后一秒
	 * 
	 * @return
	 */
	public static Date lastTimeOfMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		calendar.roll(Calendar.DATE, -1);
		return calendar.getTime();
	}

	/**
	 * <p>
	 * 获取两个时间之间的时间差
	 * </p>
	 * <p>
	 * <code>
	 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");<br>
	 * Map<String, Integer> map = DateUtil.getDifferUnitTime(sdf.parse("2013-04-21 15:07:50"), sdf.parse("2016-04-19 17:25:09"));<br>
	 * int years = map.get("YEAR");<br>
	 * int months = map.get("MONTH");<br>
	 * int daysOfYear = map.get("DAY_OF_YEAR");<br>
	 * int hoursOfDay = map.get("HOUR_OF_DAY");<br>
	 * int minutes = map.get("MINUTE");<br>
	 * int seconds = map.get("SECOND");
	 * </code>
	 * </p>
	 * 
	 * @param sdate
	 * @param edate
	 * @return
	 */
	public static Map<String, Integer> getDifferUnitTime(Date sdate, Date edate) {
		Calendar calendar = Calendar.getInstance();
		long st = sdate.getTime();
		long et = edate.getTime();
		calendar.setTimeInMillis(Math.abs(et - st));

		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("YEAR", calendar.get(Calendar.YEAR) - 1970);
		map.put("MONTH", calendar.get(Calendar.MONTH));
		map.put("DAY_OF_YEAR", calendar.get(Calendar.DAY_OF_YEAR) - 1);
		map.put("HOUR_OF_DAY", calendar.get(Calendar.HOUR_OF_DAY) - 8);
		map.put("MINUTE", calendar.get(Calendar.MINUTE));
		map.put("SECOND", calendar.get(Calendar.SECOND));

		return map;
	}

	
	/**
	 * 
	 * @Description: 字符串转换成日期 
	 * @param str
	 * @return Date
	 */
	public Date StrToDate(String str) { 
	  
	   SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	   Date date = null; 
	   try { 
		date = format.parse(str); 
	   } catch (Exception e) { 
		e.printStackTrace(); 
	   } 
	   return date; 
	}
	
	/**
	 * 
	 * @Description: 日期转字符串 
	 * @param date
	 * @return String
	 */
	public String DateToStr(Date date) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String str = format.format(date);
		return str;
	}
	
	/**
	 * 
	 * @Description: 日期+天数计算方法 
	 * @param date
	 * @param days
	 * @return
	 */
	public String canlandarAddDate(Date date, int days){
		Calendar calendar = Calendar.getInstance();//创建一个实例
		calendar.setTime(date);
		calendar.add(Calendar.DATE,days);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(calendar.getTime());
	}
	
	/**
	 * 
	 * @Description: 日期 获取日期所在月份最后一天 
	 * @param date
	 * @return
	 */
	public Date getLastDayOfThisMonth(Date date){
		Calendar calendar = Calendar.getInstance();//创建一个实例
		calendar.setTime(date);
		calendar.set(Calendar.DATE,1);
		calendar.add(Calendar.MONTH,1);
		calendar.add(Calendar.DATE,-1);
		return calendar.getTime();
	}
	
	
	/**
	 * 
	 * @Description: 获取发送超时短信的时间节点
	 * @param date
	 * @return
	 */
	public Date messageTimeOutDate(){
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.HOUR_OF_DAY,-1);
		return calendar.getTime();
	}
}
