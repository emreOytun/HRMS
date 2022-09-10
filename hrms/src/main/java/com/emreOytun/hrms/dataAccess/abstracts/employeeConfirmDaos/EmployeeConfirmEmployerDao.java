package com.emreOytun.hrms.dataAccess.abstracts.employeeConfirmDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.users.Employer;

public interface EmployeeConfirmEmployerDao extends JpaRepository<Employer, Integer>{

}
