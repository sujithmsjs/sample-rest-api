package com.suji.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suji.sample.model.Employee;
import com.suji.sample.service.EmployeeService;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {

	//Dependencies
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(path = "/test")
	public String test() {
		return "Hello World";
	}
	
	
	// http://localhost:8080/employees/all
	@GetMapping("/all")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	@GetMapping("/get/{empId}")
	public Employee getEmployeeById(@PathVariable(value = "empId") Integer id) {
		return employeeService.getEmployeeById(id);
	}
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody(required = true) Employee employee) {
		return employeeService.saveEmployee(employee);
	}
}
