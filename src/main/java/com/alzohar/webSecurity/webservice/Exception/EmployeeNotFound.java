package com.alzohar.webSecurity.webservice.Exception;

public class EmployeeNotFound extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public EmployeeNotFound(String message) {
		super(message);
	}
}
