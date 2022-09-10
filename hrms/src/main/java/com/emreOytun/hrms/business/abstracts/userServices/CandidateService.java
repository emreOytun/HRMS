package com.emreOytun.hrms.business.abstracts.userServices;

import java.util.List;

import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.entities.concretes.users.Candidate;


public interface CandidateService {
	public void add(Candidate candidate);
	public DataResult<List<Candidate>> getAll();
}
