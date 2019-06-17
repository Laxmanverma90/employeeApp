package com.hcl.emp.testController;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.emp.bean.EmployeeBean;
import com.hcl.emp.controller.EmployeeController;
import com.hcl.emp.model.Employee;
import com.hcl.emp.repository.EmployeeRepository;
import com.hcl.emp.service.EmployeeServicedImpl;

@RunWith(MockitoJUnitRunner.class)
public class TestController {
	
	@Mock
	private EmployeeRepository empRepository;
	
	@InjectMocks
	private EmployeeController empController;
	
	@Mock
	private Employee employee;
	
	@Mock
	private EmployeeBean empBean;
	
	@Test
	public void createEmployee() {
		String actualMessage = "Employee created successfully";
		Mockito.when(empRepository.save(Mockito.anyObject())).thenReturn(Mockito.anyString());
		String expectedMessage=empController.createEmployee(empBean);
		assertEquals(actualMessage, expectedMessage);
	}

}
