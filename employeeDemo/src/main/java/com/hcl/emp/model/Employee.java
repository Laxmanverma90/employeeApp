package com.hcl.emp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sharath
 *
 */
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private long empId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "desigenation")
	private String desigenation;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "phone_no")
	private String phoneNo;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "address")
	private String address;

	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDesigenation() {
		return desigenation;
	}

	public void setDesigenation(String desigenation) {
		this.desigenation = desigenation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Employee() {
	}
	
	public Employee(long empId, String name, int age, String desigenation, String department, String emailId,
			String phoneNo, String city, String address) {
		super();
		this.empId = empId;
		this.name = name;
		this.age = age;
		this.desigenation = desigenation;
		this.department = department;
		this.emailId = emailId;
		this.phoneNo = phoneNo;
		this.city = city;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", age=" + age + ", desigenation=" + desigenation
				+ ", department=" + department + ", emailId=" + emailId + ", phoneNo=" + phoneNo + ", city=" + city
				+ ", address=" + address + "]";
	}
}