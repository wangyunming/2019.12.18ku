package com.haoyin.image.security;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {

	private static final String PASSWORD_RETRY_CACHE = "passwordRetryCache";
	@Autowired
	private CacheManager cacheManager;

	@Override
	public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		String username = (String) authcToken.getPrincipal();
//		 String password = String.valueOf(token.getPassword());
//		 String salt = ((SimpleAuthenticationInfo) info).getCredentialsSalt();

		// retry count + 1
		Cache<String, Object> passwordRetryCache = cacheManager.getCache(PASSWORD_RETRY_CACHE);
		Object value = passwordRetryCache.get(username);
		if (value == null) {
			value = new AtomicInteger(0);
			passwordRetryCache.put(username, value);
		}
		AtomicInteger retryCount = (AtomicInteger) value;
		if (retryCount.incrementAndGet() > Integer.MAX_VALUE - 1) {
			// if retry count > 5 throwpassword
			throw new ExcessiveAttemptsException();
		}
		boolean matches = super.doCredentialsMatch(token, info);

		// 自定义密码 Matcher
		// boolean matches = this.getPasswordService().passwordsMatch(password, (String) info.getCredentials());
		// if (matches) {
		// // clear retry count
		// passwordRetryCache.remove(username);
		// }

		return matches;
	}

	/**
	 * Returns true if stored credential hash is Hex encoded, false if it is Base64 encoded.
	 * 
	 * @return
	 */
	public boolean getStoredCredentialsHexEncoded() {
		return isStoredCredentialsHexEncoded();
	}

	/**
	 * @param cacheManager
	 *            the {@link #cacheManager} to set
	 */
	public void setCacheManager(CacheManager cacheManager) {
		this.cacheManager = cacheManager;
	}

}
