package com.haoyin.image.mapper;


import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.haoyin.image.entity.UserLogin;
import com.haoyin.image.entity.UserLoginQuery;
import com.haoyin.image.exception.DaoException;



/**
 * 用户登录日志
 * 
 * @author Summer
 *
 *         2016年5月20日
 */
@Mapper
public interface UserLoginDAO {

	/**
	 * 保存用户登录记录
	 * 
	 * @param login
	 * @return
	 * @throws DaoException
	 */
	public Integer saveUserLogin(UserLogin login) throws DaoException;

	/**
	 * 查询用户登录分页记录
	 * 
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public Page<UserLogin> findUserLoginForList(UserLoginQuery query) throws DaoException;

}
