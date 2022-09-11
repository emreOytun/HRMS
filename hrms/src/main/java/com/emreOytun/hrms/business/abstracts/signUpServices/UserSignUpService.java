package com.emreOytun.hrms.business.abstracts.signUpServices;

import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public abstract class UserSignUpService implements SignUpService {
	private MailCheckService mailCheckService;
}
