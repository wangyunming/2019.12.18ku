package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.UserRole;
import com.haoyin.image.exception.DaoException;





/**
 * 用户角色
 * 
 * @author Summer
 *
 *         2016年5月3日
 */
@Mapper
public interface UserRoleDAO {

	/**
	 * 保存用户角色
	 * 
	 * @param upmList
	 * @return
	 * @throws DaoException
	 */
	public Integer saveUserRoles(List<UserRole> roleList) throws DaoException;

	/**
	 * 删除用户角色
	 * 
	 * @param userId
	 * @return
	 * @throws DaoException
	 */
	public Integer deleteUserRoles(Long userId) throws DaoException;

	/**
	 * 查询用户角色
	 * 
	 * @param userId
	 * @return
	 */
	public List<UserRole> findUserRoleForList(Long userId) throws DaoException;

}
