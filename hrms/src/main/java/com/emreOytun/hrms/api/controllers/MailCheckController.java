package com.emreOytun.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emreOytun.hrms.core.utilities.checkServices.abstracts.MailCheckService;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;

@RestController
@RequestMapping("/api/mailCheck")
public class MailCheckController {
	
	private MailCheckService mailCheckService;

	@Autowired
	public MailCheckController(MailCheckService mailCheckService) {
		super();
		this.mailCheckService = mailCheckService;
	}
	
	@GetMapping("/check")
	public Result checkMail(String email) {
		if (mailCheckService.isMailRegistered(email)) {
			return new SuccessResult("Email onceden kayitli !");
		}
		else return new ErrorResult("Email kayitli degil !");
	}
}
