package com.emreOytun.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.users.User; 

public interface UserDao extends JpaRepository<User, Integer>{
	
}
