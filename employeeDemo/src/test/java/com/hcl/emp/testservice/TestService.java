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
	public void getEmployeeId()	{
		long id=(long) 12345;
		Employee employee =  new Employee();
		employee.setEmpId(id);
		Mockito.when(empRepo.getOne(Mockito.anyLong())).thenReturn(employee);
		EmployeeBean empBean = (EmployeeBean) employeeService.getEmployeById(employee.getEmpId());
		assertEquals(12345L, empBean.getEmpId());
	}
	
//	@Test
//	public void testDeletById() {
//		EmployeeBean emBean = new EmployeeBean(12L, "Amit", 20, "Manager", "Marketing", "amit@hcl.com", "907890909", "Blore", "Blore");
//		Mockito.when(empRepo.)
//	}
}
