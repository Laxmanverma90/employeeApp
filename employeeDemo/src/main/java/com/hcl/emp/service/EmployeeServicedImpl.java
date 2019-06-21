package com.hcl.emp.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.emp.bean.EmployeeBean;
import com.hcl.emp.model.Employee;
import com.hcl.emp.repository.EmployeeRepository;

/**
 * @author Laxman/Sharath
 *
 */
@Service
public class EmployeeServicedImpl implements EmployeeService {
	
	private static final Logger logger = LogManager.getLogger(EmployeeServicedImpl.class);
	
	@Autowired
	private EmployeeRepository empRepo;
	
	/**
	 * @param EmployeeBean
	 * return String
	 */
	@Override
	public String createEmployee(EmployeeBean employeeBean) {
		
		logger.info("EmployeeBean :: started");
		String message = null;
		org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
		Employee employee = mapper.map(employeeBean, Employee.class);
		if(empRepo.save(employee)!=null) {
			message = "Employee created successfully";
		} else {
			message = "Failed to create Employee";
		}
		logger.info("EmployeeBean :: end");
		return message;
	}
	
	/**
	 * return Object
	 */
	@Override
	public List<EmployeeBean> getAllEmployee() {
		EmployeeBean empBean = new EmployeeBean();
		List<EmployeeBean> empBeanList = new ArrayList<>();
		List<Employee> empList = new ArrayList<>();
		try {
			empList = empRepo.findAll();
			for(int i=0; i<empList.size(); i++) {
				BeanUtils.copyProperties(empBean, empList.get(i));
				empBeanList.add(empBean);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return empBeanList;
	}

	/**
	 * @param empId
	 * return Object
	 */
	@Override
	public Object getEmployeById(long empId) {
		
		org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
		Object returnObject = null;
		try {
			 Employee employee = empRepo.getOne(empId);
			if( employee != null ) {
				EmployeeBean empBean = mapper.map(employee, EmployeeBean.class);
				returnObject = empBean;
			} else {
				returnObject = "Sorry! No record found !";
			}
		} catch (EntityNotFoundException e) {
			returnObject = "Sorry! No record found !";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return returnObject;
	}

	/**
	 * @param EmployeeBean
	 * return String
	 */
	@Override
	public String updateEmployee(EmployeeBean employeeBean) {
		String message = null;
		org.modelmapper.ModelMapper mapper = new org.modelmapper.ModelMapper();
		if(employeeBean != null) {
			Employee employee = mapper.map(employeeBean, Employee.class);
			if(empRepo.save(employee)!=null) {
				message = "Employee "+employeeBean.getEmpId()+" updated successfully";
			} else {
				message = "Failed to update Employee";
			}
		}
		return message;
	}

	/**
	 * @param empId
	 * return String
	 */
	@Override
	public String deleteEmployee(long empId) {
		
		String returnString = null;
		try {
			empRepo.deleteById(empId);
			returnString = "deleted Successfully";
		} catch (Exception e) {
			e.printStackTrace();
			returnString = "Went sonthing wrong.";
		}
		return returnString;
	}
}