package com.spring.employee.service;

import com.spring.employee.model.Employee;

public interface EmployeeService {
	
	public Employee createEmployee(Employee employee);
	public Employee getEmployee(Long employeeId);

}
