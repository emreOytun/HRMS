package com.emreOytun.hrms.business.abstracts.checkServices;

import com.emreOytun.hrms.entities.concretes.users.Candidate;

public interface CandidateAuthenticationService {
	public boolean authenticate(Candidate candidate);
}
