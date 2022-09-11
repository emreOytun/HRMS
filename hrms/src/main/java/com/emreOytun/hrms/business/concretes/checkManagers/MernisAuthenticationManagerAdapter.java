package com.emreOytun.hrms.business.concretes.checkManagers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emreOytun.hrms.business.abstracts.checkServices.CandidateAuthenticationService;
import com.emreOytun.hrms.core.adapters.MernisAuthenticationAdapter;
import com.emreOytun.hrms.entities.concretes.users.Candidate;

@Service
public class MernisAuthenticationManagerAdapter implements CandidateAuthenticationService {

	private MernisAuthenticationAdapter mernisAuthenticationAdapter;
	
	
	@Autowired
	public MernisAuthenticationManagerAdapter(MernisAuthenticationAdapter mernisAuthenticationAdapter) {
		super();
		this.mernisAuthenticationAdapter = mernisAuthenticationAdapter;
	}

	@Override
	public boolean authenticate(Candidate candidate) {
		return mernisAuthenticationAdapter.authenticate(candidate.getIdentityNumber(), candidate.getFirstName(), candidate.getLastName(), candidate.getBirthYear());
	}
	
}
