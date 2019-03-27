package com.java.handson.spring_data2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import org.hibernate.SessionFactory;

@Repository
public class HibernateDaoImpl {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void getCount() {
	
		org.hibernate.Query query = sessionFactory.openSession().createQuery("select * from student");
		System.out.println(query.uniqueResult());
	}

}
