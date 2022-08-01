package com.suji.sample.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.suji.sample.model.Employee;

@RestController
@RequestMapping("/medium")
public class TestControllerMedium {

	// ________GET MAPPING__________//
	// GET Method is used for READ/GET data

	// Say Hi
	@GetMapping("/hi")
	public String sayHi() {
		return "Hello world";
	}

	// Add two numbers
	@GetMapping("/add/{num1}/{num2}")
	public String add(@PathVariable(required = true, name = "num1") int a,
			@PathVariable(required = true, name = "num2") int b) {
		
		return "Sum is: " + (a + b);
	}

	// Reverse String
	@GetMapping("/reverse/{inputStr}")
	public String add(@PathVariable(required = true, name = "inputStr") String str) {
		
		return "Reverse String is: " + new StringBuilder(str).reverse();
	}

	// Get Fake employee
	@GetMapping("/fake/{empId}")
	public Employee getFake(@PathVariable(required = true, name = "empId") int id) {
		
		return new Employee(id, "FAke name", "Fake Dept", 10000);
	}

	// ________POST MAPPING__________//
	// POST Method is used for CREATE/SAVE data

	// Double Employee salary and id
	@PostMapping("/double")
	public Employee doubleIt(@RequestBody(required = true) Employee e) {
		return new Employee(e.getId() * 2, e.getName(), e.getDept(), e.getSalary() * 2);
	}

	// Employee Details in String
	@PostMapping("/instr")
	public String details(@RequestBody(required = true) Employee e) {
		return e.toString();
	}

	// ________PUT MAPPING__________//
	// PUT Method is used for UPDATE data

	@PutMapping("/update/{empId}")
	public Employee updateEmployee(@PathVariable(required = true, name = "empId") int id,
			@RequestBody(required = true) Employee e) {
		Employee newEmp = new Employee(id, "Updated Name", "Updated Dept", 10000);
		return newEmp;
	}

	// ________DELETE MAPPING__________//
	// DELETE Method is used for DELETE data

	@DeleteMapping("/delete/{empId}")
	public String deleteEmployeeById(@PathVariable(required = true, name = "empId") int id) {
		return "Employee with id '" + id + "' has been deleted";
	}

}
