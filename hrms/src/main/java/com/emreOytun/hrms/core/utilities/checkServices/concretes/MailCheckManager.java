package com.emreOytun.hrms.core.utilities.checkServices.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.core.utilities.checkServices.abstracts.MailCheckService;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.UserDao;

@Service
public class MailCheckManager implements MailCheckService{
	
	private UserDao userDao;
	
	@Autowired
	public MailCheckManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public boolean isMailRegistered(String email) {
		if(userDao.findByEmailEquals(email).size() != 0) {
			return true;
		}
		return false;
	}

}
