package com.exaple.springboot.swagger.controllers;

public class RecordNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {
		super();
	}

	public RecordNotFoundException(final String message) {
		super(message);
	}

}
