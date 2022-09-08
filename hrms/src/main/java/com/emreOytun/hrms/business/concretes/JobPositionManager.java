package com.emreOytun.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.JobPositionService;
import com.emreOytun.hrms.dataAccess.abstracts.JobPositionDao;
import com.emreOytun.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {
	
	private JobPositionDao positionDao;
	
	@Autowired
	public JobPositionManager(JobPositionDao positionDao) {
		super();
		this.positionDao = positionDao;
	}

	@Override
	public List<JobPosition> getAll() {
		return this.positionDao.findAll();
	}
	
}
