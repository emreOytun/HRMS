package com.emreOytun.hrms.api.controllers.signUpControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.signUpServices.CandidateSignUpService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@RestController
@RequestMapping("/api/candidates")
public class CandidateSignUpController {
	private CandidateSignUpService candidateSignUpService;

	@Autowired
	public CandidateSignUpController(CandidateSignUpService candidateSignUpService) {
		super();
		this.candidateSignUpService = candidateSignUpService;
	}

	@PostMapping("/signUp")
	public Result signUp(@RequestBody Candidate candidate) {
		return candidateSignUpService.signUp(candidate);
	}
}
