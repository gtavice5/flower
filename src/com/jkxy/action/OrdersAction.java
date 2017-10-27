package com.jkxy.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import com.jkxy.model.Orders;
import com.jkxy.model.OrdersDetails;
import com.jkxy.model.Users;
import com.jkxy.service.IOrdersService;
import com.jkxy.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class OrdersAction extends ActionSupport{
	private IOrdersService ordersService;
	
	

	public IOrdersService getOrdersService() {
		return ordersService;
	}



	public void setOrdersService(IOrdersService ordersService) {
		this.ordersService = ordersService;
	}



	@SuppressWarnings("unchecked")
	public String checkOut() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		Cart cart=(Cart)session.get("cart");
		Users users=(Users)session.get("users");
		if(users==null){
			return ERROR;
		}
		Orders orders=new Orders();
		orders.setCreateTime(new Timestamp(new Date().getTime()));
		orders.setUsers(users);
		orders.setSum(cart.getTotalPrice());
		orders.setNum(cart.getTotalNum());
		for (Iterator iterator = cart.getItems().values().iterator(); iterator.hasNext();) {
			OrdersDetails ordersDetails=(OrdersDetails) iterator.next();
			orders.getOrdersDetailsSet().add(ordersDetails);
			ordersDetails.setOrders(orders);
			
		}
		ordersService.saveOrder(orders);
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("orders", orders);
		session.remove("cart");
		return SUCCESS;
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
