package com.haoyin.image.serviceImpl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoyin.image.entity.RoleQuery;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.UserPermissionDAO;
import com.haoyin.image.service.UserAuthorizationService;





/**
 * @author Summer
 *
 *         2016年5月20日
 */
@Service
public class UserAuthorizationServiceImpl implements UserAuthorizationService {

	private static Logger log = LoggerFactory.getLogger(UserAuthorizationServiceImpl.class);
	@Autowired
	private UserPermissionDAO userPermissionDAO;

	@Override
	public Set<String> queryUserRoleList(String username) {
		try {
			List<String> list = userPermissionDAO.findUserRoleList(username);
			Set<String> roleSet = new HashSet<>();
			for (String role : list) {
				roleSet.add(role);
			}
			return roleSet;
		} catch (DaoException e) {
			log.error("Exception occurred during find user role Set<string> :");
		}

		return Collections.emptySet();
	}

	@Override
	public Set<String> queryUserPermissionList(String username) {
		try {
			List<String> list = userPermissionDAO.findUserPermissionList(username);
			Set<String> permissionSet = new HashSet<>();
			for (String permission : list) {
				permissionSet.add(permission);
			}
			return permissionSet;
		} catch (DaoException e) {
			log.error("Exception occurred during find user permission Set<string> :");
		}

		return Collections.emptySet();
	}
	public List<Integer> queryPositionId(RoleQuery query){
		try {
			List<Integer> list = userPermissionDAO.queryPositionId(query);
			
			return list;
		} catch (DaoException e) {
			log.error("Exception occurred during find user permission Set<string> :");
		}

		return null;
	}
	/**
	 * @param userPermissionDAO
	 *            the {@link #userPermissionDAO} to set
	 */
	public void setUserPermissionDAO(UserPermissionDAO userPermissionDAO) {
		this.userPermissionDAO = userPermissionDAO;
	}

}
