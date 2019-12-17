package com.target.myretail.exception;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ApiAdvice {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity handleException(ApiException exception) {
		log.error(exception.getMessage());

		return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(exception.getMessage());
	}

	@ExceptionHandler(ResourceNotFound.class)
	public ResponseEntity handleException(ResourceNotFound exception) {
		log.error(exception.getMessage());

		return ResponseEntity.status(NOT_FOUND).body(exception.getMessage());
	}
}
