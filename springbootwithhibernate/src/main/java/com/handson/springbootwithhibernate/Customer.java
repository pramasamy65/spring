package com.handson.springbootwithhibernate;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;

@Entity
public class Customer {

	@Id
	@Column(name = "CUSTOMER_ID")
	private int customerId;
	@Column(name = "CUST_NAME")
	private String customerName;
	@Column(name = "ZIP_CODE")
	private int zipCode;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "accountNumber", column = @Column(name = "ACCOUNT_NUMBER")),
			@AttributeOverride(name = "accountType", column = @Column(name = "ACCOUNT_TYPE")),
			@AttributeOverride(name = "balance", column = @Column(name = "BALANCE")) })
	private Account account;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Customer() {

	}

	public Customer(int customerId, String customerName, int zipCode, Account account) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.zipCode = zipCode;
		this.account = account;
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

}
