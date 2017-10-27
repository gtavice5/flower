package com.jkxy.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

//订单表orders
public class Orders implements Serializable{

	private Integer ordersId;//订单ID
	//用户名（用户表 username）
	private Users users;
	private int num;//商品总数量
	private BigDecimal sum;//总金额
	private Timestamp createTime;//下单时间
	private Set ordersDetailsSet=new HashSet<>();//一对多  ordersId
	
	public Orders() {
		
	}
	
	

	public Set getOrdersDetailsSet() {
		return ordersDetailsSet;
	}



	public void setOrdersDetailsSet(Set ordersDetailsSet) {
		this.ordersDetailsSet = ordersDetailsSet;
	}



	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public BigDecimal getSum() {
		return sum;
	}

	public void setSum(BigDecimal sum) {
		this.sum = sum;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	@Override
	public String toString() {
		return "Orders [ordersId=" + ordersId + ", users=" + users + ", num=" + num + ", sum=" + sum + ", createTime="
				+ createTime + "]";
	}

	

	
	
	
}
