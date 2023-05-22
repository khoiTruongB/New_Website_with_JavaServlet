package com.khoi.service.impl;

import javax.inject.Inject;

import com.khoi.dao.IUserDAO;
import com.khoi.model.UserModel;
import com.khoi.service.IUserService;

public class UserService implements IUserService{

	@Inject
	private IUserDAO userDao;
	
	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		
		return userDao.findByUserNameAndPassWordAndStatus(userName, passWord, status);
	}

}
