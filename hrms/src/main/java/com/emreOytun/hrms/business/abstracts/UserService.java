package com.emreOytun.hrms.business.abstracts;

import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.User;

public interface UserService {
	public Result add(User user);
}
