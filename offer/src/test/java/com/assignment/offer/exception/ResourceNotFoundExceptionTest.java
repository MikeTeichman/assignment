package com.assignment.offer.exception;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ResourceNotFoundExceptionTest {

	@Test
	void testResourceNotFoundExceptionMessage() {
		String errorMessage = "Resource not found";
		ResourceNotFoundException exception = assertThrows(ResourceNotFoundException.class, () -> {
			throw new ResourceNotFoundException(errorMessage);
		});
		assertEquals(errorMessage, exception.getMessage());
	}
}
