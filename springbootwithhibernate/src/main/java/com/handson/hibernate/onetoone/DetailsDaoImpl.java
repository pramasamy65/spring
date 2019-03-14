package com.handson.hibernate.onetoone;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class DetailsDaoImpl {

	@Autowired
	HibernateTransactionManager man;

	public void saveCustomerDetails(Customer customerDetails) {
		Session session = man.getSessionFactory().getCurrentSession();
		System.out.println("@@@@@ " + customerDetails.getCustomerName());
		session.save(customerDetails);
	}

	public Customer getCustomerDetails(int id) {
		Session session = man.getSessionFactory().getCurrentSession();
		Customer customerDetails = session.get(Customer.class, id);
		return customerDetails;
	}
}
