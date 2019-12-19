package com.haoyin.image.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.security.AuthenticationUser;
import com.haoyin.image.service.UserProfileService;








/**
 * Prevent refresh interceptor
 * 
 * @author Summer
 *
 */
public class UserSessionInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private UserProfileService userProfileService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		setUserProfile();

		if (!(handler instanceof HandlerMethod)) {
			return super.preHandle(request, response, handler);
		}
		return true;
	}

	public void setUserProfile() {
		Subject subject = SecurityUtils.getSubject();
		Session session = subject.getSession();
		UserProfile profile = (UserProfile) session.getAttribute(AuthenticationUser.USER_SESSION_NAME);
		
		if (null == profile) {
			String username = (String) subject.getPrincipal();
			if (null == username) {
				return;
			}
			
			profile = userProfileService.queryUserProfile(username);

			session.setAttribute(AuthenticationUser.USER_SESSION_NAME, profile);
			session.setAttribute(AuthenticationUser.USER_ID_SESSION_NAME, profile.getId());
		}

	}

}