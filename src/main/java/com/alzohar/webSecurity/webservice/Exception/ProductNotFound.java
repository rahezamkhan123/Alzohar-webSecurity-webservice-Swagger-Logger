package com.alzohar.webSecurity.webservice.Exception;

public class ProductNotFound extends RuntimeException{

	private static final long serialVersionUID = 1l;

	public ProductNotFound(String message) {
		super(message);
	}
}
