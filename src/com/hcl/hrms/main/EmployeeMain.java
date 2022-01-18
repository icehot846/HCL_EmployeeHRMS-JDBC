package com.hcl.hrms.main;

import com.hcl.hrms.service.EmployeeService;
import com.hcl.hrms.service.EmployeeServiceImpl;

public class EmployeeMain {
	public static void main(String[] args) {
		EmployeeService eservice = new EmployeeServiceImpl();
		eservice.addEmployee(new Employee);
	}
}
