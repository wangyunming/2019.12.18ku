package com.haoyin.image.serviceImpl;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.haoyin.image.entity.User;
import com.haoyin.image.entity.UserLogin;
import com.haoyin.image.entity.UserLoginQuery;
import com.haoyin.image.entity.UserProfile;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.exception.TransactionRuntimeException;
import com.haoyin.image.mapper.UserDAO;
import com.haoyin.image.mapper.UserLoginDAO;
import com.haoyin.image.mapper.UserProfileDAO;
import com.haoyin.image.service.UserLoginService;



/**
 * @author Summer
 *
 *         2016年5月20日
 */
@Service
public class UserLoginServiceImpl extends BaseService  implements UserLoginService {

	private static Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);
	@Autowired
	private UserLoginDAO userLoginDAO;
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserProfileDAO userProfileDAO;

	@Override
	public void recordUserLogin(UserLogin login) {
		try {
			userLoginDAO.saveUserLogin(login);
		} catch (DaoException e) {
			log.error("Exception occurred during record user login log :", e);
		}
	}

	
	@Override
	public PageInfo<UserLogin> queryUserLoginForList(UserLoginQuery query) {
		try {
			return userLoginDAO.findUserLoginForList(query).toPageInfo();
		} catch (DaoException e) {
			log.error("Exception occurred during find user login log for List :", e);
		}

		return new PageInfo<UserLogin>();
	}

	/**
	 * @param userLoginDAO
	 *            the {@link #userLoginDAO} to set
	 */
	public void setUserLoginDAO(UserLoginDAO userLoginDAO) {
		this.userLoginDAO = userLoginDAO;
	}

	/**
	 * @param userDAO
	 *            the {@link #userDAO} to set
	 */
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * @param userProfileDAO
	 *            the {@link #userProfileDAO} to set
	 */
	public void setUserProfileDAO(UserProfileDAO userProfileDAO) {
		this.userProfileDAO = userProfileDAO;
	}


	
	@Override
	public void afterUserLogin(UserLogin login) {
		executeTransaction(action -> {
			try {
				User user = userDAO.selectUserByUsername(login.getLoginUsername());
				UserProfile profile = new UserProfile();
				profile.setId(user.getUserId());
				profile.setLastLoginIp(login.getLoginHost());
				profile.setLastLoginTime(Calendar.getInstance().getTime());
				userProfileDAO.updateUserProfile(profile);

				login.setGmtLogin(profile.getLastLoginTime());
				userLoginDAO.saveUserLogin(login);

				return true;
			} catch (Exception e) {
				log.error("Exception occurred during record user login log :", e);
				throw new TransactionRuntimeException("record user login log transaction failed.", e);
			}
		});
	}

}
