package com.handson.hibernate.onetoone;

import javax.persistence.Embeddable;

@Embeddable
public class Account {

	private int accountNumber;
	private String accountType;
	private String balance;

	public int getAccountNumber() {
		return accountNumber;
	}

	public Account() {

	}

	public Account(int accountNumber, String accountType, String balance) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
		this.balance = balance;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

}
