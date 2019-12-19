package com.haoyin.image.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.haoyin.image.intercepter.CommonInterceptor;



@Configuration
public class CommonInterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {	
		registry.addInterceptor(new CommonInterceptor()).addPathPatterns("/**");
	}

	
	
}
