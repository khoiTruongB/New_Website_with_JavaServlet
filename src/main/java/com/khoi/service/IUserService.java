package com.khoi.service;

import com.khoi.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status);
}
