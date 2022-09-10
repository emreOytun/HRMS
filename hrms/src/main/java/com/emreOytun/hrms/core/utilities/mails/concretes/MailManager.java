package com.emreOytun.hrms.core.utilities.mails.concretes;

import org.springframework.stereotype.Service; 

import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;

@Service
public class MailManager implements MailService {
	public boolean sendMail(String email, String message) {
		return true;
	}
}
