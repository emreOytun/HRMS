package com.emreOytun.hrms.business.concretes;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.JobPositionService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.core.utilities.results.ErrorResult;
import com.emreOytun.hrms.core.utilities.results.Result;
import com.emreOytun.hrms.core.utilities.results.SuccessDataResult;
import com.emreOytun.hrms.core.utilities.results.SuccessResult;
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
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.positionDao.findAll());
	}

	private Result isPositionSavedBefore(JobPosition jobPosition) {
		if (positionDao.findByTitleEquals(jobPosition.getTitle()).size() != 0) {
			return new ErrorResult("This position is saved before !");
		}
		return new SuccessResult();
	}
	
	@Override
	public Result addPosition(JobPosition jobPosition) {
		Result isSavedBefore = isPositionSavedBefore(jobPosition);
		if (!isSavedBefore.isSuccess()) return isSavedBefore;
		return new SuccessResult();
	}
	
}
