package com.emreOytun.hrms.business.concretes.verificationCodeManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.verificationCodeServices.VerificationCodeService;
import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.verificationCodeDaos.VerificationCodeCandidateDao;
import com.emreOytun.hrms.entities.concretes.users.Candidate;
import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeCandidate;

@Service
public class VerificationCodeCandidateManager extends VerificationCodeService {

	private VerificationCodeCandidateDao verificationCodeCandidateDao;
	
	@Autowired
	public VerificationCodeCandidateManager(VerificationCodeCandidateDao verificationCodeCandidateDao, MailService mailService) {
		super(mailService);
		this.verificationCodeCandidateDao = verificationCodeCandidateDao;
	}

	public Result add(Candidate candidate) {
		String code = String.valueOf(candidate.getId() + 10);
		VerificationCodeCandidate verificationCodeCandidate = new VerificationCodeCandidate();
		verificationCodeCandidate.setCandidate(candidate);
		verificationCodeCandidate.setCode(code);
		verificationCodeCandidate.setVerified(false);
		
		boolean result = super.getMailService().sendMail(candidate.getEmail(), code);
		if (result) {
			verificationCodeCandidateDao.save(verificationCodeCandidate);
			return new SuccessResult("Verification code for candidate is sent to mail and added to the db!");
		}
		else {
			return new ErrorResult("There is a problem with sending the verification email!");
		}
		
	}
	
}
