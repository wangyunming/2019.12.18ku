package com.haoyin.image.serviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haoyin.image.entity.User;
import com.haoyin.image.exception.DaoException;
import com.haoyin.image.mapper.UserDAO;
import com.haoyin.image.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDAO userDAO; 
	private static final Logger logger=LoggerFactory.getLogger(UserServiceImpl.class);
	
	
	

	@Override
	public User queryUser(String name) {
		
			try {
				return userDAO.selectUserByUsername(name);
			} catch (DaoException e) {
				logger.error("Exception occurred during find user by username :", e);
			}

			return null;
		}
		
	}



