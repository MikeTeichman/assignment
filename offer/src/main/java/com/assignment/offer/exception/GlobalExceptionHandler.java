package com.assignment.offer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global exception handler for handling exceptions across the whole
 * application.
 *
 * <p>
 * This class is annotated with @RestControllerAdvice, which makes it a
 * centralized exception handler that can catch exceptions from any controller
 * and return appropriate HTTP responses.
 * </p>
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * Handles ResourceNotFoundException and returns a 404 Not Found response.
	 *
	 * @param ex the exception that was thrown
	 * @return a ResponseEntity containing the exception message and a 404 status
	 *         code
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
		logger.error("ResourceNotFoundException: {}", ex.getMessage());
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}

	/**
	 * Handles generic exceptions and returns a 500 Internal Server Error response.
	 *
	 * @param ex the exception that was thrown
	 * @return a ResponseEntity containing the exception message and a 500 status
	 *         code
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleGenericException(Exception ex) {
		logger.error("Exception: ", ex);
		return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
