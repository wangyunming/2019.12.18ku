package com.haoyin.image.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.haoyin.image.cookie.ShoppingCartCookieManager;
import com.haoyin.image.entity.Login;
import com.haoyin.image.entity.ShoppingCartItem;
import com.haoyin.image.entity.UserLogin;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.message.MessageName;
import com.haoyin.image.service.OrderProcessService;
import com.haoyin.image.service.UserLoginService;
import com.haoyin.image.service.UserProfileService;
import com.haoyin.image.util.ServletUtil;



/**
 * @author Summer
 *
 * @date 2016年3月5日
 */
@Controller
public class LoginController implements MessageName {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UserProfileService userProfileService;

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private OrderProcessService orderProcessService;

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String goLogin(HttpServletRequest request,@ModelAttribute("invokeResult") String invokeResult,Model model) {
		model.addAttribute("invokeResult", invokeResult);
		return "screen/auth/login";
	}

	/**
	 * 用户登录
	 * 
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping(value = "/auth/login", method = RequestMethod.POST)
	public String login(Login login, HttpServletRequest request, HttpServletResponse response, Model model,RedirectAttributes redirect) throws Exception {
		UsernamePasswordToken token = new UsernamePasswordToken(login.getUsername(), login.getPassword());
		token.setRememberMe(login.isRememberMe());

		UserLogin userLogin = new UserLogin();
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token); // verify login info
			userLogin.setLoginStatus(1);
		}catch(UnknownAccountException e){
			// 账户已锁定
			model.addAttribute("invokeResult", "账户不存在");
			userLogin.setLoginStatus(0);
			userLogin.setRemarks("账户不存在");
		}
		catch (LockedAccountException e) {
			// 账户已锁定
			model.addAttribute("invokeResult", "账户已锁定,请联系管理员");
			userLogin.setLoginStatus(0);
			userLogin.setRemarks("账户已锁定");
		} catch (ExcessiveAttemptsException e) {
			// 用户名或密码错误次数过多, 限制登录
			model.addAttribute("invokeResult", "错误登录次数频繁, 请稍后再试");
			userLogin.setLoginStatus(0);
			userLogin.setRemarks("错误登录次数频繁");
		} catch (AuthenticationException e) {
			model.addAttribute("invokeResult", "用户名或密码错误");
			userLogin.setLoginStatus(0);
			userLogin.setRemarks("用户名或密码错误");
		}
		
		if (!subject.isAuthenticated()) {
			token.clear();
			return "screen/auth/login";
		}
		
		userLogin.setLoginUsername(login.getUsername());
		userLogin.setLoginHost(ServletUtil.getRemoteIp());
		userLoginService.afterUserLogin(userLogin);

		

		// 登录成功后, 更新用户登录信息
		long userId = (long) subject.getSession().getAttribute("uid");
		UserProfile profile = userProfileService.queryUserProfile(userId, false);
		subject.getSession().setAttribute("uus", profile);
		ShoppingCartItem query=new ShoppingCartItem();
		query.setUserId(userId);
		int n=orderProcessService.queryCartListCount(query);
		ShoppingCartCookieManager.writeShoppingNumber(n);
		// 返回被拦截前请求的 URL
		SavedRequest returnRequest = WebUtils.getSavedRequest(request);
		if (null == returnRequest || null == returnRequest.getRequestUrl()) {
			return "redirect:/dashboard.html";
		}
		if("/demo/".equals(returnRequest.getRequestUrl())){
			return "redirect:/dashboard.html";
		}	
			return "redirect:" + returnRequest.getRequestUrl();
		}
	/**
	 * 用户登出
	 */
	@RequestMapping("/logout.htm")
	public String logout(HttpServletRequest request) {
		SecurityUtils.getSubject().logout();
		return InternalResourceViewResolver.REDIRECT_URL_PREFIX + "/index";
	}
	/**
	 * 首页 客户
	 * @throws IOException
	 * @throws ServletException
	 */
	@RequestMapping("/dashboard.html")	
	public String queryCompanyListByUser(HttpServletRequest request, HttpServletResponse response,Model model) throws Exception {		
		/**用户当前登录客户清空end***/
		// 首页
		return "redirect:/fileList.html";
	}
	
}
