package com.khoi.dao;

import com.khoi.model.UserModel;

public interface IUserDAO extends IGenericDAO<UserModel>{
	UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status);
}
