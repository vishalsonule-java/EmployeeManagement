package com.mb.EmpMangApp.exception;

public class EmployeeNotSavedException extends RuntimeException {


	private static final long serialVersionUID = 3246074173718114658L;
	
	public EmployeeNotSavedException(String msg) {
		super(msg);
	}

	public EmployeeNotSavedException() {
		//default constructor
	}
}
