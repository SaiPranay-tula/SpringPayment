package com.payment.web.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int employeeid;
	private String employeename;
	private String employeepassword;
	
	
	public Employee() {
		
	}
	public Employee(int employeeid, String employeename, String employeepassword) {
		this.employeeid = employeeid;
		this.employeename = employeename;
		this.employeepassword = employeepassword;
	}
	public int getemployeeid() {
		return employeeid;
	}
	public void setemployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getemployeename() {
		return employeename;
	}
	public void setemployeename(String employeename) {
		this.employeename = employeename;
	}
	public String getemployeepassword() {
		return employeepassword;
	}
	public void setemployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}
	@Override
	public String toString() {
		return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeepassword="
				+ employeepassword + "]";
	}
	
	

}
