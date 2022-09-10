package com.emreOytun.hrms.dataAccess.abstracts.verificationCodeDaos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emreOytun.hrms.entities.concretes.verificationCodes.VerificationCodeEmployer;

public interface VerificationCodeEmployerDao extends JpaRepository<VerificationCodeEmployer, Integer>{

}
