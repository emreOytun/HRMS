package com.emreOytun.hrms.entities.concretes.users;

import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.emreOytun.hrms.entities.concretes.verificationCodes.EmployerVerificationCode;
import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(name = "employers")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Employer extends User {
	
	@Column(name = "company_name")
	@NonNull
	private String companyName;
	
	@Column(name = "web_address")
	@NonNull
	private String webAdress;
	
	@Column(name = "phone_number")
	@NonNull
	private String phoneNumber;
	
	@OneToOne(mappedBy = "employer")
	@JsonBackReference
	private EmployerVerificationCode verificationCode;
	
}
