package com.youtube.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youtube.entiry.Employee;
import com.youtube.exception.EmployeeNotFoundException;
import com.youtube.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class MyController {
	
	@Autowired
	private EmployeeServiceImpl service;
	
	@PostMapping("/create")
	public ResponseEntity<Employee> saveEmp(@RequestBody Employee employee) {
		return new ResponseEntity<>(service.createEmp(employee),HttpStatus.CREATED);
	}
	@GetMapping("/getall")
	public ResponseEntity<List<Employee>> getAllEmp() {
		return new ResponseEntity<>(service.getAllEmployee(),HttpStatus.OK);
	}
	@GetMapping("/get/{empId}")
	public ResponseEntity<?> getEmpById(@PathVariable int empId) {
		Optional<Employee> optional = service.getEmpById(empId);
		if(optional.isPresent()) {
			return new ResponseEntity<>(optional.get(),HttpStatus.OK);
		}else {
			 return new ResponseEntity<>(new EmployeeNotFoundException("Invalid Id " + empId).getMessage(), HttpStatus.NOT_FOUND);
		}
	}
		
	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmp(@RequestBody Employee employee) {
		
		return new ResponseEntity<>(service.UpdateEmp(employee),HttpStatus.ACCEPTED);
	}
	@DeleteMapping("/delete")
	public void deleteEmpById(@PathVariable int empId) {
		service.deleteEmployee(empId);
		 
	}

}
