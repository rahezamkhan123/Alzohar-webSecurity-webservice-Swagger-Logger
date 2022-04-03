package com.alzohar.webSecurity.webservice.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alzohar.webSecurity.webservice.Exception.EmployeeNotFound;
import com.alzohar.webSecurity.webservice.Exception.InvalidTokenException;
import com.alzohar.webSecurity.webservice.Exception.OrderNotFound;
import com.alzohar.webSecurity.webservice.Exception.ProductNotFound;
import com.alzohar.webSecurity.webservice.Exception.UserAlreadyExistException;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> customerEmtyValueError(MethodArgumentNotValidException exception) {
		ExceptionResponse errorDetails = new ExceptionResponse("Validation Error", new Date(),
				HttpStatus.NOT_FOUND.name(), exception.getBindingResult().getFieldError().getDefaultMessage());

		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = ProductNotFound.class)
	public ResponseEntity<ExceptionResponse> productNotFoundexception(ProductNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

//	@ExceptionHandler(value = CustomerNotFound.class)
//	public ResponseEntity<ExceptionResponse> customerNotFoundexception(CustomerNotFound exception) {
//		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
//				exception.getClass().getSimpleName());
//		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
//	}

	@ExceptionHandler(value = OrderNotFound.class)
	public ResponseEntity<ExceptionResponse> orderNotFoundexception(OrderNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = EmployeeNotFound.class)
	public ResponseEntity<ExceptionResponse> employeeNotFoundexception(EmployeeNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<ExceptionResponse> userAlreadyExistException(UserAlreadyExistException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.BAD_REQUEST.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(value = InvalidTokenException.class)
	public ResponseEntity<ExceptionResponse> invalidTokenException(InvalidTokenException exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.UNAUTHORIZED.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.UNAUTHORIZED);
	}

}
