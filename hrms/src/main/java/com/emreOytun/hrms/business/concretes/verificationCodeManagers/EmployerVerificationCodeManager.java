package com.emreOytun.hrms.business.concretes.verificationCodeManagers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.verificationCodeServices.EmployerVerificationCodeService;
import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.verificationCodeDaos.EmployerVerificationCodeDao;
import com.emreOytun.hrms.entities.concretes.users.Employer;
import com.emreOytun.hrms.entities.concretes.verificationCodes.EmployerVerificationCode;

@Service
public class EmployerVerificationCodeManager extends EmployerVerificationCodeService {

	private EmployerVerificationCodeDao employerVerificationCodeDao;
	
	@Autowired
	public EmployerVerificationCodeManager(EmployerVerificationCodeDao employerVerificationCodeDao, MailService mailService) {
		super(mailService);
		this.employerVerificationCodeDao = employerVerificationCodeDao;
	}
	
	public Result sendCode(Employer employer) {
		EmployerVerificationCode employerVerificationCode = createVerificationCode(employer);
		
		boolean result = super.getMailService().sendMail(employer.getEmail(), employerVerificationCode.getCode());
		if (result) {
			employerVerificationCodeDao.save(employerVerificationCode);
			return new SuccessResult("Verification code for candidate is sent to mail and added to the db!");
		}
		else {
			return new ErrorResult("There is a problem with sending the verification email!");
		}
		
	}
	
	private EmployerVerificationCode createVerificationCode(Employer employer) {
		String code = String.valueOf(employer.getId() + 10);
		EmployerVerificationCode employerVerificationCode = new EmployerVerificationCode();
		employerVerificationCode.setEmployer(employer);
		employerVerificationCode.setCode(code);
		employerVerificationCode.setVerified(false);
		
		return employerVerificationCode;
	}

}
