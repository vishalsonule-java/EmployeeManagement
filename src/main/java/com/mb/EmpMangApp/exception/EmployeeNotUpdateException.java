package com.mb.EmpMangApp.exception;

public class EmployeeNotUpdateException extends RuntimeException {

	private static final long serialVersionUID = 4096881251345825665L;

	
	public EmployeeNotUpdateException(String msg) {
		super(msg);
	}
	
	public EmployeeNotUpdateException() {
		// default constructor
	}
}
