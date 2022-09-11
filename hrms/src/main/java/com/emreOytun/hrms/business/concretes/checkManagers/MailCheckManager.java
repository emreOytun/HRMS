package com.emreOytun.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.checkServices.MailCheckService;
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
		if(userDao.findByEmailEquals(email).size() == 0) {
			return false;
		}
		return true;
	}

}
