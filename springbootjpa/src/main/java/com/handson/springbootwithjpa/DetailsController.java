package com.handson.springbootwithjpa;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;

@Controller
public class DetailsController {

	@Autowired
	CustomerRepository custRepo;

	public void persistanceRepoCall() {

		/*
		 * Using Spring data CRUD Operations using CRUD Repository default methods
		 * 
		 */
		Customer customer = new Customer("Taylor", 94086);

		Customer customer1 = new Customer("Taylor10", 11122);
		Customer customer2 = new Customer("Taylor4", 43212);
		Customer customer3 = new Customer("Taylor3", 87800);
		Customer customer4 = new Customer("Taylor2", 94086);
		List<Customer> customerList = new ArrayList<>();
		customerList.add(customer1);
		customerList.add(customer2);
		customerList.add(customer3);
		customerList.add(customer4);

		custRepo.save(customer);
		custRepo.saveAll(customerList);
		custRepo.delete(customer2);

		// Exception scenario

		/*
		 * Caused by: java.lang.IllegalArgumentException: Failed to create query for
		 * method public abstract java.util.List
		 * com.handson.springbootwithjpa.CustomerRepository.findByCode(int)! No property
		 * code found for type Customer!
		 * 
		 * List<Customer> selectedCustomer = custRepo.findByCode(94086);
		 * 
		 */

		// Create query methods using 'findby'
		List<Customer> selectedCustomer = custRepo.findByZipCode(94086);
		System.out.println(selectedCustomer);

		// Native Query using @Query
		Customer selectedCustomerByCode = custRepo.findByNativeQueryCode(87800);
		System.out.println(selectedCustomerByCode);

		// NamedQuery
		Customer findBynamedQueryBySearchStrObj = custRepo.namedQueryBySearchStr("4");
		System.out.println(findBynamedQueryBySearchStrObj);

		// Sorting
		List<Customer> sortedCustomers = custRepo.findAll(new Sort(Sort.Direction.ASC, "zipCode"));
		System.out.println(sortedCustomers);

		/*
		 * Pagination
		 * 
		 * select * from customer order by CUST_NAME desc limit ? offset ?
		 * 
		 * Limit - how many result set
		 * 
		 * Offset - How many result set to be skipped : 3 means first 3 will be skipped
		 * and starts from 4th
		 * 
		 */
		custRepo.findUsersWithPagination(new PageRequest(1, 2, new Sort(Sort.Direction.DESC, "CUST_NAME")));

	}

}
