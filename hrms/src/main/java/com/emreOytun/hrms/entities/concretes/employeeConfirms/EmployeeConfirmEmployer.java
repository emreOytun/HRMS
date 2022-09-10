package com.emreOytun.hrms.entities.concretes.employeeConfirms;

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
@Entity
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee_confirm_employer")
@PrimaryKeyJoinColumn(name = "id", referencedColumnName = "id")
public class EmployeeConfirmEmployer extends EmployeeConfirm {
	@OneToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "employer_id", referencedColumnName = "id")
	@JsonManagedReference
	private Employer employer;
	
}
