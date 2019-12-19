package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.haoyin.image.entity.RoleQuery;
import com.haoyin.image.entity.UserPermission;
import com.haoyin.image.exception.DaoException;





/**
 * 用户权限
 * 
 * @author Summer
 *
 *         2016年5月3日
 */
@Mapper
public interface UserPermissionDAO {

	/**
	 * 查询用户角色
	 * 
	 * @param username
	 * @return
	 */
	public List<String> findUserRoleList(String username) throws DaoException;

	/**
	 * 查询用户权限, e.g. <code>target:action</code>
	 * 
	 * @param username
	 * @return
	 */
	public List<String> findUserPermissionList(String username) throws DaoException;

	public List<Integer> queryPositionId(RoleQuery query) throws DaoException;
	/**
	 * 查询用户权限
	 * 
	 * @param username
	 * @return
	 * @throws DaoException
	 */
	public List<UserPermission> findUserPermissionForList(String username) throws DaoException;

}
