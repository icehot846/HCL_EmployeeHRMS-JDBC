package com.hcl.hrms.emptracking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;

import com.hcl.hrms.dto.Employee;
import com.hcl.hrms.exceptions.EmployeeNotFoundException;

public class EmployeeTrackingMySqlImpl implements EmployeeTracking{
	
	private Connection cn = null;
	private PreparedStatement pst = null;
	private ResultSet rs = null;
	public static final String INS_COMMAND = "INSERT INTO employee VALUES(?,?,?,?,?)";
	public static final String UPDATE_COMMAND = "UPDATE employee SET EmpName=?, DOB=?, Salary=?, Age=? WHERE EmpID=?";
	public static final String DELETE_COMMAND = "DELETE FROM employee WHERE EmpID=?";
	public static final String FIND_COMMAND = "SELECT * FROM employee WHERE EmpID=?";
	public static final String SELECT_ALL = "SELECT * FROM employee";
	
	public EmployeeTrackingMySqlImpl() {
		try {
			cn = DriverManager.getConnection(EmployeeTracking.URL,EmployeeTracking.USERNAME,EmployeeTracking.PASSWORD);
		} catch (SQLException e1) {
			System.out.println("Unable to establish the connection with the database.");
			e1.printStackTrace();
		}
	}
	
	@Override
	public void addEmployee(Employee e) {
		int i = 0;
		
		try {
			pst = cn.prepareStatement(INS_COMMAND);
			pst.setInt(1, e.getEmpId());
			pst.setString(2, e.getEmpName());
			pst.setString(3, e.getDateOfBirth());
			pst.setDouble(4, e.getSalary());
			pst.setInt(5, e.getAge());
			i = pst.executeUpdate();
			
		} catch (SQLException e1) {
			System.out.println("Unable to execute insert command.");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(i > 0) {
			System.out.println("The record has been added.");
		}
	
	}

	@Override
	public void deleteEmployee(int empId) {
		int i = 0;
		try {
			pst = cn.prepareStatement(DELETE_COMMAND);
			pst.setInt(1, empId);
			i = pst.executeUpdate();
		
		} catch (SQLException e) {
			System.out.println("Unable to execute delete command.");
			e.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(i > 0) {
			System.out.println("The record has been deleted.");
		}
		
	}

	@Override
	public void updateEmployee(Employee e) {
		int i = 0;
		try {
			pst = cn.prepareStatement(UPDATE_COMMAND);
			pst.setInt(5, e.getEmpId());
			pst.setString(1, e.getEmpName());
			pst.setString(2, e.getDateOfBirth());
			pst.setDouble(3, e.getSalary());
			pst.setInt(4, e.getAge());
			i = pst.executeUpdate();
		} catch (SQLException e1) {
			System.out.println("Unable to execute update command.");
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(i > 0) {
			System.out.println("The record has been updated.");
		}
		
	}

	@Override
	public Employee findEmployee(Employee e) throws EmployeeNotFoundException {
		Employee findTemp = null;
		
		try {
			pst = cn.prepareStatement(FIND_COMMAND);
			pst.setInt(1, e.getEmpId());
			rs = pst.executeQuery();
			if(!rs.next()) {
				throw new EmployeeNotFoundException();
			}
			findTemp = new Employee();
			findTemp.setEmpName(rs.getString("EmpName"));
			findTemp.setDateOfBirth(rs.getString("dob"));
			findTemp.setSalary(rs.getDouble("salary"));
			findTemp.setAge(rs.getInt("age"));
			findTemp.setEmpId(rs.getInt("empId"));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			try {
				pst.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		return findTemp;
	}

	@Override
	public List<Employee> showAllEmployees() {
		Employee selectAllTemp = null;
		List<Employee> elist = new LinkedList<>();
		try {
			pst = cn.prepareStatement(SELECT_ALL);
			rs = pst.executeQuery();
			while(rs.next()) {
				selectAllTemp = new Employee();
				selectAllTemp.setEmpId(rs.getInt("empid"));
				selectAllTemp.setEmpName(rs.getString("EmpName"));
				selectAllTemp.setDateOfBirth(rs.getString("dob"));
				selectAllTemp.setSalary(rs.getDouble("salary"));
				selectAllTemp.setAge(rs.getInt("age"));
				elist.add(selectAllTemp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return elist;
	}
			
}
