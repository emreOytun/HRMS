package com.emreOytun.hrms.core.utilities.checkServices.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.core.utilities.checkServices.abstracts.IdentityNumberCheckService;
import com.emreOytun.hrms.dataAccess.abstracts.userDaos.CandidateDao;

@Service
public class IdentityNumberCheckManager implements IdentityNumberCheckService {

	private CandidateDao candidateDao;
	
	@Autowired
	public IdentityNumberCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean isIdentityNumberRegistered(String identityNumber) {
		if (candidateDao.findByIdentityNumberEquals(identityNumber).size() == 0) {
			return true;
		}
		return false;
	}

}
