package com.exaple.springboot.swagger.config;

public class ResourceNotFoundException extends Exception {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException() {
		super();
	}

	public ResourceNotFoundException(final String message) {
		super(message);
	}

}
