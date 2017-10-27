package com.jkxy.action;

import java.util.Map;

import com.jkxy.model.Goods;
import com.jkxy.model.OrdersDetails;
import com.jkxy.service.IGoodsService;
import com.jkxy.tool.Cart;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ShoppingAction extends ActionSupport {
	private int id;
	private String goodsName;
	private int num;
	private IGoodsService goodsService;

	
	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public String addToCart() throws Exception {
		Goods goods=goodsService.getGoodsById(id);
		OrdersDetails ordersDetails=new OrdersDetails();
		ordersDetails.setGoodsName(goods.getGoodsName());
		ordersDetails.setPrice(goods.getPrice());
		ordersDetails.setNum(num);
		Map session=(Map)ActionContext.getContext().getSession();
		
		Cart cart=(Cart) session.get("cart");
		if (cart==null) {
			cart=new Cart();
		}
//		cart.addGoods(id, ordersDetails);
		cart.addGoods(ordersDetails.getGoodsName(), ordersDetails);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	public String updateCart() throws Exception{
		Map session=(Map)ActionContext.getContext().getSession();
		
		Cart cart=(Cart) session.get("cart");
		cart.updateCart(goodsName, num);
		session.put("cart", cart);
		return SUCCESS;
	}
	
	
	
	
	
	
	
	

}
