package com.emreOytun.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.userServices.EmployeeService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessDataResult;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.EmployeeDao;
import com.emreOytun.hrms.entities.concretes.users.Employee;

@Service
public class EmployeeManager implements EmployeeService {

	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeManager(EmployeeDao employeeDao) {
		super();
		this.employeeDao = employeeDao;
	}
	
	@Override
	public Result add(Employee employee) {
		employeeDao.save(employee);
		return new SuccessResult("Employee is added to the db!");
	}

	@Override
	public DataResult<List<Employee>> getAll() {
		return new SuccessDataResult<List<Employee>>(employeeDao.findAll());
	}
	
}
