package com.mb.EmpMangApp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.mb.EmpMangApp.entity.Employee;
import com.mb.EmpMangApp.entity.Manager;
import com.mb.EmpMangApp.exception.EmployeeNotFoundException;
import com.mb.EmpMangApp.exception.EmployeeNotSavedException;
import com.mb.EmpMangApp.exception.EmployeeNotUpdateException;
import com.mb.EmpMangApp.exception.ManagerNotSavedException;
import com.mb.EmpMangApp.repo.EmployeeRepository;
import com.mb.EmpMangApp.repo.ManagerRepository;

@Service
public class ManagerServiceImpl implements ManagerService,UserDetailsService{

	@Autowired
	private ManagerRepository managerRepository;
	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Boolean saveManager(Manager manager) {
		Boolean flag = false;
		manager.setPassword(encoder.encode(manager.getPassword()));
		Manager managerSaveObj = managerRepository.save(manager);
		if (managerSaveObj != null) {
			flag = true;
		} else {
			throw new ManagerNotSavedException();
		}
		return flag;
	}

	@Override
	public Boolean saveEmployee(Employee employee) {
		Boolean flag = false;
		Employee empSaveObj = employeeRepository.save(employee);
		if(empSaveObj!=null) 
			flag=true;
		else
			throw new EmployeeNotSavedException();
		return flag;
	}

	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Integer id) {
		boolean isEmpExists = employeeRepository.existsById(id);
		if(isEmpExists)
		return employeeRepository.findById(id).get();
		else 
			throw new EmployeeNotFoundException();
	}

	@Override
	public Boolean updateEmployee(Employee employee) {
		Boolean flag = false;
		Employee empUpdateObj = employeeRepository.save(employee);
		if(empUpdateObj!=null) 
			flag=true;
		else
			throw new EmployeeNotUpdateException();
		return flag;
	}

	@Override
	public Boolean deleteEmployeeById(Integer id) {
		boolean flag =false;
		Boolean isEmpExists = employeeRepository.existsById(id);
		if(isEmpExists) {
			employeeRepository.deleteById(id);
		flag=true;
		}
		else
			throw new EmployeeNotFoundException();
			return flag;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Manager manager = managerRepository.findById(username).get();
		User user=new User(manager.getEmail(), manager.getPassword(), manager.getRoles().stream().map(role->
				new SimpleGrantedAuthority(role)).collect(Collectors.toList()));
		return user;
	}

}
