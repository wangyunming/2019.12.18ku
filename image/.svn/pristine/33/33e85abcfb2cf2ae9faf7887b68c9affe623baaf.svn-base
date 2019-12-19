package com.haoyin.image.config;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.haoyin.image.realm.ShiroRealm;
import com.haoyin.image.security.RetryLimitHashedCredentialsMatcher;



@Configuration
public class ShiroConfig {
		@Bean
		public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager){
			ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
			shiroFilterFactoryBean.setSecurityManager(securityManager);
			//默认/login
			shiroFilterFactoryBean.setLoginUrl("/login.html");
			shiroFilterFactoryBean.setSuccessUrl("/fileList.html");
			shiroFilterFactoryBean.setUnauthorizedUrl("/");
			Map<String, String> map=new LinkedHashMap<String,String>();
			map.put("/favicon.ico", "anon");
			map.put("/static/**", "anon");
			map.put("/admin/*", "roles[admin]");
			map.put("/img/favicon.ico", "anon");
			map.put("/guest/**", "anon");
			map.put("/layout/site-nav.ftl", "anon");
			map.put("/login.html", "anon");
			map.put("/auth/login", "anon");
			map.put("/pay/notify.html", "anon");
			map.put("/yeePay/notify.html", "anon");
			map.put("/async-notify/alipay-notify.html", "anon");
			map.put("/**", "user");
			shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
			System.out.println("Shiro拦截器工厂类注入成功");
			return shiroFilterFactoryBean;
		}
		@Bean
		public EhCacheManager cacheManagers(){
			EhCacheManager ehCacheManager= new EhCacheManager();
			ehCacheManager.setCacheManagerConfigFile("classpath:ehcache.xml");
			return ehCacheManager;
		}
		@Bean
		public SecurityManager securityManager(ShiroRealm customRealm){
			DefaultWebSecurityManager securityManager=new DefaultWebSecurityManager();
			securityManager.setRealm(customRealm);
			return securityManager;
		}
		@Bean
		public RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher(){
			RetryLimitHashedCredentialsMatcher retryLimitHashedCredentialsMatcher =new RetryLimitHashedCredentialsMatcher();
			retryLimitHashedCredentialsMatcher.setCacheManager(cacheManagers());
			retryLimitHashedCredentialsMatcher.setHashAlgorithmName("SHA-256");
			retryLimitHashedCredentialsMatcher.setHashIterations(2);
			retryLimitHashedCredentialsMatcher.setStoredCredentialsHexEncoded(true);
			return retryLimitHashedCredentialsMatcher;
		}
		@Bean
		public ShiroRealm shiroRealm(HashedCredentialsMatcher retryLimitHashedCredentialsMatcher){
			ShiroRealm shiroRealm=new ShiroRealm();
			shiroRealm.setAuthorizationCachingEnabled(false);
			shiroRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher);
			return shiroRealm;
		}
		@Bean
		public LifecycleBeanPostProcessor lifecycleBeanPostProcessor(){
			return new LifecycleBeanPostProcessor();
		}
}
