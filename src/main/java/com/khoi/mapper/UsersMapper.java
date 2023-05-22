package com.khoi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.khoi.model.RoleModel;
import com.khoi.model.UserModel;

public class UsersMapper implements IRowMapper<UserModel> {

	@Override
	public UserModel mapRow(ResultSet rs) {
		UserModel userModel = new UserModel();
		try {
			userModel.setId(rs.getLong("id"));
			userModel.setUsername(rs.getString("username"));
			userModel.setPassword(rs.getString("password"));
			userModel.setFullname(rs.getString("fullname"));
			userModel.setStatus(rs.getInt("status"));
			try {
				
				RoleModel role = new RoleModel();
				role.setCode(rs.getString("code"));
				role.setName(rs.getString("name"));
				userModel.setRole(role);

			}catch (Exception e) {
				System.out.print(e.getMessage());
			}
			
		
//			userModel.setCreatedDate(rs.getTimestamp("createddate"));
//			userModel.setCreatedBy(rs.getString("createdby"));
//			if (rs.getTimestamp("modifieddate") != null) {
//				userModel.setModifiedDate(rs.getTimestamp("modifieddate"));
//			}
//			if (rs.getString("modifiedby") != null) {
//				userModel.setModifiedBy(rs.getString("modifiedby"));
//			}
			return userModel;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}
}
