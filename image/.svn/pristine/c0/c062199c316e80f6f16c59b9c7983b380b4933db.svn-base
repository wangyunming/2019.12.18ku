package com.haoyin.image.util.alipay;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *版本：3.2
 *日期：2011-03-17
 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public interface AlipayConfig {
	
	String SERVICE = AlipayConfigHelper.getInstance().getString("alipay_service");

	String PARTNER = AlipayConfigHelper.getInstance().getString("alipay_partner");

	String KEY = AlipayConfigHelper.getInstance().getString("alipay_key");
	
	String PUBLIC_KEY=AlipayConfigHelper.getInstance().getString("alipay_public_key");
	
	String PRIVATE_KEY=AlipayConfigHelper.getInstance().getString("merchant_private_key");

	String SELLER_EMAIL = AlipayConfigHelper.getInstance().getString("seller_email");

	String NOTIFY_URL = AlipayConfigHelper.getInstance().getString("notify_url");

	String RETURN_URL = AlipayConfigHelper.getInstance().getString("return_url");
	
	String M_RETURN_URL = AlipayConfigHelper.getInstance().getString("m_return_url");
	
	String M_NOTIFY_URL = AlipayConfigHelper.getInstance().getString("m_notify_url");

	String INPUT_CHARSET = AlipayConfigHelper.getInstance().getString("input_charset");;

	String SIGN_TYPE = AlipayConfigHelper.getInstance().getString("sign_type");

	String TRANSPORT = AlipayConfigHelper.getInstance().getString("transport");
	
	String ALIPAY_GATEWAY = AlipayConfigHelper.getInstance().getString("alipay_gateway");
	
	String SUBMIT_METHOD = AlipayConfigHelper.getInstance().getString("submit_method");
	
	//LOG_PATH = "C:\\alipay_log_" + System.currentTimeMillis()+".txt";
	
	String ALIRECH_RETURN_URL = AlipayConfigHelper.getInstance().getString("aliRech_return_url");
	
	String ALIRECH_NOTIFY_URL = AlipayConfigHelper.getInstance().getString("aliRech_notify_url");
	
	
	// quick login user auth
	
	String USER_AUTH_SERVICE = AlipayConfigHelper.getInstance().getString("user_auth_service");
	
	String USER_LOGIN_SERVICE = AlipayConfigHelper.getInstance().getString("user_login_service");
	
	String AUTH_RETURN_URL = AlipayConfigHelper.getInstance().getString("user_login_return_url");
	
}
