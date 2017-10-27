package com.jkxy.service.impl;

import com.jkxy.dao.IOrdersDAO;
import com.jkxy.model.Orders;
import com.jkxy.service.IOrdersService;

public class OrdersService implements IOrdersService {
	private IOrdersDAO ordersDAO;
	
	
	
	public IOrdersDAO getOrdersDAO() {
		return ordersDAO;
	}



	public void setOrdersDAO(IOrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}



	@Override
	public Orders saveOrder(Orders order) {
		return ordersDAO.saveOrder(order);
	}

}
