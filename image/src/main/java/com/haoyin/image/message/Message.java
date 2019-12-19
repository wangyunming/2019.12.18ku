package com.haoyin.image.message;

import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * 消息
 * </p>
 */
public class Message {

	private final static Logger log = LoggerFactory.getLogger(Message.class);

	/**
	 * 资源文件名称
	 */
	private final static String MESSAGE_PROPERTY_FILENAME = "message.properties";
	private static Properties properties;

	static {
		try {
			loadMessage();
		} catch (IOException e) {
			throw new IllegalStateException(new StringBuilder("load message resource ").append(MESSAGE_PROPERTY_FILENAME).append(" error").toString(), e);
		}
	}

	/**
	 * <p>
	 * 通过 {@link MessageName} 中的键名字获取资源文字。
	 * </p>
	 * 
	 * @param name
	 *            资源的名字
	 * @param args
	 *            资源需要填充的参数，用于填充 {0}、{1} 之类的占位符
	 * @return
	 * 
	 */
	public static String getMessage(String name, Object... args) {
		String message = properties.getProperty(name);
		if (args == null || args.length == 0) {
			return message;
		}
		return MessageFormat.format(message, args);
	}

	private static void loadMessage() throws IOException {
		if (properties != null) {
			return;
		}
		properties = new Properties();
		properties.load(getInputStream());
	}

	/**
	 * <p>
	 * 加载资源文件
	 * </p>
	 * 
	 * @return
	 * 
	 */
	private static InputStream getInputStream() {

		// 从当前类加载器中加载资源
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(MESSAGE_PROPERTY_FILENAME);
		if (is != null) {
			log.info("load message file {} from current thread class loader context", MESSAGE_PROPERTY_FILENAME);
			return is;
		}
		log.info("cannot load message file {} from current thread class loader context", MESSAGE_PROPERTY_FILENAME);

		// 从系统类加载器中加载资源
		is = ClassLoader.getSystemResourceAsStream(MESSAGE_PROPERTY_FILENAME);
		if (is != null) {
			log.info("load message file {} from system class loader context", MESSAGE_PROPERTY_FILENAME);
			return is;
		}
		throw new IllegalStateException(new StringBuilder("cannot find ").append(MESSAGE_PROPERTY_FILENAME).append(" anywhere").toString());
	}

}
