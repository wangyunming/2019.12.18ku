package com.haoyin.image.config;


import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.haoyin.image.entity.Menu;





/**
 * @author Summer
 *
 *         2016年3月8日
 */
public class PageAuthorization implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	private static final String SYS_ADMIN = "admin";

	public PageAuthorization() {
	}

	/**
	 * verify whether the current user has the specified role
	 * 
	 * @return
	 */
	public boolean hasRole(String role) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.hasRole(SYS_ADMIN)) {
			return true;
		}

		return SecurityUtils.getSubject().hasRole(role);
	}

	/**
	 * verify whether the current user has the specified permission
	 * 
	 * @return
	 */
	public boolean hasPermission(String permission) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.hasRole(SYS_ADMIN)) {
			return true;
		}

		return SecurityUtils.getSubject().isPermitted(permission);
	}
	
	/**
	 * verify whether the current user has the specified permission
	 * 
	 * @return
	 */
	public boolean hasPermissions(List<Menu> menuList) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.hasRole(SYS_ADMIN)) {
			return true;
		}
		if (CollectionUtils.isEmpty(menuList)) {
			return false;
		}
		List<String> perms = new ArrayList<String>();
		for (Menu menu : menuList) {
			perms.add(menu.getTarget() + ":access");
		}
		boolean result = subject.isPermittedAll(perms.toArray(new String[0]));
		
		return result;
	}

	public boolean containsPermission(List<Menu> menuList) {
		Subject subject = SecurityUtils.getSubject();
		
		if (subject.hasRole(SYS_ADMIN)) {
			return true;
		}
		if (CollectionUtils.isEmpty(menuList)) {
			return false;
		}
		
		boolean result = false;
		for (Menu menu : menuList) {
			if (subject.isPermitted(menu.getTarget() + ":access") == true) {
				result = true;
			}
		}
		
		return result;
	}
}
