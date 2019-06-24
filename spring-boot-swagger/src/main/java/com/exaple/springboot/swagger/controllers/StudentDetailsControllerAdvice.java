package com.exaple.springboot.swagger.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.exaple.springboot.swagger.bean.ErrorResponse;
import com.exaple.springboot.swagger.config.RecordNotFoundException;
import com.exaple.springboot.swagger.config.ResourceNotFoundException;

@RestControllerAdvice
public class StudentDetailsControllerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorResponse handleRecordNotFound(RecordNotFoundException ex, HttpServletRequest request) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "105", request.getRequestURI());
		return err;
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleRecordNotFound1(ResourceNotFoundException ex,
			HttpServletRequest request) {
		ErrorResponse err = new ErrorResponse(ex.getMessage(), "1054", request.getRequestURI());
		return new ResponseEntity<>(err, HttpStatus.NOT_FOUND);
	}

}
