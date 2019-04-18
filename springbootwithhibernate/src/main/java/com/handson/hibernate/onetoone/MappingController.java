package com.handson.hibernate.onetoone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController("customer/details")
public class MappingController {

	@Autowired
	DetailsDaoImpl daoImpl;

	@PostMapping("/account")
	public void saveAccounts(@RequestBody Customer customerDetails) {
		daoImpl.saveCustomerDetails(customerDetails);
	}

	@GetMapping("/account/{id}")
	public Customer saveAccounts(@RequestParam int customerId) {
		return daoImpl.getCustomerDetails(customerId);
	}

}
