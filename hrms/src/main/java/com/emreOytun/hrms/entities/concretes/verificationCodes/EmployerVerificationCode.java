package com.emreOytun.hrms.entities.concretes.verificationCodes;

import javax.persistence.CascadeType; 
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.emreOytun.hrms.entities.concretes.users.Employer;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper =  true)
@Table(name = "verification_code_employers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")

public class EmployerVerificationCode extends VerificationCode {
	@OneToOne(cascade = CascadeType.MERGE)	// CascadeType.MERGE -> VerificationCode for a Candidate can be added to the db after creation of the Candidate. 
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	@JsonManagedReference
	private Employer employer;
}
