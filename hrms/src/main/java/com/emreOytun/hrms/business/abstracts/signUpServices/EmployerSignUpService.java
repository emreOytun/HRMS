package com.emreOytun.hrms.business.abstracts.signUpServices;

import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employer;

public abstract class EmployerSignUpService extends UserSignUpService {
	public EmployerSignUpService(MailCheckService mailCheckService) {
		super(mailCheckService);
	}

	public abstract Result signUp(Employer employer);
}
