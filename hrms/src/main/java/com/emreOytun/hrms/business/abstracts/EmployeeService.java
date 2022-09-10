package com.emreOytun.hrms.business.abstracts;

import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employee;

public interface EmployeeService {
	public Result add(Employee employee);
}
