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
	private EmployeeServicedImpl empRepositoryImpl;
	
	@InjectMocks
	private EmployeeController empController;

	@Test
	public void testCreateUser() {
		EmployeeBean empBean = new EmployeeBean(1, "Laxman", 26, "Dev", "IT", "laxman", "9045678990", "Blore", "HCL Blore"); 
		
	}
}
