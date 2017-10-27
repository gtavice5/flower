package com.jkxy.model;

import java.io.Serializable;
import java.util.Set;

//用户资料表users
public class Users implements Serializable{
	
	private Integer id;//用户ID
	private String userName;//用户名
	private String realName;//真实姓名
	private String password;//密码
	private String pwdQuestion;//密保问题
	private String pwdQuestionAnswer;//密保答案
	private String address;//地址
	private String phoneNO;//电话号码
	private String email;//邮件地址
	private Set ordersSet;//一对多 userName
	
	public Users() {
		
	}
	
	

	public Set getOrdersSet() {
		return ordersSet;
	}



	public void setOrdersSet(Set ordersSet) {
		this.ordersSet = ordersSet;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPwdQuestion() {
		return pwdQuestion;
	}

	public void setPwdQuestion(String pwdQuestion) {
		this.pwdQuestion = pwdQuestion;
	}

	public String getPwdQuestionAnswer() {
		return pwdQuestionAnswer;
	}

	public void setPwdQuestionAnswer(String pwdQuestionAnswer) {
		this.pwdQuestionAnswer = pwdQuestionAnswer;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNO() {
		return phoneNO;
	}

	public void setPhoneNO(String phoneNO) {
		this.phoneNO = phoneNO;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", userName=" + userName + ", realName=" + realName + ", password=" + password
				+ ", pwdQuestion=" + pwdQuestion + ", pwdQuestionAnswer=" + pwdQuestionAnswer + ", address=" + address
				+ ", phoneNO=" + phoneNO + ", email=" + email + "]";
	}

	
	
	
}
