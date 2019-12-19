package com.haoyin.image.util.alipay.core;

import java.io.UnsupportedEncodingException;
import java.security.SignatureException;

import org.apache.commons.codec.digest.DigestUtils;

import com.haoyin.image.util.alipay.AlipayConfig;



/**
 * 功能：支付宝MD5签名处理核心文件<br>
 * 版本：3.1 <br>
 * 修改日期：2010-11-01
 */

public class AlipayMd5Encrypt {

	/**
	 * MD5 signature of the string
	 * 
	 * @param text
	 * @return
	 */
	public static String md5(String text) {
		return DigestUtils.md5Hex(getContentBytes(text, AlipayConfig.INPUT_CHARSET));
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param key
	 *            密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static String sign(String text, String key, String input_charset) {
		text = text + key;
		return DigestUtils.md5Hex(getContentBytes(text, input_charset));
	}

	/**
	 * 签名字符串
	 * 
	 * @param text
	 *            需要签名的字符串
	 * @param sign
	 *            签名结果
	 * @param key
	 *            密钥
	 * @param input_charset
	 *            编码格式
	 * @return 签名结果
	 */
	public static boolean verify(String text, String sign, String key, String input_charset) {
		text = text + key;
		String mysign = DigestUtils.md5Hex(getContentBytes(text, input_charset));
		if (mysign.equals(sign)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @param content
	 * @param charset
	 * @return
	 * @throws SignatureException
	 * @throws UnsupportedEncodingException
	 */
	private static byte[] getContentBytes(String content, String charset) {
		if (charset == null || "".equals(charset)) {
			return content.getBytes();
		}

		try {
			return content.getBytes(charset);
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(
					"MD5 signature process error in the encoding specified set wrong, you are currently specified encoding set:"
							+ charset);
		}
	}

}