package com.emreOytun.hrms.entities.concretes.users;

import javax.persistence.Column; 
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "candidates")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class Candidate extends User {
	
	@Column(name = "first_name")
	@NonNull
	private String firstName;
	
	@Column(name = "last_name")
	@NonNull
	private String lastName;
	
	@Column(name = "identity_number")
	@NonNull
	private String identityNumber;
	
	@Column(name = "birth_year")
	private int birthYear;
	
}
