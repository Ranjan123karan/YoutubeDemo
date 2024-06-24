package com.youtube.service;

import java.util.List;
import java.util.Optional;

import com.youtube.entiry.Employee;

public interface EmployeeService {
	
	public Employee createEmp(Employee employee);
	public List<Employee> getAllEmployee();
	public Optional<Employee> getEmpById(int empId);
	public Employee UpdateEmp(Employee employee);
	public void deleteEmployee(int empId);

}
