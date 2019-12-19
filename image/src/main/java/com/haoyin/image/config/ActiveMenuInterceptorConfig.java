package com.haoyin.image.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.haoyin.image.intercepter.ActiveMenuInterceptor;
import com.haoyin.image.intercepter.UserSessionInterceptor;





@Configuration
public class ActiveMenuInterceptorConfig implements WebMvcConfigurer{
	
	@Bean
	public ActiveMenuInterceptor activeMenuInterceptor(){
		return new ActiveMenuInterceptor();
	}
	
	@Bean
	public UserSessionInterceptor userSessionInterceptor(){
		return new UserSessionInterceptor();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(activeMenuInterceptor()).addPathPatterns("/*.html","/**/*.html");
		registry.addInterceptor(userSessionInterceptor()).addPathPatterns("/**.html","/**/**.html");
	}
}
 
