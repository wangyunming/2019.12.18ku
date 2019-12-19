package com.haoyin.image.service;

import java.util.List;
import java.util.Set;

import com.haoyin.image.entity.RoleQuery;





/**
 * @author Summer
 *
 *         2016年3月13日
 */
public interface UserAuthorizationService {

	/**
	 * 查询用户角色
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> queryUserRoleList(String username);

	/**
	 * <p>
	 * 查询用户权限
	 * </p>
	 * <p>
	 * permission = target~action
	 * </p>
	 * 
	 * @param username
	 * @return
	 */
	public Set<String> queryUserPermissionList(String username);
	
	
	public List<Integer> queryPositionId(RoleQuery query);

}
