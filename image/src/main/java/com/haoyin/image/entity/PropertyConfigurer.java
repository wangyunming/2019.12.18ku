package com.haoyin.image.entity;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import java.util.Properties;

/**
 * 属性配置工具
 * 
 * @author Summer
 *
 *         2016年6月1日
 */
public class PropertyConfigurer extends PropertyPlaceholderConfigurer {

	private Properties props;

	@Override
	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		this.props = props;
	}

	/**
	 * Get value of string
	 * 
	 * @param key
	 * @return
	 */
	public String getString(String key) {
		return props.getProperty(key);
	}

	/**
	 * Get value of boolean
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBoolean(String key) {
		return "true".equalsIgnoreCase(getString(key));
	}

	/**
	 * Get value of number
	 * 
	 * @param key
	 * @return
	 */
	public int getInt(String key, int defValue) {
		try {
			String value = getString(key);
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			return defValue;
		}
	}

	public String getProperty(String key, String defaultValue) {
		return props.getProperty(key, defaultValue);
	}

}
