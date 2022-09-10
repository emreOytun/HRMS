package com.emreOytun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.EmployeeService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employee;

@RestController
@RequestMapping("/api/employees")
public class EmployeesController {
	private EmployeeService employeeService;

	@Autowired
	public EmployeesController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping("/add")
	public Result add(Employee employee) {
		return employeeService.add(employee);
	}
	
}
