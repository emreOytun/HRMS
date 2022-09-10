package com.emreOytun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeCandidate;

public interface VerificationCodeCandidateDao extends JpaRepository<VerificationCodeCandidate, Integer>{
	
}
