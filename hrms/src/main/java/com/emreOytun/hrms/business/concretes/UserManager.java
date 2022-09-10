package com.emreOytun.hrms.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.UserService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.UserDao;
import com.emreOytun.hrms.entities.concretes.users.User;

@Service
public class UserManager implements UserService{

	private UserDao userDao;
		
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public Result add(User user) {
		userDao.save(user);
		return new SuccessResult("User is added to the db!");
	}

}
