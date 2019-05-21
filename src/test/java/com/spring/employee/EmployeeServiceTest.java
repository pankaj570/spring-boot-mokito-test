package com.spring.employee;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	@Autowired
	private EmployeeService employeeService;
	
	@Before
	public void beforeTest() {
		
	}
	
	@Test
	public void registerEmployeeTest() {
		Employee employee = new Employee(new Long(5), "Manish Patel", "Bikramganj");
		Employee empResp = employeeService.createEmployee(employee);
		Assert.assertNotNull(empResp);
		Assert.assertEquals(employee.getEmployeeId(), empResp.getEmployeeId());
		Assert.assertEquals(employee.getEmployeeName(), empResp.getEmployeeName());
		Assert.assertEquals(employee.getAddress(), empResp.getAddress());
		
	}

}
				







