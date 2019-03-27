package com.java.handson.spring_data2;

import org.hibernate.SessionFactory;

public class HibernateDaoImpl {
	
	private SessionFactory sessionFactory;
	
	public void getCount() {
		//System.out.println(getJdbcTemplate().queryForInt("select count(*) from test"));
	}

}
