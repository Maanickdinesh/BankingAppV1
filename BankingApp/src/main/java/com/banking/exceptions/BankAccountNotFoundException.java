package com.banking.exceptions;

import org.springframework.validation.BindException;

public class BankAccountNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BankAccountNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
