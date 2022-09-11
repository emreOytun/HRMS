package com.emreOytun.hrms.business.abstracts.employeeConfirmServices;

import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employer;

public interface EmployeeConfirmEmployerService extends EmployeeConfirmService {
	public Result add(Employer employer);
}
