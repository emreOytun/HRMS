package com.emreOytun.hrms.business.concretes.signUpManagers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;
import com.emreOytun.hrms.business.abstracts.employeeConfirmServices.EmployeeConfirmEmployerService;
import com.emreOytun.hrms.business.abstracts.signUpServices.EmployerSignUpService;
import com.emreOytun.hrms.business.abstracts.verificationCodeServices.EmployerVerificationCodeService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.EmployerDao;
import com.emreOytun.hrms.entities.concretes.users.Employer;

@Service
public class EmployerSignUpManager extends EmployerSignUpService {
	private EmployeeConfirmEmployerService employeeConfirmService;
	private EmployerVerificationCodeService verificationCodeService;
	private EmployerDao employerDao;
	
	@Autowired
	public EmployerSignUpManager(MailCheckService mailCheckService,
			EmployeeConfirmEmployerService employeeConfirmService,
			EmployerVerificationCodeService verificationCodeService, EmployerDao employerDao) {
		super(mailCheckService);
		this.employeeConfirmService = employeeConfirmService;
		this.verificationCodeService = verificationCodeService;
		this.employerDao = employerDao;
	}

	public Result signUp(Employer employer) {
		Result checkResult = checkEmployer(employer);
		if (!checkResult.isSuccess()) return checkResult;
		
		employerDao.save(employer);
		employer = employerDao.findByPhoneNumberEquals(employer.getPhoneNumber()).get(0);
		
		return verificationCodeService.sendCode(employer);
	}
	
	private Result checkEmployer(Employer employer) {
		Result isFilledResult = isFilled(employer);
		if (!isFilledResult.isSuccess()) return isFilledResult;
		
		Result checkDomainResult = checkDomain(employer);
		if (!checkDomainResult.isSuccess()) return checkDomainResult;
		
		if (employerDao.findByPhoneNumberEquals(employer.getPhoneNumber()).size() != 0) {
			return new ErrorResult("Phone number is registered before !");
		}
		
		return new SuccessResult();
	}
	
	private boolean checkIfStringNotFilled(String string) {
		if (string.isEmpty() || string.isEmpty() || string == null) {
			return true;
		}
		return false;
	}
	
	private Result isFilled(Employer employer) {
		if (checkIfStringNotFilled(employer.getCompanyName())) {
			return new ErrorResult("Company name cannot be empty !");
		}
		if (checkIfStringNotFilled(employer.getWebAdress())) {
			return new ErrorResult("Web adress cannot be empty !");
		}
		if (checkIfStringNotFilled(employer.getEmail())) {
			return new ErrorResult("Email cannot be empty !");
		}
		if (checkIfStringNotFilled(employer.getPassword())) {
			return new ErrorResult("Password cannot be empty !");
		}
	
		return new SuccessResult();
	}
	
	public static String getDomainFromUrl(String url) throws URISyntaxException {
	    URI uri = new URI(url);
	    String domain = uri.getHost();
	    return domain.startsWith("www.") ? domain.substring(4) : domain;
	}
	
	public String getDomainFromMail(String mail) {
		String[] words = mail.split("@");
		return words[1];
	}
	
	private Result checkDomain(Employer employer) {
		String urlDomain;
		try {
			urlDomain = getDomainFromUrl(employer.getWebAdress());
			
			String mailDomain = getDomainFromMail(employer.getEmail());
			if (urlDomain != mailDomain) {
				return new ErrorResult("Web address and email domain must be the same !");
			}
			
			return new SuccessResult();
		
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		return new ErrorResult("There is an error with the url format !");
	}
	
}
