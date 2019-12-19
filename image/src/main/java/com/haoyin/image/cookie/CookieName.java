package com.haoyin.image.cookie;

/**
 * <p>
 * Cookie 名称，详见 cookie-config.xml 配置
 * </p>
 * 
 */
class CookieName {

	/**
	 * Session Group -- session
	 */
	final static String SG_SESSION = "session";

	/**
	 * Session Group 会话 ID -- sid
	 */
	final static String SG_SESSION_ID = "sid";

	/**
	 * Login Group -- login
	 */
	final static String LG_LOGIN = "login";

	/**
	 * Login Group 登录用户ID -- UID
	 */
	final static String LG_LOGIN_USERID = "UID";

	/**
	 * Login Group 登录用户名 -- LN
	 */
	final static String LG_LOGIN_NAME = "LN";

	/**
	 * Login Group 用户姓名 -- UN
	 */
	final static String LG_LOGIN_USERNAME = "UN";
	
	/**
	 * Login Group 用户类型 -- UT
	 */
	final static String LG_LOGIN_USERTYPE = "UT";
	
	/**
	 * Login Group 用户类型 -- UT
	 */
	final static String LG_LOGIN_USERLEVEL = "UL";
	
	/**
	 * Login Group 登录时间 -- LT
	 */
	final static String LG_LOGIN_LOGINTIME = "LT";
	
	/**
	 * Login Group 登录时间 -- LT
	 */
	final static String LG_LOGIN_ORGID = "OI";

	/**
	 * 购物车 Group - Cart Group
	 */
	final static String CG_SHOPPING_CART = "shopping-cart";

	/**
	 * 购物车内容
	 */
	final static String CN_SHOPPING_CAR = "SC";

	/**
	 * 购物车内商品数量
	 */
	final static String CN_SHOPPING_NUMBER = "SD";
	
	/**
	 *  美乐家购物车 Group - Cart Group
	 */
	final static String M_CG_SHOPPING_CART = "m-shopping-cart";

	/**
	 * 美乐家购物车内容
	 */
	final static String M_CN_SHOPPING_CAR = "MSC";

	/**
	 * 美乐家购物车内商品数量
	 */
	final static String M_CN_SHOPPING_NUMBER = "MSD";

	/**
	 * 防重复提交 TOKEN Group -- refresh-token
	 */
	final static String CG_REFRESH_TOKEN = "refresh-token";

	/**
	 * 防重复提交 TOKEN -- _T_
	 */
	final static String CN_REFRESH_T = "_T_";

}
