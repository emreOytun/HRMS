package com.emreOytun.hrms.business.concretes.signUpManagers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.checkServices.CandidateAuthenticationService;
import com.emreOytun.hrms.business.abstracts.checkServices.IdentityNumberCheckService;
import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;
import com.emreOytun.hrms.business.abstracts.signUpServices.CandidateSignUpService;
import com.emreOytun.hrms.business.abstracts.verificationCodeServices.CandidateVerificationCodeService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.CandidateDao;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@Service
public class CandidateSignUpManager extends CandidateSignUpService {
	private IdentityNumberCheckService identityNumberCheckService;
	private CandidateAuthenticationService authenticationService;
	
	private CandidateDao candidateDao;
	private CandidateVerificationCodeService verificationCodeService;
	
	@Autowired
	public CandidateSignUpManager(MailCheckService mailCheckService,
			IdentityNumberCheckService identityNumberCheckService, CandidateAuthenticationService authenticationService,
			CandidateDao candidateDao, CandidateVerificationCodeService verificationCodeService) {
		super(mailCheckService);
		this.identityNumberCheckService = identityNumberCheckService;
		this.authenticationService = authenticationService;
		this.candidateDao = candidateDao;
		this.verificationCodeService = verificationCodeService;
	}

	@Override
	public Result signUp(Candidate candidate) {
			Result checkResult = checkCandidate(candidate);
			if (!checkResult.isSuccess()) return checkResult;
					
			candidateDao.save(candidate);
			candidate = candidateDao.findByEmailEquals(candidate.getEmail()).get(0);
			
			return verificationCodeService.sendCode(candidate);	
			
	}
	
	private Result checkCandidate(Candidate candidate) {
		Result isFilledResult = isFilled(candidate);
		if (!isFilledResult.isSuccess()) return isFilledResult;
		
		Result validationResult = validateCandidate(candidate);
		if (!validationResult.isSuccess()) return validationResult;
			
		return new SuccessResult();
	}
	
	private boolean checkIfStringNotFilled(String string) {
		if (string.isEmpty() || string.isEmpty() || string == null) {
			return true;
		}
		return false;
	}
	
	private Result isFilled(Candidate candidate) {
		if (checkIfStringNotFilled(candidate.getFirstName())) {
			return new ErrorResult("First name cannot be empty !");
		}
		if (checkIfStringNotFilled(candidate.getLastName())) {
			return new ErrorResult("Last name cannot be empty !");
		}
		if (checkIfStringNotFilled(candidate.getIdentityNumber())) {
			return new ErrorResult("Identity number cannot be empty !");
		}
		if (checkIfStringNotFilled(candidate.getEmail())) {
			return new ErrorResult("Email cannot be empty !");
		}
		
		return new SuccessResult();
	}

	private Result validateCandidate(Candidate candidate) {
		if (identityNumberCheckService.isIdentityRegistered(candidate.getIdentityNumber())) {
			return new ErrorResult("Identity number is registered before !");
		}
		if (getMailCheckService().isMailRegistered(candidate.getEmail())) {
			return new ErrorResult("Email is registered before !");
		}
		
		return new SuccessResult();
	}
	
}
