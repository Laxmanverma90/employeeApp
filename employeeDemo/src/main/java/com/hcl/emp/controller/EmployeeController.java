package com.hcl.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.emp.bean.EmployeeBean;
import com.hcl.emp.pojo.EmployeePojo;
import com.hcl.emp.service.EmployeeService;

/**
 * @author Laxman/Sharath
 *
 */
@RestController
@RequestMapping("/rest")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	/**
	 * @param employeeBean
	 * @return String
	 */
	@PostMapping("/employee")
	public ResponseEntity<String> createEmployee(@RequestBody EmployeeBean employeeBean) {
		String successMessage = employeeService.createEmployee(employeeBean);
		return new ResponseEntity<>(successMessage, HttpStatus.CREATED);
	}

	/**
	 * @return Object
	 */
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeBean>> getEmployee() {
		List<EmployeeBean> empBeanList = (List<EmployeeBean>) employeeService.getAllEmployee();
		return new ResponseEntity<>(empBeanList, HttpStatus.OK);
	}

	/**
	 * @param empId
	 * @return Object
	 */
	@GetMapping("/employee/{empId}")
	public Object getByEmployeeId(@PathVariable("empId") long empId) {
		return employeeService.getEmployeById(empId);
	}

	/**
	 * @param empId
	 * @return String
	 */
	@DeleteMapping("/employee/{empId}")
	public String getDeleteById(@PathVariable("empId") long empId) {
		return employeeService.deleteEmployee(empId);
	}

	/**
	 * @param employeeBean
	 * @return String
	 */
	@PutMapping("/employee")
	public String updateEmployee(@RequestBody EmployeeBean employeeBean) {
		return employeeService.updateEmployee(employeeBean);
	}
}