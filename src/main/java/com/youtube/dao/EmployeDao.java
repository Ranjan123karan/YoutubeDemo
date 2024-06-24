package com.youtube.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.youtube.entiry.Employee;
@Repository
public interface EmployeDao extends JpaRepository<Employee, Integer>{

}
