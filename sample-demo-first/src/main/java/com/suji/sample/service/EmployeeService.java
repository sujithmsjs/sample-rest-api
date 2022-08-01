package com.suji.sample.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.suji.sample.model.Employee;

@Service
public interface EmployeeService {

	List<Employee> getAllEmployees();
	Employee getEmployeeById(int id);
	String saveEmployee(Employee employee);
	
}
