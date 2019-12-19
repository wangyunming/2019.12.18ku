package com.haoyin.image.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.haoyin.image.intercepter.WebSiteMeshFilter;




@Configuration
public class WebConfig implements WebMvcConfigurer{

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean meshSiteBean(){
		FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
		WebSiteMeshFilter webSiteMeshFilter=new WebSiteMeshFilter();
		filterRegistrationBean.setFilter(webSiteMeshFilter);
		return filterRegistrationBean;
	}
		
}
