package com.emreOytun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.VerificationCodeCandidateService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeCandidate;

@RestController
@RequestMapping("/api/verificationCodeCandidates")
public class VerificationCodeCandidatesController {
	private VerificationCodeCandidateService verificationCodeCandidateService;

	@Autowired
	public VerificationCodeCandidatesController(VerificationCodeCandidateService verificationCodeCandidateService) {
		super();
		this.verificationCodeCandidateService = verificationCodeCandidateService;
	}
	
	@PostMapping("/add")
	public Result add(VerificationCodeCandidate verificationCodeCandidate) {
		return verificationCodeCandidateService.add(verificationCodeCandidate);
	}
	
}
