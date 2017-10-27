package com.jkxy.tool;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.jkxy.model.OrdersDetails;

public class Cart {
private Map items;

public Map getItems() {
	return items;
}

public void setItems(Map items) {
	this.items = items;
}

public Cart() {
	
	if(items==null){
		items=new HashMap<Integer, OrdersDetails>();
	}
}

public void addGoods(String name,OrdersDetails ordersDetails){
	if(items.containsKey(name)){
		OrdersDetails _ordersDetails=(OrdersDetails) items.get(name);
		ordersDetails.setNum(_ordersDetails.getNum()+ordersDetails.getNum());
		items.put(name, ordersDetails);
	}else{
		items.put(name, ordersDetails);
	}
}

public void updateCart(String name,int num){
	OrdersDetails ordersDetails=(OrdersDetails) items.get(name);
	ordersDetails.setNum(num);
	items.put(name, ordersDetails);
}

public BigDecimal getTotalPrice(){
	BigDecimal totalPrice=new BigDecimal(0);
	for (Iterator iterator = items.values().iterator(); iterator.hasNext();) {
		OrdersDetails ordersDetails = (OrdersDetails) iterator.next();
		totalPrice=totalPrice.add(
				ordersDetails.getPrice().multiply(new BigDecimal(ordersDetails.getNum())));
		
	}
	return totalPrice;
}

public int getTotalNum(){
	int totalNum=0;
	for (Iterator iterator = items.values().iterator(); iterator.hasNext();) {
		OrdersDetails ordersDetails = (OrdersDetails) iterator.next();
		totalNum+=ordersDetails.getNum();
		
	}
	return totalNum;
}














}
