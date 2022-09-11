package com.emreOytun.hrms.business.abstracts.signUpServices;

import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

public abstract class CandidateSignUpService extends UserSignUpService {
	public CandidateSignUpService(MailCheckService mailCheckService) {
		super(mailCheckService);
	}

	public abstract Result signUp(Candidate candidate);
}
