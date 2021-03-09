package com.mb.EmpMangApp.repo;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mb.EmpMangApp.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Serializable> {

}
