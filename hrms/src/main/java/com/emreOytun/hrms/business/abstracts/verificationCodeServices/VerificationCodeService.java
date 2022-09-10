package com.emreOytun.hrms.business.abstracts.verificationCodeServices;

import com.emreOytun.hrms.core.utilities.mails.abstracts.MailService;

public abstract class VerificationCodeService {
	private MailService mailService;

	public VerificationCodeService(MailService mailService) {
		super();
		this.setMailService(mailService);
	}

	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
}
