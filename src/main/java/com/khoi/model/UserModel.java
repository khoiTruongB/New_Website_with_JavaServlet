package com.khoi.model;

public class UserModel extends AdstractModel<UserModel>{
	private long id;
	private String userName;
	private String passWord;
	private String fullName;
	private Integer status;
	private long roleid;
	private RoleModel role = new RoleModel();//

	public UserModel() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String password) {
		this.passWord = password;
	}

	public String getFullname() {
		return fullName;
	}

	public void setFullname(String fullname) {
		this.fullName = fullname;
	}

	

	public long getRoleid() {
		return roleid;
	}

	public void setRoleid(long roleid) {
		this.roleid = roleid;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public RoleModel getRole() {
		return role;
	}

	public void setRole(RoleModel role) {
		this.role = role;
	}

	
}
