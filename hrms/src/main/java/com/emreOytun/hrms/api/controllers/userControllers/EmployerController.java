package com.emreOytun.hrms.api.controllers.userControllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.userServices.EmployerService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.entities.concretes.users.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerController {
	private EmployerService employerService;

	@Autowired
	public EmployerController(EmployerService employerService) {
		super();
		this.employerService = employerService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<Employer>> getAll() {
		return employerService.getAll();
	}
	
}
