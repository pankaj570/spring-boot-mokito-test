package com.spring.employee.model;

public class Employee {

	private Long employeeId;
	private String employeeName;
	private String address;

	public Employee() {
		super();
	}

	public Employee(Long employeeId, String employeeName, String address) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.address = address;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
