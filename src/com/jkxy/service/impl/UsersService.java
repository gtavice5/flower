package com.jkxy.service.impl;

import com.jkxy.dao.IUsersDAO;
import com.jkxy.model.Admin;
import com.jkxy.model.Users;
import com.jkxy.service.IUsersService;

public class UsersService implements IUsersService {

	private IUsersDAO usersDAO;
	
	
	public IUsersDAO getUsersDAO() {
		return usersDAO;
	}


	public void setUsersDAO(IUsersDAO usersDAO) {
		this.usersDAO = usersDAO;
	}


	@Override
	public boolean addOrUpadateUser(Users user) {
		return usersDAO.addOrUpadateUser(user);
	}


	@Override
	public Users checkUser(Users user) {
		return usersDAO.checkUser(user);
	}


	@Override
	public Admin checkAdmin(Admin admin) {
		return usersDAO.checkAdmin(admin);
	}


}
