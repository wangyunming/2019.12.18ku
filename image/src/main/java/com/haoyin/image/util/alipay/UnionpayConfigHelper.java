package com.haoyin.image.util.alipay;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Configurations;
import org.apache.commons.configuration2.ex.ConfigurationException;


public class UnionpayConfigHelper {
	private static final String CONFIG_PATH = "unionpay.properties";

	private final static UnionpayConfigHelper instance = new UnionpayConfigHelper(CONFIG_PATH);

	private Configuration config;

	UnionpayConfigHelper(String fileName) {
		Configurations configs = new Configurations();
        FileBasedConfigurationBuilder.setDefaultEncoding(PropertiesConfiguration.class, "UTF-8");
        try {
        	config = configs.properties(this.getClass().getClassLoader().getResource(fileName));
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

	static UnionpayConfigHelper getInstance() {
		return instance;
	}

	String getString(String infoLabel) {
		return instance.config.getString(infoLabel);
	}
}
