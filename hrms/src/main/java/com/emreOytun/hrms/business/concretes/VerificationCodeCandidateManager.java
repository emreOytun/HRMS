package com.emreOytun.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.VerificationCodeCandidateService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.VerificationCodeCandidateDao;
import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager implements VerificationCodeCandidateService {

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	
	@Autowired
	public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao) {
		super();
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
	}

	@Override
	public Result add(VerificationCodeCandidate verificationCodeCandidate) {
		verificationCodeCandidateDao.save(verificationCodeCandidate);
		return new SuccessResult("Verification code candidate is added to the db!");
	}
	
}
