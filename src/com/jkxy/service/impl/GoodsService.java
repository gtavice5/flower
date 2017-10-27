package com.jkxy.service.impl;

import java.util.List;

import com.jkxy.dao.IGoodsDAO;
import com.jkxy.model.Goods;
import com.jkxy.service.IGoodsService;

public class GoodsService implements IGoodsService {

	private IGoodsDAO goodsDAO;
	
	


	public IGoodsDAO getGoodsDAO() {
		return goodsDAO;
	}


	public void setGoodsDAO(IGoodsDAO goodsDAO) {
		this.goodsDAO = goodsDAO;
	}


	@Override
	public List getNewGoods() {
		return goodsDAO.getNewGoods();
	}


	@Override
	public List getGoodsByCategoryIdPaging(int categoryId, int currentPage, int pageSize) {
		return goodsDAO.getGoodsByCategoryIdPaging(categoryId, currentPage, pageSize);
	}


	@Override
	public int getTotalByCategory(int categoryId) {
		return goodsDAO.getTotalByCategory(categoryId);
	}


	@Override
	public Goods getGoodsById(int id) {
		return goodsDAO.getGoodsById(id);
	}


	@Override
	public boolean addOrUpdateGoods(Goods goods) {
		return goodsDAO.addOrUpdateGoods(goods);
	}


	@Override
	public List getAllGoods() {
		return goodsDAO.getAllGoods();
	}


	@Override
	public boolean deleteGoodsById(int id) {
		return goodsDAO.deleteGoodsById(id);
	}


	@Override
	public List goodsAdvancedQuery(int categoryId, String goodsName,String description,float higher,float lower) {
		return goodsDAO.goodsAdvancedQuery(categoryId, goodsName, description, higher, lower);
	}

}
