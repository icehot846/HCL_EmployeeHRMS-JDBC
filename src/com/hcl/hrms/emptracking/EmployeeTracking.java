package com.hcl.hrms.emptracking;
import com.hcl.hrms.dto.Employee;
import com.hcl.hrms.exceptions.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeTracking {
	public abstract void addEmployee(Employee e);
	public abstract void deleteEmployee(int empId);
	public abstract void updateEmployee(Employee e);
	public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
	public List<Employee>showAllEmployees();
	public static final String URL = "jdbc:mysql://localhost:3306/javapractice";
	public static final String USERNAME = "root";
	public static final String PASSWORD = "Password1!";
	public static final String DRIVER_CLASSNAME = "com.mysql.jdbc.Driver";
}
