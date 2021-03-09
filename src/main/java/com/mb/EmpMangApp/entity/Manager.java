package com.mb.EmpMangApp.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="MANAGER_MASTER")
public class Manager {

	@Id
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="PASSWORD")
	private String password;
	
	@Column(name="DATE_OF_BIRTH")
	private Date dob;
	
	@Column(name="ADDRESS")
	private String address;
	
	@Column(name="COMPANY_NAME")
	private String companyName;
	
	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name="ROLES_MASTER",joinColumns = @JoinColumn(name="Email"))
	private Set<String> roles;
	
}
