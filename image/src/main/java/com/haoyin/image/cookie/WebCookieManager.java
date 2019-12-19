package com.haoyin.image.cookie;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haoyin.cookie.CookieManager;
import com.haoyin.cookie.CookieMapping;
import com.haoyin.cookie.rw.CookieReader;
import com.haoyin.cookie.rw.CookieWriter;


/**
 * <p>
 * Web Cookie 管理器
 * </p>
 * 2011-12-14
 */
public class WebCookieManager {
	
	private final static Logger log = LoggerFactory.getLogger(WebCookieManager.class);

	private final static String COOKIE_MAPPING_KEY = CookieMapping.class.getName() + ".actionContext";

	/**
	 * <p>
	 * 写入新的 Session ID
	 * </p>
	 */
	public static Token writeSessionId() {
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.SG_SESSION);
		Token token = Token.getToken();
		writer.addCookie(CookieName.SG_SESSION_ID, token);
		writer.write(getresponse());
		return token;
	}

	

	/**
	 * <p>
	 * 写入用户登录信息
	 * </p>
	 * 
	 * @param user
	 *            登录用户数据
	 * 
	 */
	/*public static void writeLogin(LoginUserDO user) {
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.LG_LOGIN);
		writer.addCookie(CookieName.LG_LOGIN_NAME, user.getLoginName());
		writer.addCookie(CookieName.LG_LOGIN_LOGINTIME, System.currentTimeMillis() / 1000);
		writer.addCookie(CookieName.LG_LOGIN_USERNAME, user.getUserName());
		writer.addCookie(CookieName.LG_LOGIN_USERID, user.getUserId());
		writer.addCookie(CookieName.LG_LOGIN_USERTYPE, user.getUserType());
		writer.addCookie(CookieName.LG_LOGIN_ORGID, user.getOrgId());
		writer.addCookie(CookieName.LG_LOGIN_USERLEVEL, user.getUserLevel());
		writer.write(getresponse());
	}*/
	public static void updateCart(Integer cartCount){
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.LG_LOGIN);
		writer.addCookie(CookieName.CN_SHOPPING_NUMBER, cartCount);
		writer.write(getresponse());
	}
	/*public static void updateLogin(UserDO user, long lgoinTime) {
		clearLogin();
		CookieWriter writer = CookieManager.newCookieWriter(CookieName.LG_LOGIN);
		writer.addCookie(CookieName.LG_LOGIN_NAME, user.getLoginName());
		writer.addCookie(CookieName.LG_LOGIN_LOGINTIME, lgoinTime);
		writer.addCookie(CookieName.LG_LOGIN_USERNAME, user.getUserName());
		writer.addCookie(CookieName.LG_LOGIN_USERID, user.getId());
		writer.addCookie(CookieName.LG_LOGIN_USERTYPE, user.getUserType().longValue());
		writer.addCookie(CookieName.LG_LOGIN_ORGID, user.getOrgId().longValue());
		writer.write(ServletActionContext.getResponse());
	}
	*/

	/**
	 * <p>
	 * 清除用户登录数据
	 * </p>
	 */
	public static void clearLogin() {
		CookieReader loginReader = CookieManager.newCookieReader(CookieName.LG_LOGIN);
		int n = loginReader.clearGroup(getresponse());
		log.debug("logout clear login cookie count: {}", n);
	}

	/**
	 * <p>
	 * 获取客户端 Cookie Mapping
	 * </p>
	 * 
	 * @return 客户端 Cookie Mapping
	 */
	public static CookieMapping getCookieMapping() {
		CookieMapping mapping = StrutsActionContext.getValue(COOKIE_MAPPING_KEY);
		if (mapping == null) {
			log.debug("cannot find CookieMapping in ActionContext, build it");
			mapping = CookieManager.getCookieMapping(getrequest());
			StrutsActionContext.putValue(mapping, COOKIE_MAPPING_KEY);
		}
		return mapping;
	}

	/*public static boolean hasSessionIdCookie() {
		String sessionId = getCookieMapping().get(CookieName.SG_SESSION_ID);
		if (Tools.isBlank(sessionId)) {
			return false;
		}
		return Token.checkToken(sessionId);
	}*/

	/**
	 * <p>
	 * 清除用户的 Session 数据
	 * </p>
	 */
	/*public static void clearSession() {
		clearGroup(CookieName.SG_SESSION);
	}
*/
	/**
	 * <p>
	 * 获取用户登录数据
	 * </p>
	 * 
	 * @return 用户登录数据
	 */
	/*static LoginInfo getLoginInfo() {
		LoginInfo login = StrutsActionContext.getValue(LoginInfo.ACTION_CONTEXT_KEY);
		if (login != null) {
			return login;
		}
		log.debug("cannot find LoginInfo in ActionContext, build it");
		HttpServletResponse response = ServletActionContext.getResponse();

		// 创建 session cookie 组数据读取器
		CookieReader sessionReader = CookieManager.newCookieReader(CookieName.SG_SESSION);

		// 创建 login cookie 组数据读取器
		CookieReader loginReader = CookieManager.newCookieReader(CookieName.LG_LOGIN);

		// 获取客户端 cookie Mapping
		CookieMapping mapping = getCookieMapping();

		// session cookie 组读取失败时
		// 不再清空 session group 和 login group 数据
		if (!sessionReader.readCookies(mapping, response)) {
			log.debug("read session group cookie data failed, need to re-login");
			return new LoginInfo();
		}

		// login cookie 组数据读取失败时
		// 不再清空 login group 数据
		if (!loginReader.readCookies(mapping, response)) {
			log.debug("read login group cookie data failed, need to re-login");
			return new LoginInfo();
		}

		// 创建用户登录数据对象
		login = new LoginInfo(sessionReader, loginReader);
		StrutsActionContext.putValue(login, LoginInfo.ACTION_CONTEXT_KEY);
		return login;
	}
	*/
	/**
	 * <p>
	 * 获取美乐家用户登录数据
	 * </p>
	 * 
	 * @return 用户登录数据
	 */
	/*static LoginInfo getMelaLoginInfo() {
		LoginInfo login = StrutsActionContext.getValue(LoginInfo.ACTION_CONTEXT_KEY);
		if (login != null) {
			return login;
		}
		log.debug("cannot find LoginInfo in ActionContext, build it");
		HttpServletResponse response = ServletActionContext.getResponse();

		// 创建 session cookie 组数据读取器
		CookieReader sessionReader = CookieManager.newCookieReader(CookieName.SG_SESSION);

		// 创建 login cookie 组数据读取器
		CookieReader loginReader = CookieManager.newCookieReader(CookieName.LG_LOGIN);

		// 获取客户端 cookie Mapping
		CookieMapping mapping = getCookieMapping();

		// session cookie 组读取失败时
		// 不再清空 session group 和 login group 数据
		if (!sessionReader.readCookies(mapping, response)) {
			log.debug("read session group cookie data failed, need to re-login");
			return new LoginInfo();
		}

		// login cookie 组数据读取失败时
		// 不再清空 login group 数据
		if (!loginReader.readCookies(mapping, response)) {
			log.debug("read login group cookie data failed, need to re-login");
			return new LoginInfo();
		}

		// 创建用户登录数据对象
		login = new LoginInfo(sessionReader, loginReader);
		if (login.getOrgId().intValue() < 1) {
			return new LoginInfo();
		}
		
		StrutsActionContext.putValue(login, LoginInfo.ACTION_CONTEXT_KEY);
		return login;
	}

	private static void clearGroup(String group) {
		CookieReader loginReader = CookieManager.newCookieReader(group);
		int n = loginReader.clearGroup(ServletActionContext.getResponse());
		log.debug("logout clear group cookie: {}, clear count: {}", group, n);
	}
	
	
	public static void writeRefreshToken(RefreshToken refreshToken) {
		CookieWriter writer = CookieManager.newCookieWriter(CG_REFRESH_TOKEN);
		writer.addCookie(CN_REFRESH_T, refreshToken.getCookieValue());
		writer.write(ServletActionContext.getResponse());
	}

	public static String getRefreshToken() {
		CookieReader reader = CookieManager.newCookieReader(CG_REFRESH_TOKEN);
		if (!reader.readCookies(getCookieMapping(), ServletActionContext.getResponse()) ) {
			log.warn("read token " + CG_REFRESH_TOKEN + ", failed");
			return null;
		}
		return (String)reader.getOriginalValue(CN_REFRESH_T);
	}*/
	public static HttpServletResponse  getresponse(){
		ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletResponse response=(HttpServletResponse) requestAttributes.getRequest();
		return response;
	}
	
	public static HttpServletRequest  getrequest(){
		ServletRequestAttributes requestAttributes=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=(HttpServletRequest) requestAttributes.getRequest();
		return request;
	}
}
