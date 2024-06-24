package com.youtube.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.youtube.dao.EmployeDao;
import com.youtube.entiry.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeDao dao;

	@Override
	public Employee createEmp(Employee employee) {
		Employee emp = dao.save(employee);
		
		 
		return emp;
	}

	@Override
	public List<Employee> getAllEmployee() {
	 List<Employee> list = dao.findAll();
		return list;
	}

	@Override
	public Optional<Employee> getEmpById(int empId) {
		 Optional<Employee> optional = dao.findById(empId);
		return optional;
	}

	@Override
	public Employee UpdateEmp(Employee employee) {
		 if(employee.getEmpId()!=0) {
			 Employee entity=new Employee();
			 entity.setEmpName(employee.getEmpName());
			 entity.setEmail(employee.getEmail());
			 entity.setSalary(employee.getSalary());
			 Employee update = dao.save(entity);
			 return update;
			 
		 }
		return null;
	}

	@Override
	public void deleteEmployee(int empId) {
		 dao.deleteById(empId);
		
	}

}
