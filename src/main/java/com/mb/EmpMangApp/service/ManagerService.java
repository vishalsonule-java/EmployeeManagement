package com.mb.EmpMangApp.service;

import java.util.List;

import com.mb.EmpMangApp.entity.Employee;
import com.mb.EmpMangApp.entity.Manager;


public interface ManagerService {

	
	public Boolean saveManager(Manager manager);
	
	public Boolean saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployee();
	
	public Employee getEmployeeById(Integer id);
	
	public Boolean updateEmployee(Employee employee);
	
	public Boolean deleteEmployeeById(Integer id);
}
