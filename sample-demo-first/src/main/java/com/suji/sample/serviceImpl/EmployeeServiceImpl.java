package com.suji.sample.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.suji.sample.model.Employee;
import com.suji.sample.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> employeeList = new ArrayList<>();
	
	@Override
	public List<Employee> getAllEmployees() {
		return employeeList;
	}

	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = null;
		for(Employee e : employeeList) {
			if(e.getId() == id) {
				employee = e;
			}
		}	
		return employee;
	}

	@Override
	public String saveEmployee(Employee employee) {
		
		if(employeeList.add(employee)) {
			return "Employee with id '"+employee.getId()+"' created successfully. ";
		}else {
			return "Sorry failed to create Employee with id '"+employee.getId()+"'";
		}
	}

}
