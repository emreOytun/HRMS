package com.emreOytun.hrms.api.controllers.signUpControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.signUpServices.EmployerSignUpService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employer;

@RestController
@RequestMapping("/api/employers")
public class EmployerSignUpController {
	private EmployerSignUpService employerSignUpService;

	@Autowired
	public EmployerSignUpController(EmployerSignUpService employerSignUpService) {
		super();
		this.employerSignUpService = employerSignUpService;
	}

	@PostMapping("/signUp")
	public Result signUp(Employer employer) {
		return employerSignUpService.signUp(employer);
	}
}
