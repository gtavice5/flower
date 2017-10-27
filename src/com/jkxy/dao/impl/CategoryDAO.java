package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.ICategoryDAO;

public class CategoryDAO implements ICategoryDAO {
	private SessionFactory mySessionFactory;
	
	


	public SessionFactory getMySessionFactory() {
		return mySessionFactory;
	}




	public void setMySessionFactory(SessionFactory mySessionFactory) {
		this.mySessionFactory = mySessionFactory;
	}




	@Override
	public List getAllCategorys() {
		Session session=mySessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Category");
		List categorys=query.list();
		ts.commit();
		session.close();
		return categorys;
	}
	
	
	
	
	
	
	
	

}
