package com.spring.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.spring.employee.model.Employee;

@Service
public class EmployeeServiceImp implements EmployeeService {

	@Override
	public Employee createEmployee(Employee employee) {
		
		getListOfEmployee().add(employee);
		
		return employee;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		
		Optional<Employee> optionalEmployee = getListOfEmployee()
				.stream()
				.filter(s->s.getEmployeeId().equals(employeeId))
				.findFirst();
		
		return optionalEmployee
				.map(employee->{return employee;})
				.orElse(null);
	}
	
	
	public static List<Employee> getListOfEmployee(){
		
		List<Employee> list  = new ArrayList<Employee>();
		list.add(new Employee(new Long(1), "Pankaj Singh", "Patna"));
		list.add(new Employee(new Long(2), "Pankaj Singh", "Patna"));
		list.add(new Employee(new Long(3), "Pankaj Singh", "Patna"));
		
		return list;
	}

}
