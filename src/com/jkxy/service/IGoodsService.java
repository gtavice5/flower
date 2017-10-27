package com.jkxy.service;

import java.util.List;

import com.jkxy.model.Goods;

public interface IGoodsService {
	public List getNewGoods();
	public List getGoodsByCategoryIdPaging(int categoryId,int currentPage,int pageSize);
	public int getTotalByCategory(int categoryId);
	public Goods getGoodsById(int id);
	public boolean addOrUpdateGoods(Goods goods);
	public List getAllGoods();
	public boolean deleteGoodsById(int id);
	public List goodsAdvancedQuery(int categoryId, String goodsName,String description,float higher,float lower);
}
