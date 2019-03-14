package com.handson.springbootwithjpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * should contains entity related stuffs and not DB table Related Stuffs
 * 
 * @author prakash
 *
 */
@Entity
@Table(name = "CUSTOMER")
@NamedQuery(name = "Customer.namedQueryBySearchStr", query = "select c from Customer c where c.customerName like '%:name%'")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private int customerId;
	@Column(name = "CUST_NAME")
	private String customerName;
	@Column(name = "ZIP_CODE")
	private int zipCode;

	public Customer() {

	}

	public Customer(String customerName, int zipCode) {
		super();
		this.customerName = customerName;
		this.zipCode = zipCode;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getZipCode() {
		return zipCode;
	}

	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}

	public String toString() {
		return "{ Name : " + customerName + ", Zip Code : " + zipCode + " }";

	}

}
