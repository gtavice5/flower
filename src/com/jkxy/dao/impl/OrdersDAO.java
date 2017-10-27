package com.jkxy.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IOrdersDAO;
import com.jkxy.model.Orders;

public class OrdersDAO implements IOrdersDAO {
	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}



	@Override
	public Orders saveOrder(Orders order) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.save(order);
		ts.commit();
		session.close();
		return order;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
