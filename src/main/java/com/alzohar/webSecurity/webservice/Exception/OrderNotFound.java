package com.alzohar.webSecurity.webservice.Exception;

public class OrderNotFound extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public OrderNotFound(String message) {
		super(message);
	}
}
