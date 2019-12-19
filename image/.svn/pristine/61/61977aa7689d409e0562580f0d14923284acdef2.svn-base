package com.haoyin.image.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.haoyin.image.message.MessageName;




/**
 * @author Summer
 *
 * @date 2016年3月5日
 */
@Controller
public class LogoutController implements MessageName {

	private static final long serialVersionUID = 1L;

	/**
	 * User logout and redirect to index
	 */
	@RequestMapping("/auth/logout")
	public String logout(HttpServletRequest request) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.isAuthenticated()) {
			subject.logout();
		}

		subject.logout();

		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/";
	}

}
