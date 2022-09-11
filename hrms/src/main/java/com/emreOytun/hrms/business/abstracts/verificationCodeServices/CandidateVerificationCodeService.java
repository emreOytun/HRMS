package com.emreOytun.hrms.business.abstracts.verificationCodeServices;

import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

public abstract class CandidateVerificationCodeService extends VerificationCodeService {

	public CandidateVerificationCodeService(MailService mailService) {
		super(mailService);
	}
	
	public abstract Result sendCode(Candidate candidate);

}
