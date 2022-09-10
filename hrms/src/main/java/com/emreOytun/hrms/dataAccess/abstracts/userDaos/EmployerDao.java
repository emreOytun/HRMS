package com.emreOytun.hrms.dataAccess.abstracts.userDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.users.Employer;

public interface EmployerDao extends JpaRepository<Employer, Integer>{
	
}
