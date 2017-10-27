package com.jkxy.model;

import java.util.Set;

//商品分类表Category
public class Category {

	private int id;//分类ID
	private String categoryName;//商品分类名称
	private Set goodsSet;//一对多 categoryId
	
	public Category() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	

	public Set getGoodsSet() {
		return goodsSet;
	}

	public void setGoodsSet(Set goodsSet) {
		this.goodsSet = goodsSet;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}
	
	
}
