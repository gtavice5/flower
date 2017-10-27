package com.jkxy.action;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.jkxy.model.Category;
import com.jkxy.model.Goods;
import com.jkxy.service.ICategoryService;
import com.jkxy.service.IGoodsService;
import com.jkxy.util.Pager;
import com.jkxy.util.uploadzp;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class GoodsAction extends ActionSupport {
	private ICategoryService categoryService;
	private IGoodsService goodsService;
	private int categoryId=0;
	private int currentPage = 1;
	private Goods goods;
	private String picture;
	// 要求是File类型名字和前端控件upload一样
	private File upload;
	// 要求是前端控件的名字upload加上固定的FileName来命名
	private String uploadFileName;
	//商品的id
	private int goodsId;
	//高级查询
	private String goodsName="";
	private String description="";
	private float higher=0;
	private float lower=0;
	
	

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

	public float getHigher() {
		return higher;
	}

	public void setHigher(float higher) {
		this.higher = higher;
	}

	public float getLower() {
		return lower;
	}

	public void setLower(float lower) {
		this.lower = lower;
	}

	public ICategoryService getCategoryService() {
		return categoryService;
	}

	public void setCategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public IGoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(IGoodsService goodsService) {
		this.goodsService = goodsService;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public int getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(int goodsId) {
		this.goodsId = goodsId;
	}

	public ICategoryService getcategoryService() {
		return categoryService;
	}

	public void setcategoryService(ICategoryService categoryService) {
		this.categoryService = categoryService;
	}

	public int getcategoryId() {
		return categoryId;
	}

	public void setcategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public File getUpload() {
		return upload;
	}

	public void setUpload(File upload) {
		this.upload = upload;
	}

	public String getUploadFileName() {
		return uploadFileName;
	}

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}


	public String browseCategory() throws Exception {

		List categorys = categoryService.getAllCategorys();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("categorys", categorys);
		return SUCCESS;

	}

	@SuppressWarnings("unchecked")
	public String browseNewGoods() throws Exception {

		@SuppressWarnings("rawtypes")
		List newGoodsList = goodsService.getNewGoods();
		@SuppressWarnings("rawtypes")
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("newGoodsList", newGoodsList);
		return SUCCESS;

	}

	public String browseGoodsPaging() throws Exception {
		int totalSize = goodsService.getTotalByCategory(categoryId);
		Pager page = new Pager(currentPage, totalSize);
		List goodsList = goodsService.getGoodsByCategoryIdPaging(categoryId, currentPage, page.getPageSize());
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		request.put("page", page);
		return SUCCESS;

	}
	
	//去高级查询页面
	public String toAdvancedQuery() throws Exception {
		List categorys=categoryService.getAllCategorys();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("categorys", categorys);
		return SUCCESS;

	}
	
	//高级查询
	public String goodsAdvancedQuery() throws Exception {
		@SuppressWarnings("rawtypes")
		List goodsList=goodsService.goodsAdvancedQuery( categoryId,goodsName, description, higher, lower);
		@SuppressWarnings("rawtypes")
		Map request=(Map)ActionContext.getContext().get("request");
		if (!goodsList.isEmpty()) {
			request.put("goodsList", goodsList);
		}else{
			request.put("tipMessage", "没有查询到相关商品！");
		}
		return SUCCESS;

	}
	
	@SuppressWarnings("unchecked")
	public String browseAllGoodsPaging() throws Exception{
		@SuppressWarnings("rawtypes")
		List goodsList=goodsService.getAllGoods();
		@SuppressWarnings("rawtypes")
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("goodsList", goodsList);
		return SUCCESS;
	}
	

	public String addOrUpdateGoods() throws Exception {
		String path = ServletActionContext.getServletContext().getRealPath("/pic");
		System.out.println(path);
		List list = goodsService.getNewGoods();
		Goods goods1 = (Goods) list.get(0);
		int currentGoodsId = goods1.getId() + 1;
		path = path + "\\" + currentGoodsId + this.uploadFileName;
		new uploadzp().upload(this.getUpload(), path);
		goods.setImgUrl(currentGoodsId + this.getUploadFileName());
		Goods goods2 = new Goods();
		goods2.setCategory(goods.getCategory());
		goods2.setGoodsName(goods.getGoodsName());
		if (goods.getImgUrl() == null) {
			goods2.setImgUrl(picture);
		} else {
			goods2.setImgUrl(goods.getImgUrl());
		}
		goods2.setPrice(goods.getPrice());
		goods2.setId(goods.getId());
		goods2.setDescription(goods.getDescription());
		if (goodsService.addOrUpdateGoods(goods2)) {
			return SUCCESS;
		} else {
			return ERROR;
		}

	}
	
	public String displayOneGoods() throws Exception{
		Goods modifyGoods=goodsService.getGoodsById(goodsId);
		System.out.println("modify");
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("goods", modifyGoods);
		return SUCCESS;
	}
	
	@SuppressWarnings("unchecked")
	public String showOneGoods() throws Exception{
		Goods showGoods=goodsService.getGoodsById(goodsId);
		System.out.println("show");
		@SuppressWarnings("rawtypes")
		Map request=(Map)ActionContext.getContext().get("request");
		request.put("goods", showGoods);
		return SUCCESS;
	}
	
	public String deleteOneGoods() throws Exception{
		goodsService.deleteGoodsById(goodsId);
		System.out.println("delete");
		return SUCCESS;
	}
	
	
	
	
	
	

}
