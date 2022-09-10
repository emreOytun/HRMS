package com.emreOytun.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.userServices.EmployerService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.core.utilities.results.SuccessDataResult;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.EmployerDao;
import com.emreOytun.hrms.entities.concretes.users.Employer;

@Service
public class EmployerManager implements EmployerService {

	private EmployerDao employerDao;
	
	@Autowired
	public EmployerManager(EmployerDao employerDao) {
		super();
		this.employerDao = employerDao;
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(employerDao.findAll());
	}
	
}
