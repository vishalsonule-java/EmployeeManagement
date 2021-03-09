package com.mb.EmpMangApp.exception;

public class ManagerNotSavedException extends RuntimeException {

	private static final long serialVersionUID = -6172586339011038509L;

	public ManagerNotSavedException(String msg) {
		super(msg);
	}
	
	public ManagerNotSavedException() {
		//  default constructor
	}
	
}
