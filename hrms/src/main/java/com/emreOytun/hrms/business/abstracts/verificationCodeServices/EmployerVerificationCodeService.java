package com.emreOytun.hrms.business.abstracts.verificationCodeServices;

import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employer;

public abstract class EmployerVerificationCodeService extends VerificationCodeService {

	public EmployerVerificationCodeService(MailService mailService) {
		super(mailService);
	}
	
	public abstract Result sendCode(Employer employer);

}
