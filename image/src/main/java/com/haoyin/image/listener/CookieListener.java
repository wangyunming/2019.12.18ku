package com.haoyin.image.listener;

import java.io.InputStream;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.haoyin.cookie.CookieManager;

@WebListener
public class CookieListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		try {
			InputStream in = loadConfig("cookie-config.xml");
			CookieManager.loadCookieConfig(in);
			event.getServletContext().log(
					(new StringBuilder()).append("parse cookie-config.xml finished.\n")
							.append(CookieManager.getCookieConfig()).toString());
		} catch (Exception e) {
			event.getServletContext().log(
					(new StringBuilder()).append("parse cookie-config.xml error, message: ").append(e.getMessage())
							.toString());
		}
		
	}

	
	
	private InputStream loadConfig(String resource) {
		return Thread.currentThread().getContextClassLoader().getResourceAsStream(resource);
	}
	
	
}
