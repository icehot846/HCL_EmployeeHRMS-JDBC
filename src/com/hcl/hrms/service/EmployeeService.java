package com.hcl.hrms.service;

import java.util.List;

import com.hcl.hrms.dto.Employee;
import com.hcl.hrms.exceptions.EmployeeNotFoundException;

public interface EmployeeService {
	public abstract void addEmployee(Employee e);
	public abstract void deleteEmployee(int empId);
	public abstract void updateEmployee(Employee e);
	public abstract Employee findEmployee(Employee e) throws EmployeeNotFoundException;
	public List<Employee>showAllEmployees();
}
