package com.exaple.springboot.swagger.bean;

public class Student {

	private String name;
	private int studentId;
	private String contactNumber;

	public Student(String name, int studentId, String contactNumber) {
		super();
		this.name = name;
		this.studentId = studentId;
		this.contactNumber = contactNumber;
	}

	public String getName() {
		return name;
	}

	public Student() {
		super();
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

}
