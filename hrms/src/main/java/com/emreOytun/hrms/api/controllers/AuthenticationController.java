package com.emreOytun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.checkServices.CandidateAuthenticationService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@RestController
@RequestMapping("/api/controller")
public class AuthenticationController {
	
	private CandidateAuthenticationService authenticationService;

	@Autowired
	public AuthenticationController(CandidateAuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("/api/authenticate")
	public Result authenticate(Candidate candidate) {
		if (authenticationService.authenticate(candidate)) {
			return new SuccessResult();
		}
		return new ErrorResult();
	}
	
}
