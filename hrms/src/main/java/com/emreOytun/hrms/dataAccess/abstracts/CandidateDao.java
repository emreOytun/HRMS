package com.emreOytun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.users.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	
}
