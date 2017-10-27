package com.jkxy.model;

//管理员表admin
public class Admin {

	private int adminId;//管理员ID
	private String username;//管理员用户名
	private String password;//管理员密码
	
	public Admin() {
		
	}
	
	

	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", username=" + username + ", password=" + password + "]";
	}
	
	
}
