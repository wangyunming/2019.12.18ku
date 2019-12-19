package com.haoyin.image.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.github.pagehelper.Page;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.entity.UserQuery;
import com.haoyin.image.exception.DaoException;



/**
 * 用户资料 DAO
 * 
 * @author Summer
 *
 *         2016年3月21日
 */
@Mapper
public interface UserProfileDAO {
	
	/**
	 * 根据部门ID获取部门名称
	 * @param id
	 * @return
	 * @throws DaoException
	 */
	public String queryDeptNameForID(Long id) throws DaoException;

	/**
	 * 保存用户信息
	 * 
	 * @param userProfile
	 * @return
	 * @throws DaoException
	 */
	public Integer saveUserProfile(UserProfile userProfile) throws DaoException;

	/**
	 * 更新用户信息
	 * 
	 * @param userProfile
	 * @return
	 * @throws DaoException
	 */
	public Integer updateUserProfile(UserProfile userProfile) throws DaoException;
	/**
	 * 更新用户薪资
	 * @param userProfile
	 * @return
	 * @throws DaoException
	 */
	public Integer updateUserSalary(UserProfile userProfile) throws DaoException;

	/**
	 * 根据 ID 查询用户信息
	 * 
	 * @param userId
	 * @return
	 * @throws DaoException
	 */
	public UserProfile findUserProfileById(Long userId) throws DaoException;
	
	/**
	 * 根据 角色ID 查询一个人
	 * 
	 * @param userId
	 * @return
	 * @throws DaoException
	 */
	public UserProfile queryUserProfileByRoleId(Long roleId) throws DaoException;

	/**
	 * 根据 username 查询用户信息
	 * 
	 * @param username
	 * @return
	 * @throws DaoException
	 */
	public UserProfile findUserProfileByUsername(String username) throws DaoException;
	
	/**
	 * 查询审核人ID
	 * 
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public UserProfile findUserProfileForExam(UserQuery query) throws DaoException;

	/**
	 * 查询用户分页数据
	 * 
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public Page<UserProfile> findUserProfileForList(UserQuery query) throws DaoException;
	
	public List<UserProfile>  queryUserProfileList(UserQuery query)throws DaoException;
	/**
	 * 查询当前用户所在部门下属人员
	 * 
	 * @param role
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> queryUserProfileListByRole(UserQuery query) throws DaoException;

	/**
	 * 
	 * @Description: queryUserProfileInDept 
	 * @param deptId
	 * @return
	 */
	public List<UserProfile> queryUserProfileInDept(Long deptId) throws DaoException;

	/**
	 * 根据审核表ID查询当前审核人
	 * @Description: 
	 * @author Sunny
	 * @date 2017年8月18日 下午2:17:40 
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public UserProfile selectCheckUser(UserQuery query) throws DaoException;
	
	/**
	 * 查询待审核人信息(针对新项目管理)
	 * @param query
	 * @return
	 * @throws DaoException
	 */
	public UserProfile selectProjectCheckUser(UserQuery query) throws DaoException;

	public UserProfile selectCheckUserForProduct(UserQuery query) throws DaoException;
	
	
	/**
	 *   报销页面实际被报销人(查询所有员工)
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllPerson() throws DaoException;

	/**
	 * 根据ID列表查询用户信息
	 * @Description: 
	 * @author Sunny
	 * @date 2018年2月7日 下午5:17:37 
	 * @param ids
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> queryUserByIdList(List<String> ids) throws DaoException;
	
	
	
	/**
	 *   查询所有销售人员
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllSale() throws DaoException;
	
	/*
	 * 根据Id查询所属用户信息
	 */
	public UserProfile queryBelongUserById(Long id) throws DaoException;
	
	public UserProfile  selectUserProfileByUserName(String username) throws DaoException;

}
