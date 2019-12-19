package com.haoyin.image.serviceImpl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.User;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.entity.UserQuery;
import com.haoyin.image.entity.UserRole;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.UserDAO;
import com.haoyin.image.mapper.UserProfileDAO;
import com.haoyin.image.mapper.UserRoleDAO;
import com.haoyin.image.service.UserProfileService;



/**
 * @author Summer
 *
 *         2016年3月21日
 */
@Service
public class UserProfileServiceImpl extends BaseService  implements UserProfileService {

	private static Logger log = LoggerFactory.getLogger(UserProfileServiceImpl.class);
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserProfileDAO userProfileDAO;
	@Autowired
	private UserRoleDAO userRoleDAO;


	@Override
	public String queryDeptNameForID(Long id) {
		try {
			return userProfileDAO.queryDeptNameForID(id);
		} catch (DaoException e) {
			log.error("Exception occurred during find UserProfile's permission for list :", e);
		}
		return null;
	}
	
	
	
	
	@Override
	public List<UserProfile> queryUserProfileInDept(Long deptId) {
		try {
			return userProfileDAO.queryUserProfileInDept(deptId);
		} catch (DaoException e) {
			log.error("Exception occurred during find user list :", e);
		}
		return null;
	}
	
	
	/**
	 * @param userDAO
	 *            the {@link #userDAO} to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	
	

	/**
	 * @param userRoleDAO
	 *            the {@link #userRoleDAO} to set
	 */
	public void setUserRoleDAO(UserRoleDAO userRoleDAO) {
		this.userRoleDAO = userRoleDAO;
	}

	
	/**
	 *   报销页面实际被报销人(查询所有员工)
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllPerson() {
		try {
			return userProfileDAO.selectAtAllPerson();
		} catch (DaoException e) {
			log.error("Exception occurred during find selectAtAllPerson :", e);
		}
		return null;
	}
	
	/**
	 * 根据ID查询下属人员信息
	 * @Description: 
	 * @author Sunny
	 * @date 2018年2月7日 下午5:18:35 
	 * @return
	 */
	
	
	
	/**
	 *   查询所有销售人员
	 * @return
	 * @throws DaoException
	 */
	public List<UserProfile> selectAtAllSale() {
		try {
			return userProfileDAO.selectAtAllSale();
		} catch (DaoException e) {
			log.error("Exception occurred during find selectAtAllPerson :", e);
		}
		return null;
	}

	@Override
	public boolean createUser(UserProfile profile) {
		return executeTransaction(action -> {
			try {
				userProfileDAO.saveUserProfile(profile);

				User user = new User();
				user.setUserId(profile.getId());
				user.setUsername(profile.getUsername());
				user.setPassword(profile.getPassword());
				user.setSalt(profile.getSalt());
				userDAO.saveUser(user);

				if (!CollectionUtils.isEmpty(profile.getUserRoleList())) {
					userRoleDAO.deleteUserRoles(profile.getId());
					for(UserRole ur:profile.getUserRoleList()){
						ur.setUserId(profile.getId());
					}
					userRoleDAO.saveUserRoles(profile.getUserRoleList());
				}

				return true;
			} catch (Exception e) {
				log.error("Exception occurred during create user transaction :", e);
				throw new RuntimeException("Create user transaction failed.");
			}

		});
	}

	@Override
	public UserProfile queryUserProfile(long userId, boolean hasRols) {
		try {
			UserProfile profile = userProfileDAO.findUserProfileById(userId);
			if (hasRols) {
				profile.setUserRoleList(userRoleDAO.findUserRoleForList(userId));
			}

			return profile;
		} catch (DaoException e) {
			log.error("Exception occurred during find user profile by id :", e);
		}
		return null;
	}

	@Override
	public UserProfile queryUserProfileByRoleId(long roleId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile queryUserProfile(String username) {
		try{
		    UserProfile userProfile=userProfileDAO.selectUserProfileByUserName(username);
		    return userProfile;
		}catch(DaoException e){
			log.error("Exception",e);
		}
		return null;
	}

	@Override
	public boolean updateUserProfile(UserProfile profile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserSalary(UserProfile userProfile) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PageInfo<UserProfile> queryUserProfileForList(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> queryUserProfileList(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserProfile> queryUserProfileListByRole(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile selectProjectCheckUser(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile selectCheckUser(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserProfile selectCheckUserForProduct(UserQuery query) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getBelongUserId(UserProfile user) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<UserProfile> queryBLUserByIdList(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
