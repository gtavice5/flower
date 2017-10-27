package com.jkxy.model;

import java.math.BigDecimal;

//订单详情表ordersDetails
public class OrdersDetails {

	private int id;//主键ID
	//订单ID（外键，订单表 ordersId)
	private Orders orders;
	private String goodsName;//商品名称
	private BigDecimal Price;//商品单价
	private int num;//商品数量
	
	public OrdersDetails() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public BigDecimal getPrice() {
		return Price;
	}

	public void setPrice(BigDecimal price) {
		Price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "OrdersDetails [id=" + id + ", orders=" + orders + ", goodsName=" + goodsName + ", Price=" + Price
				+ ", num=" + num + "]";
	}

	
	
	
}
