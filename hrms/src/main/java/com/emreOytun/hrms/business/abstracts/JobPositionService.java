package com.emreOytun.hrms.business.abstracts;

import java.util.List;

import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.entities.concretes.JobPosition;

public interface JobPositionService {
	DataResult<List<JobPosition>> getAll();
}
