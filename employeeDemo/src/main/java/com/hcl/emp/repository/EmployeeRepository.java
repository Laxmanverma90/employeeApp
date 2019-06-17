package com.hcl.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.emp.model.Employee;

/**
 * @author Sharath
 *
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	

}
