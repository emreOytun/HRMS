package com.emreOytun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.business.abstracts.verificationCodeServices.CandidateVerificationCodeService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@RestController
@RequestMapping("/api/verificationCode")
public class VerificationCodeController {

	private CandidateVerificationCodeService candidateVerificationCodeService;

	@Autowired
	public VerificationCodeController(CandidateVerificationCodeService candidateVerificationCodeService) {
		super();
		this.candidateVerificationCodeService = candidateVerificationCodeService;
	}
	
	@PostMapping("/addCandidateCode")
	public Result addCandidateCode(Candidate candidate) {
		return candidateVerificationCodeService.sendCode(candidate);
	}
	
}
