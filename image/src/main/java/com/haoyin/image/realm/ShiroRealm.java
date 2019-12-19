package com.haoyin.image.realm;


import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.haoyin.image.entity.User;
import com.haoyin.image.service.UserAuthorizationService;
import com.haoyin.image.service.UserService;



/**
 * @author Summer
 *
 * @date 2016年3月5日
 */
public class ShiroRealm extends AuthorizingRealm {

	private static Logger log = LoggerFactory.getLogger(ShiroRealm.class);
	@Autowired
	private UserService userService;
	@Autowired
	private UserAuthorizationService userAuthorizationService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String username = (String) principals.getPrimaryPrincipal();

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		authorizationInfo.addRoles(userAuthorizationService.queryUserRoleList(username));
		authorizationInfo.addStringPermissions(userAuthorizationService.queryUserPermissionList(username));

		return authorizationInfo;
	}

	/**
	 * 验证当前登录
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		if (StringUtils.isEmpty(token.getUsername())) {
			log.debug("current token's username is null.");
			throw new AuthenticationException();
		}
		log.debug("current token is : {}", token.getUsername());

		User user = userService.queryUser(token.getUsername());
		//账户不存在
		if (user == null) {
			throw new UnknownAccountException();
		}
		if (Boolean.TRUE.equals(user.isLocked())) {
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), getName());
		ByteSource salt = ByteSource.Util.bytes(user.getSalt());
		authenticationInfo.setCredentialsSalt(salt);
		
		SecurityUtils.getSubject().getSession(true).setAttribute("uid", user.getUserId());

		return authenticationInfo;
	}

	/**
	 * Clear all authorization cache
	 */
	public void clearAllCachedAuthorizationInfo() {
		getAuthorizationCache().clear();
	}

	/**
	 * Clear all authentication cache
	 */
	public void clearAllCachedAuthenticationInfo() {
		getAuthenticationCache().clear();
	}

	/**
	 * Clear all authorization and authentication cache
	 */
	public void clearAllCache() {
		clearAllCachedAuthenticationInfo();
		clearAllCachedAuthorizationInfo();
	}

	/**
	 * @param userService
	 *            the {@link #userService} to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	/**
	 * @param userAuthorizationService
	 *            the {@link #userAuthorizationService} to set
	 */
	public void setUserAuthorizationService(UserAuthorizationService userAuthorizationService) {
		this.userAuthorizationService = userAuthorizationService;
	}

}
