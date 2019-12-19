package com.haoyin.image.service;



import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.UserLogin;
import com.haoyin.image.entity.UserLoginQuery;



/**
 * @author Summer
 *
 *         2016年5月20日
 */
public interface UserLoginService {

	/**
	 * 记录登录日志
	 * 
	 * @param login
	 */
	public void recordUserLogin(UserLogin login);

	/**
	 * 登录后处理
	 * 
	 * @param user
	 */
	public void afterUserLogin(UserLogin login);

	/**
	 * 查询用户登分页记录
	 * 
	 * @param query
	 * @return
	 */
	public PageInfo<UserLogin> queryUserLoginForList(UserLoginQuery query);

}
