package com.khoi.dao.impl;

import java.util.List;

import com.khoi.dao.IUserDAO;
import com.khoi.mapper.UsersMapper;
import com.khoi.model.UserModel;

public class UserDao extends AdstractDAO<UserModel> implements IUserDAO{

	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String passWord, Integer status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM users as u");
		sql.append(" INNER JOIN role as r on r.id = u.roleid");
		sql.append(" WHERE username = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UsersMapper(), userName, passWord, status);
		return users.isEmpty() ? null : users.get(0);
			 
	}

}
