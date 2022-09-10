package com.emreOytun.hrms.business.abstracts.userServices;

import java.util.List;

import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.entities.concretes.users.Employer;

public interface EmployerService extends UserService {
	public DataResult<List<Employer>> getAll();
}
