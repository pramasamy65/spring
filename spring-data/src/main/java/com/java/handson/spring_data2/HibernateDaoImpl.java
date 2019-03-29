package com.java.handson.spring_data2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;

	public void getCount() {

		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Student student = (Student) session.get(Student.class, 5);

		System.out.println(student);
		transaction.commit();
		session.close();

	}

}
