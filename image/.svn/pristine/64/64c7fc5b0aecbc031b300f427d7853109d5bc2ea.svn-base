/**
 * 
 */
package com.haoyin.image.util.alipay;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;

/**
 * 支付宝配置
 * 
 * @author Summer.xia
 */
public class AlipayConfigHelper {

	private static final String CONFIG_PATH = "alipay.properties";

	private final static AlipayConfigHelper instance = new AlipayConfigHelper(CONFIG_PATH);

	private Configuration config;

	AlipayConfigHelper(String fileName){
		Configurations configs = new Configurations();
        FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
        try {
        	config = configs.properties(this.getClass().getClassLoader().getResource(fileName));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	static AlipayConfigHelper getInstance() {
		return instance;
	}

	String getString(String infoLabel) {
		return instance.config.getString(infoLabel);
	}

}
