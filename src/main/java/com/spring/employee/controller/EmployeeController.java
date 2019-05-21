package com.spring.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(path = "/registration", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		Employee  empResp = employeeService.createEmployee(employee);
		return new ResponseEntity<Employee>(empResp, HttpStatus. CREATED);
	}
	
	@GetMapping(path = "/details/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long employeeId){
		return new ResponseEntity<Employee>(employeeService.getEmployee(employeeId), HttpStatus.OK);
	}

}
