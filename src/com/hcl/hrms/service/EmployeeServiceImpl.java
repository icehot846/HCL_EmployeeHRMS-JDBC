package com.hcl.hrms.service;

import java.util.List;

import com.hcl.hrms.dto.Employee;
import com.hcl.hrms.emptracking.EmployeeTracking;
import com.hcl.hrms.emptracking.EmployeeTrackingMySqlImpl;
import com.hcl.hrms.exceptions.EmployeeNotFoundException;

public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeTracking empDao = new EmployeeTrackingMySqlImpl();
	@Override
	public void addEmployee(Employee e) {
		empDao.addEmployee(e);
		
	}

	@Override
	public void deleteEmployee(int empId) {
		empDao.deleteEmployee(empId);
		
	}

	@Override
	public void updateEmployee(Employee e) {
		empDao.updateEmployee(e);
		
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		return empDao.findEmployee(e);
	}

	@Override
	public List<Employee> showAllEmployees() {
		return empDao.showAllEmployees();
	}
	
}
