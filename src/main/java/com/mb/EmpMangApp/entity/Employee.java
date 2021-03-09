package com.mb.EmpMangApp.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="EMPLOYEE_MASTER")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name="EMP_ID")
	private Integer empId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name="CONTACT")
	private Long mobile;
}
