package com.hcl.emp.testservice;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.google.common.base.Optional;
import com.hcl.emp.bean.EmployeeBean;
import com.hcl.emp.model.Employee;
import com.hcl.emp.repository.EmployeeRepository;
import com.hcl.emp.service.EmployeeServicedImpl;

/**
 * @author laxman
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class TestService {

	@InjectMocks
	private EmployeeServicedImpl employeeService;

	@Mock
	EmployeeBean emBean;

	@Mock
	Employee employee;

	@Mock
	private EmployeeRepository empRepo;

	/**
	 * return
	 */
	@Test
	public void createEmployee() {

		String expectedMessage = "Employee created successfully";
		Mockito.when(empRepo.save(Mockito.anyObject())).thenReturn(employee);
		String actualMessage = employeeService.createEmployee(emBean);
		assertEquals(actualMessage, expectedMessage);
	}

	@Test
	public void getEmployee() {
		List<Employee> expectedEmpList = new ArrayList<>();
		Employee empBean = new Employee(1, "Sharath", 20, "SE", "IT", "Shrath@hcl.com", "909084857", "Blore",
				"Donahalli");
		expectedEmpList.add(empBean);
		Mockito.when(empRepo.findAll()).thenReturn(expectedEmpList);
		Object actualEmpList = employeeService.getAllEmployee();
		assertEquals(expectedEmpList, actualEmpList);
	}

	@Test
	public void deleteEmployee() {
		Employee employee = new Employee(1, "Laxman", 20, "SE", "IT", "Shrath@hcl.com", "909084857", "Blore", "Donahalli");
		String expectedMessage = "deleted Successfully";
//		Mockito.when(empRepo.deleteById(employee.getEmpId())).thenReturn(employee);
//		Mockito.when(empRepo.deleteById(1L)).thenReturn(employee);
		String actualMessage = employeeService.deleteEmployee(employee.getEmpId());
		assertEquals(actualMessage, expectedMessage);
	}
	
	
	@Test
	public void getEmployeeId()
	{
		/*
		 * Optional<Employee> employee = new Employee(); EmployeeBean empBean = new
		 * EmployeeBean(); Mockito.when(empRepo.findById((long)
		 * Mockito.anyInt())).thenReturn(empBean); Object actualEmpList =
		 * employeeService.getEmployeById(empBean.getEmpId());
		 * assertEquals(expectedEmpList, actualEmpList);
		 */
		Employee employee = new Employee(1, "Laxman", 20, "SE", "IT", "Shrath@hcl.com", "909084857", "Blore", "Donahalli");
		
		Mockito.when(empRepo.getOne(1L)).thenReturn(employee);
		
		EmployeeBean empBean = (EmployeeBean) employeeService.getEmployeById(1L);
		
		org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
		Employee emp = mapper.map(empBean, Employee.class);
		
		assertEquals(employee, emp);
		
		
	}
}
