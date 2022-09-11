package com.emreOytun.hrms.business.concretes.employeeConfirmManagers;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.employeeConfirmServices.EmployeeConfirmEmployerService;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
import com.emreOytun.hrms.dataAccess.abstracts.employeeConfirmDaos.EmployeeConfirmEmployerDao;
import com.emreOytun.hrms.entities.concretes.employeeConfirms.EmployeeConfirmEmployer;
import com.emreOytun.hrms.entities.concretes.users.Employer;

@Service
public class EmployeeConfirmEmployerManager implements EmployeeConfirmEmployerService {
	
	private EmployeeConfirmEmployerDao employeeConfirmEmployerDao;
	
	@Autowired
	public EmployeeConfirmEmployerManager(EmployeeConfirmEmployerDao employeeConfirmEmployerDao) {
		super();
		this.employeeConfirmEmployerDao = employeeConfirmEmployerDao;
	}

	@Override
	public Result add(Employer employer) {
		EmployeeConfirmEmployer employeeConfirmEmployer = new EmployeeConfirmEmployer();
		employeeConfirmEmployer.setEmployer(employer);
		employeeConfirmEmployer.setConfirmed(false);
		
		employeeConfirmEmployerDao.save(employeeConfirmEmployer);
		return new SuccessResult("Employee confirm for employer is added to the db !");
	}
	
}
