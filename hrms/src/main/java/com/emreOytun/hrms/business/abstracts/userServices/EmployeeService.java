package com.emreOytun.hrms.business.abstracts.userServices;

import java.util.List;

import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.entities.concretes.users.Employee;

public interface EmployeeService {
	public Result add(Employee employee);
	public DataResult<List<Employee>> getAll();
}
