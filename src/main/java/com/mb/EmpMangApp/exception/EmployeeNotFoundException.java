package com.mb.EmpMangApp.exception;

public class EmployeeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 786902108984974570L;

	public EmployeeNotFoundException(String msg) {
		super(msg);
	}

	public EmployeeNotFoundException() {
		// default constructor
	}
}
