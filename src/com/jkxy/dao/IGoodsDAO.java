package com.jkxy.dao;

import java.util.List;

import com.jkxy.model.Goods;

public interface IGoodsDAO {

	public List getAllGoods();
	public List getNewGoods();
	public List getGoodsByCategoryIdPaging(int categoryId,int currentPage,int pageSize);
	public int getTotalByCategory(int categoryId);
	public boolean deleteGoodsById(int id);
	public Goods getGoodsById(int id);
	public boolean addOrUpdateGoods(Goods goods);
	public List goodsAdvancedQuery(int categoryId, String goodsName,String description,float higher,float lower);
}
