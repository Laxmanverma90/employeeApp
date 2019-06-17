package com.hcl.emp.service;

import com.hcl.emp.bean.EmployeeBean;

/**
 * @author Laxman
 *
 */
public interface EmployeeService {
	
	public String createEmployee(EmployeeBean employeeBean);
	
	public Object getAllEmployee();
	
	public Object getEmployeById(long empId);
	
	public String updateEmployee(EmployeeBean employeeBean);
	
	public String deleteEmployee(long empId);

}
