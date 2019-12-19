package com.haoyin.image.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.haoyin.image.message.Message;






public class ServletUtil {

	private final static String INVOKE_MESSAGE = "invokeMessage";
	
	/**
	 * <p>
	 * Web 服务器反向代理中用于存放客户端原始 IP 地址的 Http header 名字。
	 * </p>
	 */
	private final static String[] PROXY_REMOTE_IP_ADDRESS = { "X-Forwarded-For", "X-Real-IP", "Proxy-Client-IP", "WL-Proxy-Client-IP", "HTTP_CLIENT_IP",
			"HTTP_X_FORWARDED_FOR" };

	private ServletUtil() {
	}

	/**
	 * <p>
	 * 获取请求的客户端的 IP 地址。若应用服务器前端配有反向代理的 Web 服务器， 需要在 Web 服务器中将客户端原始请求的 IP 地址加入到 HTTP header 中。 详见
	 * {@link ServletUtil#PROXY_REMOTE_IP_ADDRESS}
	 * </p>
	 *
	 * @param request
	 * @return
	 *
	 * @author gaobaowen
	 */
	public static String getRemoteIp(HttpServletRequest request) {
		for (int i = 0; i < PROXY_REMOTE_IP_ADDRESS.length; i++) {
			String ip = request.getHeader(PROXY_REMOTE_IP_ADDRESS[i]);
			if (!StringUtils.isEmpty(ip) && !"unknown".equals(ip)) {
				return getRemoteIpFromForward(ip);
			}
		}
		return request.getRemoteHost();
	}

	/**
	 * <p>
	 * 从 HTTP Header 的 X-Forward-IP 头中截取客户端连接 IP 地址。如果经过多次反向代理， 在 X-Forward-IP 中获得的是以“,&lt;SP&gt;”分隔 IP 地址链，第一段为客户端 IP
	 * 地址。
	 * </p>
	 *
	 * @param xforwardIp
	 * @return
	 */
	private static String getRemoteIpFromForward(String xforwardIp) {
		int commaOffset = xforwardIp.indexOf(',');
		if (commaOffset < 0) {
			return xforwardIp;
		}
		return xforwardIp.substring(0, commaOffset);
	}

	public static String getRemoteIp() {
		HttpServletRequest request = getServletRequest();
		return getRemoteIp(request);
	}

	public static String getRemoteHostName() {
		return getServletRequest().getServerName();
	}

	/**
	 * <p>
	 * 获取应用服务器的 HTTP 监听端口号
	 * </p>
	 *
	 * @param request
	 * @return
	 *
	 * @author gaobaowen
	 */
	public static int getServerPort(HttpServletRequest request) {
		return request.getServerPort();
	}
	
	public static String setInvokeMessageKey(String messageKey, Object... args) {
		return setInvokeMessage(Message.getMessage(messageKey, args));
	}

	public static String setInvokeMessage(String message) {
		getServletRequest().setAttribute(INVOKE_MESSAGE, message);
		return message;
	}

	/**
	 * 将指定 key 对应value放入值栈中
	 * 
	 * @param key
	 * @param value
	 */
	public static void setInvokeMessage(String key, String value) {
		getServletRequest().setAttribute(key, value);
	}
	
	public static HttpServletRequest getServletRequest() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttributes.getRequest();
	}

	public static HttpServletResponse getServletResponse() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttributes.getResponse();
	}
	
	public static HttpSession getServletSession() {
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		return requestAttributes.getRequest().getSession();
	}

}
