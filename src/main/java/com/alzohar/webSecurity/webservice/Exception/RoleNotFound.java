package com.alzohar.webSecurity.webservice.Exception;

public class RoleNotFound extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public RoleNotFound(String message) {
		super(message);
	}
}
