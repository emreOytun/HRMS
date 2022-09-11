package com.emreOytun.hrms.business.concretes.verificationCodeManagers;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.verificationCodeServices.CandidateVerificationCodeService;
import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.verificationCodeDaos.CandidateVerificationCodeDao;
import com.emreOytun.hrms.entities.concretes.users.Candidate;
import com.emreOytun.hrms.entities.concretes.verificationCodes.CandidateVerificationCode;

@Service
public class CandidateVerificationCodeManager extends CandidateVerificationCodeService {

	private CandidateVerificationCodeDao candidateVerificationCodeDao;
	
	@Autowired
	public CandidateVerificationCodeManager(CandidateVerificationCodeDao candidateVerificationCodeDao, MailService mailService) {
		super(mailService);
		this.candidateVerificationCodeDao = candidateVerificationCodeDao;
	}

	public Result sendCode(Candidate candidate) {
		CandidateVerificationCode candidateVerificationCode = createVerificationCode(candidate);
		
		boolean result = super.getMailService().sendMail(candidate.getEmail(), candidateVerificationCode.getCode());
		if (result) {
			candidateVerificationCodeDao.save(candidateVerificationCode);
			return new SuccessResult("Verification code for candidate is sent to mail and added to the db!");
		}
		else {
			return new ErrorResult("There is a problem with sending the verification email!");
		}
		
	}
	
	private CandidateVerificationCode createVerificationCode(Candidate candidate) {
		String code = String.valueOf(candidate.getId() + 10);
		CandidateVerificationCode candidateVerificationCode = new CandidateVerificationCode();
		candidateVerificationCode.setCandidate(candidate);
		candidateVerificationCode.setCode(code);
		candidateVerificationCode.setVerified(false);
		
		return candidateVerificationCode;
	}
	
}
