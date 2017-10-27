package com.jkxy.model;

import java.math.BigDecimal;

//商品表goods
public class Goods {
	
	private int id;//商品ID
	private String goodsName;//商品名称
	private String description;//商品描述说明
	private BigDecimal price;//商品价格
	//商品分类（商品分类表外键ID categoryId）
	private Category category;
	private String imgUrl;//商品图片地址
	
	public Goods() {
		
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Goods [id=" + id + ", goodsName=" + goodsName + ", description=" + description + ", price=" + price
				+ ", category=" + category + ", imgUrl=" + imgUrl + "]";
	}

	

	
	
	
}
