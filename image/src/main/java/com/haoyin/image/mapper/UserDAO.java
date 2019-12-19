package com.haoyin.image.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.User;
import com.haoyin.image.exception.DaoException;



/**
 * 用户 DAO
 * 
 * @author Summer
 */
@Mapper
public interface UserDAO {

	/**
	 * 新增用户
	 * 
	 * @param user
	 * @return
	 * @throws DaoException
	 */
	public Integer saveUser(User user) throws DaoException;

	/**
	 * 更新用户
	 * 
	 * @param user
	 * @return
	 * @throws DaoException
	 */
	public Integer updateUser(User user) throws DaoException;

	/**
	 * 根据userId查询用户
	 * 
	 * @param userId
	 * @return
	 * @throws DaoException
	 */
	public User findUserByUserId(Long userId) throws DaoException;

	/**
	 * 根据username查询用户
	 * 
	 * @param username
	 * @return
	 * @throws DaoException
	 */
	public User selectUserByUsername(String username) throws DaoException;

	/**
	 * 根据phone查询用户
	 * 
	 * @param username
	 * @return
	 * @throws DaoException
	 */
	public User findUserByPhone(String phone) throws DaoException;


}
