package com.exaple.springboot.swagger.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exaple.springboot.swagger.bean.ErrorResponse;
import com.exaple.springboot.swagger.controllers.RecordNotFoundException;
import com.exaple.springboot.swagger.controllers.ResourceNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

	@ExceptionHandler(RecordNotFoundException.class)
	public ErrorResponse handleRecordNotFound(RecordNotFoundException ex, HttpServletRequest request) {

		ErrorResponse err = new ErrorResponse(ex.getMessage(), "105", request.getRequestURI());
		return err;

	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleRecordNotFound1(RecordNotFoundException ex, HttpServletRequest request) {

		ErrorResponse err = new ErrorResponse(ex.getMessage(), "105", request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());

	}

}
