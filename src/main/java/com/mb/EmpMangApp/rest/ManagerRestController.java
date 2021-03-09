package com.mb.EmpMangApp.rest;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mb.EmpMangApp.config.PropertyConfig;
import com.mb.EmpMangApp.constent.AppConstent;
import com.mb.EmpMangApp.entity.Employee;
import com.mb.EmpMangApp.entity.Manager;
import com.mb.EmpMangApp.model.LoginInfo;
import com.mb.EmpMangApp.model.TokenInfo;
import com.mb.EmpMangApp.service.ManagerService;
import com.mb.EmpMangApp.util.JwtUtil;

@RestController
@RequestMapping("/manager")
public class ManagerRestController {

	@Autowired
	private ManagerService service;
	
	@Autowired
	private PropertyConfig propConfig;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager manager;
	
	private HashMap<String,String> createMsg(){
		System.out.println(propConfig);
		HashMap<String,String> message=null;
		if(message==null)
			message= propConfig.getProperties();
			return message;
	}
	
	
	@PostMapping("/save")
	public ResponseEntity<String> handleSignUpMangerLink(@RequestBody Manager manager){
		
		Boolean isMangerSaved = service.saveManager(manager);
		if(isMangerSaved)
			return new  ResponseEntity<String>(propConfig.getProperties().get(AppConstent.empSaveSucc),HttpStatus.CREATED);
		else
			return new  ResponseEntity<String>(createMsg().get(AppConstent.mangSaveFail),HttpStatus.BAD_REQUEST);
			
	}
	
	@PostMapping("/employee/save")
	public ResponseEntity<String> handleAddEmployeeButton(@RequestBody Employee employee){
		
		Boolean isEmpSaved = service.saveEmployee(employee);
		if(isEmpSaved)
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empSaveSucc),HttpStatus.CREATED);
		else
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empSaveFail),HttpStatus.BAD_REQUEST);
			
	}
	
	@PostMapping("/employee/update")
	public ResponseEntity<String> handleUpdateEmployeeButton(@RequestBody Employee employee){
		
		Boolean isEmpUpdate = service.saveEmployee(employee);
		if(isEmpUpdate)
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empUpdateSucc),HttpStatus.CREATED);
		else
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empUpdateFail),HttpStatus.BAD_REQUEST);
			
	}
	
	@PostMapping("/employee/delete/{id}")
	public ResponseEntity<String> handleDeleteEmployeeButton(@PathVariable("id") Integer id){
		
		Boolean isEmpDelete = service.deleteEmployeeById(id);
		if(isEmpDelete)
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empDeleteSucc),HttpStatus.OK);
		else
			return new  ResponseEntity<String>(createMsg().get(AppConstent.empDeleteFail),HttpStatus.BAD_REQUEST);
			
	}
	
	@GetMapping("/employee/findEmp/{id}")
	public ResponseEntity<Employee> FindEmployee(@PathVariable("id") Integer id){
		
		Employee emp = service.getEmployeeById(id);
		if(emp!=null)
			return new  ResponseEntity<Employee>(emp,HttpStatus.OK);
		else
			return new  ResponseEntity<Employee>(emp=null,HttpStatus.BAD_REQUEST);
			
	}
	
	@GetMapping("/employee/findAllEmp")
	public ResponseEntity<List<Employee>>FindAllEmployee(){
		
		List<Employee> list=service.getAllEmployee();
		if(list==null)
			return new  ResponseEntity<List<Employee>>(list=null,HttpStatus.BAD_REQUEST);
		else
			return new  ResponseEntity<List<Employee>>(list,HttpStatus.OK);
			
			
	}
	
	@PostMapping("/login")
	public ResponseEntity<TokenInfo> loginUser(@RequestBody LoginInfo loginInfo){
		// validate user name and password with data base
		manager.authenticate(new UsernamePasswordAuthenticationToken(loginInfo.getEmail(),loginInfo.getPassword()));
		
		String token = jwtUtil.generateToken(loginInfo.getEmail());
		
		return new ResponseEntity<TokenInfo>(new TokenInfo("Sucess", token),HttpStatus.OK);
	}
}
