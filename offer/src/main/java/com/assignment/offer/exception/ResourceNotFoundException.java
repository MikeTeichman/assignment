package com.assignment.offer.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Exception thrown when a requested resource is not found.
 *
 * <p>This exception can be thrown by any service or controller method when a requested
 * resource (such as an offer or contract) cannot be found. It is typically caught by the 
 * GlobalExceptionHandler, which returns a 404 Not Found response to the client.</p>
 */
public class ResourceNotFoundException extends RuntimeException {

	
	private static final Logger logger = LoggerFactory.getLogger(ResourceNotFoundException.class);
    /**
	 * 
	 */
	private static final long serialVersionUID = -1797705150394020369L;

	/**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message the detail message
     */
    public ResourceNotFoundException(String message) {
        super(message);
        logger.debug("ResourceNotFoundException created with message: {}", message);
    }
}
