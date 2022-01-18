package com.hcl.hrms.exceptions;

public class EmployeeNotFoundException extends Exception{
	private int empId;
	
	public EmployeeNotFoundException(int empId) {
		this.empId = empId;
	}
	
	public String toStrin() {
		return "Employee Not Found Exception " + this.empId;
	}
}
