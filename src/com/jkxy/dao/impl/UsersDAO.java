package com.jkxy.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.jkxy.dao.IUsersDAO;
import com.jkxy.model.Admin;
import com.jkxy.model.Users;

public class UsersDAO implements IUsersDAO {

	private SessionFactory sessionFactory;
	
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}



	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean addOrUpadateUser(Users users) {
		
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		session.saveOrUpdate(users);
		ts.commit();
		session.close();
		return true;
	}



	@Override
	public Users checkUser(Users users) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Users where userName='"+users.getUserName()
		+"' and password='"+users.getPassword()+"'");
		Users user1=new Users();
		List list=query.list();
		ts.commit();
		session.close();
		if(list.size()!=0){
			user1=(Users)list.get(0);
			return user1;
		}
		return null;
	}



	@Override
	public Admin checkAdmin(Admin admin) {
		Session session=sessionFactory.openSession();
		Transaction ts=session.beginTransaction();
		Query query=session.createQuery("from Admin where username='"+admin.getUsername()
		+"' and password='"+admin.getPassword()+"'");
		Admin admin2=new Admin();
		List list=query.list();
		ts.commit();
		session.close();
		if(list.size()!=0){
			admin2=(Admin)list.get(0);
			return admin2;
		}
		return null;
	}


	
 
}
