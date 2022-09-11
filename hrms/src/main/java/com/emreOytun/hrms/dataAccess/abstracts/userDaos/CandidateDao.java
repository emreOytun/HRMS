package com.emreOytun.hrms.dataAccess.abstracts.userDaos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.users.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Integer>{
	List<Candidate> findByIdentityNumberEquals(String identityNumber);
	List<Candidate> findByEmailEquals(String email);
}
