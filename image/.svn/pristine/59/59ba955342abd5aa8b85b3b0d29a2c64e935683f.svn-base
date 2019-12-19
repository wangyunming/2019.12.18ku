package com.haoyin.image.util;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;








/**
 * 唯一编号生成器
 * 
 * @author Summer
 * 
 */
public class GUIDUtil {

	public static SimpleDateFormat YMDF = new SimpleDateFormat("yyMMdd");
	private static String[] array = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
	private static Random random = new SecureRandom();

	/**
	 * 生成唯一ID
	 * 
	 * @param target
	 *            - 首字母
	 * @return
	 */
	public static synchronized String GUID(String identifier) {
		if (null == identifier) {
			identifier = "";
		}
		identifier = identifier.toUpperCase();
		Date date = Calendar.getInstance().getTime();

		String prefix = YMDF.format(date);
		return new StringBuilder(identifier).append(prefix).append("-").append(generateRandon(6)).toString();
	}
	
	/**
	 * 生成唯一ID
	 * 
	 * @return
	 */
	public static synchronized String GUOID() {
		Date date = Calendar.getInstance().getTime();

		String prefix = YMDF.format(date);
		return new StringBuilder().append(prefix).append("-").append(generateRandon(6)).toString();
	}
	
	/**
	 * 生成14位唯一ID
	 * 
	 * @param length
	 * @return
	 */
	public static synchronized String GUID() {
		SimpleDateFormat YMDF = new SimpleDateFormat("yyMMddHH");
		return new StringBuilder(YMDF.format(Calendar.getInstance().getTime())).append(generateRandon(6)).toString();
	}

	/**
	 * 生成指定长度的随机数的字符串
	 */
	public static String generateRandon(int length) {
		if (length > 10) {
			return formatRandom(0, length);
		}

		random.setSeed(System.nanoTime());
		for (int i = 10; i > 1; i--) {
			int index = random.nextInt(i);
			String tmp = array[index];
			array[index] = array[i - 1];
			array[i - 1] = tmp;
		}

		int result = 0;
		for (int i = 0; i < length; i++) {
			result = result * 10 + Integer.parseInt(array[i]);
		}

		return formatRandom(result, length);
	}

	/**
	 * 数字转字符，并格式化长度，不够前面补 <code>0</code> 。
	 * 
	 * @param number
	 * @param length
	 * @return
	 */
	public static String formatRandom(Number number, int length) {
		Assert.notNull(number);
		String string = String.valueOf(number);

		if (string.length() == length) {
			return string;
		} else if (string.length() > length) {
			return string.substring(string.length() - length);
		}
		StringBuilder builder = new StringBuilder();
		builder.append("%0").append(length).append("d");
		return new StringBuilder().append(String.format(builder.toString(), number)).toString();
	}

	public static void main(String[] args) {
		System.out.println(generateRandon(8));
	}
}
