package com.jkxy.action;

import java.util.Map;

import com.jkxy.model.Admin;
import com.jkxy.model.Users;
import com.jkxy.service.IUsersService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport {
	private Users users;
	private Admin admin;
	private IUsersService usersService;
	private String password;
	private String pwd1;
	private int userid;
	private String role;
	
	
	
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public IUsersService getUsersService() {
		return usersService;
	}
	public void setUsersService(IUsersService usersService) {
		this.usersService = usersService;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPwd1() {
		return pwd1;
	}
	public void setPwd1(String pwd1) {
		this.pwd1 = pwd1;
	}
	
	public String addUser() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Users users1=new Users();
		users1.setUserName(users.getUserName());
		users1.setRealName(users.getRealName());
		users1.setPassword(users.getPassword());
		users1.setPwdQuestion(users.getPwdQuestion());
		users1.setPwdQuestionAnswer(users.getPwdQuestionAnswer());
		users1.setAddress(users.getAddress());
		users1.setPhoneNO(users.getPhoneNO());
		users1.setEmail(users.getEmail());
		
		if (usersService.addOrUpadateUser(users1)) {
			return SUCCESS;
		} else {
			return ERROR;
		}
		
	}
	
	public String checkUser() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Map request=(Map) ActionContext.getContext().get("request");
		if (role.equals("users")) {
			Users user1=usersService.checkUser(users);
			if (user1!=null) {
				session.put("users", user1);
				session.put("role", "users");
				return SUCCESS;
			}else{
				session.put("role", "users");
				request.put("msg", "登录失败，请检查用户名和密码输入是否正确！");
				return ERROR;
			}
		}else if (role.equals("admin")) {
			Admin admin1=usersService.checkAdmin(admin);
			if (admin1!=null) {
				session.put("admin", admin1);
				session.put("role", "admin");
				return SUCCESS;
			}else{
				session.put("role", "admin");
				return ERROR;
			}
		}
		return ERROR;
		
		
	}
	
	public String logOut() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		
		session.remove("users");
		return SUCCESS;
	}
	
	public String updateUserPassword() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Users users1=(Users) session.get("users");
		if (users1.getPassword().equals(pwd1)) {
			
			users1.setPassword(password);
			usersService.addOrUpadateUser(users1);
			session.remove("users");
			//session.remove("cart");
			return SUCCESS;
		}else{
			Map request=(Map)ActionContext.getContext().get("request");
			request.put("msg", "旧密码错误");
		}
		return ERROR;
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
