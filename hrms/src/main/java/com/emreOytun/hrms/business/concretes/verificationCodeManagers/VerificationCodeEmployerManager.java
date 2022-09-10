package com.emreOytun.hrms.business.concretes.verificationCodeManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.verificationCodeServices.VerificationCodeService;
import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.verificationCodeDaos.VerificationCodeEmployerDao;
import com.emreOytun.hrms.entities.concretes.users.Employer;
import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeEmployer;

@Service
public class VerificationCodeEmployerManager extends VerificationCodeService {

	private VerificationCodeEmployerDao verificationCodeEmployerDao;
	
	@Autowired
	public VerificationCodeEmployerManager(VerificationCodeEmployerDao verificationCodeEmployerDao, MailService mailService) {
		super(mailService);
		this.verificationCodeEmployerDao = verificationCodeEmployerDao;
	}
	
	public Result add(Employer employer) {
		String code = String.valueOf(employer.getId() + 10);
		VerificationCodeEmployer verificationCodeEmployer = new VerificationCodeEmployer();
		verificationCodeEmployer.setEmployer(employer);
		verificationCodeEmployer.setCode(code);
		verificationCodeEmployer.setVerified(false);
	
		
		boolean result = super.getMailService().sendMail(employer.getEmail(), code);
		if (result) {
			verificationCodeEmployerDao.save(verificationCodeEmployer);
			return new SuccessResult("Verification code for candidate is sent to mail and added to the db!");
		}
		else {
			return new ErrorResult("There is a problem with sending the verification email!");
		}
		
	}

}
