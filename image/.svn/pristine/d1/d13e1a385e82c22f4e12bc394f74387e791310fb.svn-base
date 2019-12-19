package com.haoyin.image.security;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.haoyin.image.entity.UserProfile;





/**
 * @author Summer
 *
 *         2016年6月8日
 */
public class AuthenticationUser {

	public static final String USER_SESSION_NAME = "csp";

	public static final String USER_ID_SESSION_NAME = "csp_uid";

	/**
	 * 获取登录用户 ID
	 * 
	 * @return
	 */
	public static long getUserId() {
		Subject subject = SecurityUtils.getSubject();
		if (!subject.isAuthenticated()) {
			return 0;
		}

		return (long) subject.getSession(false).getAttribute(USER_ID_SESSION_NAME);
	}

	/**
	 * 获取登录用户 username
	 * 
	 * @return
	 */
	public static String getUsername() {
		UserProfile profile = getUserProfile();

		if (null == profile) {
			return null;
		}
		return profile.getUsername();
	}

	/**
	 * 获取登录用户资料
	 * 
	 * @return
	 */
	public static UserProfile getUserProfile() {
		Subject subject = SecurityUtils.getSubject();

		return (UserProfile) subject.getSession().getAttribute(USER_SESSION_NAME);
	}
	
	/**
	 * 获取登录用户资料
	 * 
	 * @return
	 */
	public static void setUserProfile(UserProfile profile) {
		Subject subject = SecurityUtils.getSubject();

		subject.getSession(false).setAttribute(USER_SESSION_NAME, profile);
	}

}
