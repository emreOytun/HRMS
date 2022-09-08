package com.emreOytun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.JobPosition;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer>{
	
}
