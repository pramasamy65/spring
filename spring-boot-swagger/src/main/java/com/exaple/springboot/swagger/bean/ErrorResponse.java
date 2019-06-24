package com.exaple.springboot.swagger.bean;

public class ErrorResponse {

	private String errorMessage;
	private String errorCode;
	private String requestedURI;

	public ErrorResponse() {

	}

	public ErrorResponse(String errorMessage, String errorCode, String requestedURI) {
		super();
		this.errorMessage = errorMessage;
		this.errorCode = errorCode;
		this.requestedURI = requestedURI;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getRequestedURI() {
		return requestedURI;
	}

	public void setRequestedURI(String requestedURI) {
		this.requestedURI = requestedURI;
	}

}
