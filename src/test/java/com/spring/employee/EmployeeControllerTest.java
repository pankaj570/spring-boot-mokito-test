package com.spring.employee;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.employee.controller.EmployeeController;
import com.spring.employee.model.Employee;
import com.spring.employee.service.EmployeeServiceImp;

@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeServiceImp employeeService;

	@Test
	public void testcreateEmployee() throws Exception {
		Employee employee = new Employee(new Long(5), "Manish Patel", "Bikramganj");
		
		when(this.employeeService.createEmployee(any(Employee.class))).thenReturn(employee);

		mockMvc.perform(post("/employees/registration")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(asJsonString(employee)))
		.andDo(print())
		.andExpect(status().isCreated())
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeName").value("Manish Patel"));
	}
	
	@Test
	public void testgetEmployee() throws Exception {
		Employee employee = new Employee(new Long(5), "Manish Patel", "Bikramganj");
		
		when(this.employeeService.getEmployee(any(Long.class))).thenReturn(employee);

		mockMvc.perform(get("/employees/details/{id}",1)
				.accept(MediaType.APPLICATION_JSON))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").exists())
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeId").value(5))
		.andExpect(MockMvcResultMatchers.jsonPath("$.employeeName").value("Manish Patel"));
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
}