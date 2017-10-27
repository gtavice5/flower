package com.jkxy.service;

import com.jkxy.model.Admin;
import com.jkxy.model.Users;

public interface IUsersService {

	public boolean addOrUpadateUser(Users users);
	public Users checkUser(Users users);
	public Admin checkAdmin(Admin admin);
}
