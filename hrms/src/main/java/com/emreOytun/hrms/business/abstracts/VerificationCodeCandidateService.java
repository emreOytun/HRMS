package com.emreOytun.hrms.business.abstracts;

import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeCandidate;

public interface VerificationCodeCandidateService {
	
	public Result add(VerificationCodeCandidate verificationCodeCandidate);
}
