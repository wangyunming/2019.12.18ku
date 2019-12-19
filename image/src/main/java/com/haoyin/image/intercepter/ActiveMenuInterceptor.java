package com.haoyin.image.intercepter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.haoyin.image.entity.Menu;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.service.MenuService;




public class ActiveMenuInterceptor extends HandlerInterceptorAdapter {
	
	@Autowired
	private MenuService menuService;
	
	private static Logger log = LoggerFactory.getLogger(ActiveMenuInterceptor.class);

	private static final String UK_ACTIVE_MENU_TARGET = "_j_c_active";

	private static final String KEY_URI_MENU = "uri";
	private static final String KEY_TARGET_MENU = "target";
	private static final String KEY_ACTIVE_MENU = "active";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		List<Menu> menus = menuService.queryMenuTreeForList();

		Map<String, String> map = new HashMap<>();
		map.put(KEY_URI_MENU, request.getRequestURI());

		Cookie cookie = getCookie(request, UK_ACTIVE_MENU_TARGET);
		Optional<Cookie> cookieOpt = Optional.ofNullable(cookie);
		cookieOpt.ifPresent(c -> map.put(KEY_TARGET_MENU, c.getValue()));
		
		menus.forEach(menu -> {
			menu.setActive(false);

			if (StringUtils.equalsIgnoreCase(menu.getHref(), map.get(KEY_URI_MENU))) {
				menu.setActive(true);
				map.put(KEY_TARGET_MENU, menu.getTarget());

				map.put(KEY_ACTIVE_MENU, KEY_ACTIVE_MENU);
			}
			setSubmenuActive(response, menu, map);
		});

		if (!StringUtils.equals(KEY_ACTIVE_MENU, map.get(KEY_ACTIVE_MENU))) {
			menus.forEach(menu -> {
				String hashed = Base64.encodeBase64String(menu.getTarget().getBytes());

				if (StringUtils.equals(hashed, map.get(KEY_TARGET_MENU))) {
					menu.setActive(true);
					map.put(KEY_TARGET_MENU, menu.getTarget());
				}
				setSubmenuActionActive(response, menu, map);
			});
		}
		
		List<Menu> userMenuList = new ArrayList<>();
		List<Menu> customerMenuList = new ArrayList<>();
		
		menus.forEach(menu -> {
			if (menu.getType() == 0) {
				userMenuList.add(menu);
			} else {
				customerMenuList.add(menu);
			}
		});

		request.setAttribute("menus", userMenuList);
		writeCookie(response, UK_ACTIVE_MENU_TARGET, map.get(KEY_TARGET_MENU));

		Subject subject = SecurityUtils.getSubject();
		UserProfile profile = (UserProfile) subject.getSession().getAttribute("uus");
		Optional<UserProfile> optional = Optional.ofNullable(profile);

		optional.ifPresent(user -> {
			if (null != user.getCustomerId()) {
				request.setAttribute("menus", customerMenuList);
			}
		});

		log.info("System menu initialization is complete.");

		return super.preHandle(request, response, handler);
	}

	private void setSubmenuActive(HttpServletResponse response, Menu menu, Map<String, String> map) {
		if (CollectionUtils.isEmpty(menu.getSubList())) {
			return;
		}
		menu.getSubList().forEach(m -> {
			m.setActive(false);

			if (StringUtils.equalsIgnoreCase(m.getHref(), map.get(KEY_URI_MENU))) {
				m.setActive(true);
				map.put(KEY_TARGET_MENU, m.getTarget());

				map.put(KEY_ACTIVE_MENU, KEY_ACTIVE_MENU);
			}
			// recursion invoke
			setSubmenuActive(response, m, map);
			
			if (m.isActive()) {
				menu.setActive(true);
			}
		});
	}

	private void setSubmenuActionActive(HttpServletResponse response, Menu menu, Map<String, String> map) {
		if (CollectionUtils.isEmpty(menu.getSubList())) {
			return;
		}
		menu.getSubList().forEach(m -> {
			String hashed = Base64.encodeBase64String(m.getTarget().getBytes());

			if (StringUtils.equals(hashed, map.get(KEY_TARGET_MENU))) {
				m.setActive(true);
				menu.setActive(true);
				map.put(KEY_TARGET_MENU, m.getTarget());
			}
			// recursion invoke
			setSubmenuActionActive(response, m, map);
		});
	}

	
	private void writeCookie(HttpServletResponse response, String name, String value) {
		if (null == value) {
			return;
		}
		
		String base64 = Base64.encodeBase64String(value.getBytes());
		Cookie cookie = new Cookie(name, base64);
		cookie.setPath("/");

		response.addCookie(cookie);
	}

	
	private Cookie getCookie(HttpServletRequest request, String name) {
		Cookie[] cookies = request.getCookies();

		if (null != cookies) {
			for (Cookie cookie : cookies) {

				if (cookie.getName().equals(name)) {
					return cookie;
				}
			}
		}

		return null;
	}

}