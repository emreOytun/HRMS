package com.emreOytun.hrms.business.concretes.userManagers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.userServices.CandidateService;
import com.emreOytun.hrms.core.utilities.results.DataResult;
import com.emreOytun.hrms.core.utilities.results.SuccessDataResult;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.CandidateDao;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@Service
public class CandidateManager implements CandidateService {

	private CandidateDao candidateDao;
	
	@Autowired
	public CandidateManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public void add(Candidate candidate) {
		candidateDao.save(candidate);
	}

	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(candidateDao.findAll());
	}
	
	
	
}
