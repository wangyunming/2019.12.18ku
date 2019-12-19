package com.haoyin.image.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.entity.UserQuery;
import com.haoyin.image.exception.DaoException;



/**
 * 用户资料
 * 
 * @author Summer
 *
 *         2016年3月21日
 */
public interface UserProfileService {

	/**
	 * 创建用户
	 * 
	 * @param userProfile
	 * @return
	 */
	public boolean createUser(UserProfile userProfile);
	

	/**
	 * 查询用户信息
	 * 
	 * @param userId
	 * @return
	 */
	public UserProfile queryUserProfile(long userId, boolean hasRols);
	
	/**
	 * 根据角色ID查出一个人
	 * 
	 * @param userId
	 * @return
	 */
	public UserProfile queryUserProfileByRoleId(long roleId);

	/**
	 * 查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public UserProfile queryUserProfile(String username);

	/**
	 * 更新用户资料
	 * 
	 * @param profile
	 * @return
	 */
	public boolean updateUserProfile(UserProfile profile);
	/**
	 * 更新用户薪资
	 * @param userProfile
	 * @return
	 */
	public boolean updateUserSalary(UserProfile userProfile);

	/**
	 * 查询用户分页列表
	 * 
	 * @param query
	 * @return
	 */
	public PageInfo<UserProfile> queryUserProfileForList(UserQuery query);
	
	public List<UserProfile>  queryUserProfileList(UserQuery query);
	
	/**
	 * 根据部门ID获取部门名称
	 * @param id
	 * @return
	 */
	public String queryDeptNameForID(Long id);
	
	/**
	 * 查询当前用户所在部门下属人员
	 * 
	 * @param role
	 * @return
	 */
	public List<UserProfile> queryUserProfileListByRole(UserQuery query);

	/**
	 * 
	 * @Description: query all user in this department 
	 * @param deptId
	 * @return
	 */
	public List<UserProfile> queryUserProfileInDept(Long deptId);

	
	/**
	 * 查询待审核人信息(针对新项目管理)
	 * @param query
	 * @return
	 */
	public UserProfile selectProjectCheckUser(UserQuery query);

	/**
	 * 查询待审核人信息
	 * @Description: 
	 * @author Sunny
	 * @date 2017年8月18日 下午3:00:09 
	 * @param query
	 * @return
	 */
	public UserProfile selectCheckUser(UserQuery query);
	/**
	 * 查询待审核人信息
	 * @Description: 
	 * @author Sunny
	 * @date 2017年8月18日 下午3:00:09 
	 * @param query
	 * @return
	 */
	public UserProfile selectCheckUserForProduct(UserQuery query);


	/**
	 * 获取下属ID
	 * @Description: 
	 * @author Sunny
	 * @date 2017年9月21日 下午1:51:12 
	 * @param user
	 * @return
	 */
	public List<String> getBelongUserId(UserProfile user);
	
	
	/**
	 *   报销页面实际被报销人(查询所有员工)
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllPerson();


	/**
	 * 根据ID查询下属人员信息
	 * @Description: 
	 * @author Sunny
	 * @date 2018年2月7日 下午5:22:30 
	 * @param userId
	 * @return
	 */
	public List<UserProfile> queryBLUserByIdList(Long userId);
	
	
	/**
	 *   查询所有销售人员
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllSale();
	
}
