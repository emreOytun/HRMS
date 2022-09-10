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
@Table(name = "employees")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")	// One-to-one mapping of two tables' primary keys.
public class Employee extends User {
	
	@Column(name = "first_name")
	@NonNull
	private String firstName;
	
	@Column(name = "last_name")
	@NonNull
	private String lastName;
	
}
