package com.mb.EmpMangApp.exceptionHandler;

import java.util.Date;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mb.EmpMangApp.exception.EmployeeNotFoundException;
import com.mb.EmpMangApp.exception.EmployeeNotSavedException;
import com.mb.EmpMangApp.exception.EmployeeNotUpdateException;
import com.mb.EmpMangApp.exception.ManagerNotSavedException;
import com.mb.EmpMangApp.model.ErrorInfo;

@RestControllerAdvice
public class AppExceptionHandler {
	
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ErrorInfo handleEmployeeNotFoundException() {
		ErrorInfo error= new ErrorInfo();
		error.setCode(404);
		error.setMsg("Employee not found for given Id");
		error.setDate(new Date());
		return error;
	}
	
	@ExceptionHandler(ManagerNotSavedException.class)
	public ErrorInfo handleManagerNotSavedException() {
		ErrorInfo error= new ErrorInfo();
		error.setCode(400);
		error.setMsg("Manager Not Saved");
		error.setDate(new Date());
		return error;
	}
	
	@ExceptionHandler(EmployeeNotSavedException.class)
	public ErrorInfo handleEmployeeNotSavedException() {
		ErrorInfo error= new ErrorInfo();
		error.setCode(400);
		error.setMsg("Employee not Saved Please Try Again..");
		error.setDate(new Date());
		return error;
	}
	
	@ExceptionHandler(EmployeeNotUpdateException.class)
	public ErrorInfo handleEmployeeNotUpdateException() {
		ErrorInfo error= new ErrorInfo();
		error.setCode(400);
		error.setMsg("Employee not Update Please Try Again..");
		error.setDate(new Date());
		return error;
	}

}
