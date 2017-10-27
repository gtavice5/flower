package com.jkxy.dao;

import com.jkxy.model.Admin;
import com.jkxy.model.Users;

public interface IUsersDAO {

	public boolean addOrUpadateUser(Users users);
	public Users checkUser(Users users);
	public Admin checkAdmin(Admin admin);
}
