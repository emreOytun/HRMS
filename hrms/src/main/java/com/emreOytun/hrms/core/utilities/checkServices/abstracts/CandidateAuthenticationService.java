package com.emreOytun.hrms.core.utilities.checkServices.abstracts;

import com.emreOytun.hrms.entities.concretes.users.Candidate;

public interface CandidateAuthenticationService {
	public boolean authenticate(Candidate candidate);
}
