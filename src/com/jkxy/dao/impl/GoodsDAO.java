package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IGoodsDAO;
import com.jkxy.model.Goods;

public class GoodsDAO implements IGoodsDAO {
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public List getNewGoods() {
		
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods order by id desc");
		query.setFirstResult(0);
		query.setMaxResults(4);
		List Goodss=query.list();
		ts.commit();
		session.close();
		
		return Goodss;
	}



	@Override
	public List getGoodsByCategoryIdPaging(int categoryId, int currentPage, int pageSize) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods where categoryid="+categoryId);
		int startRow=(currentPage-1)*pageSize;
		query.setFirstResult(startRow);
		query.setMaxResults(pageSize);
		List goodsList=query.list();
		ts.commit();
		session.close();
		return goodsList;
	}



	@Override
	public int getTotalByCategory(int categoryid) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods where categoryid="+categoryid);
		List Goodss=query.list();
		ts.commit();
		session.close();
		return Goodss.size();
	}



	@Override
	public List getAllGoods() {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods order by categoryid desc");
		List Goodss=query.list();
		
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return Goodss;
	}



	@Override
	public boolean deleteGoodsById(int id) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods where id="+id);
		List Goodss=query.list();
		session.delete((Goods) Goodss.get(0));
		ts.commit();
		session.close();
		return true;
	}



	@Override
	public Goods getGoodsById(int id) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Goods where id="+id);
		List Goodss=query.list();
		ts.commit();
		session.close();
		return (Goods) Goodss.get(0);
	}



	@Override
	public boolean addOrUpdateGoods(Goods goods) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(goods);
		
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return true;
	}



	@Override
	public List goodsAdvancedQuery(int categoryId, String goodsName,String description,float higher,float lower) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		String sql="from Goods where 1=1 ";
		if (!goodsName.equals("")) {
			sql+="and goodsName like '%"+goodsName+"%' ";
		}else if (!description.equals("")) {
			sql+="and description like '%"+description+"%' ";
		}else if (higher!=0) {
			sql+="and price >"+higher;
		}else if (lower!=0) {
			sql+="and price <"+lower;
		}else if (categoryId!=0) {
			sql+="and category.id="+categoryId;
		}
		Query query=session.createQuery(sql);
		List Goodss=query.list();
		
		session.flush();
		session.clear();
		ts.commit();
		session.close();
		return Goodss;
	}

	
	
	
	
	
	
	
	
	
}
