package com.haoyin.image.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

@Configuration
public class FreemarkerConfig {
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(){
		FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
		Map<String, Object> map=new HashMap<>();
		map.put("p", new PageAuthorization());
		configurer.setFreemarkerVariables(map);
		configurer.setTemplateLoaderPath("classpath:/templates");
		return  configurer;
	}
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	
	@Bean
	public RestTemplate restTemplate(){
		return restTemplateBuilder.build();
	}
}
