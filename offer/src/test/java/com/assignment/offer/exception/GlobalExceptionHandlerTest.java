package com.assignment.offer.exception;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.offer.service.OfferStatusService;

/**
 * Unit tests for {@link GlobalExceptionHandler}.
 * <p>
 * This test class verifies that the {@link GlobalExceptionHandler} correctly
 * handles exceptions thrown by the {@link TestController} and returns the
 * appropriate HTTP status codes and messages.
 * </p>
 */
@WebMvcTest(controllers = { GlobalExceptionHandler.class, GlobalExceptionHandlerTest.TestController.class })
class GlobalExceptionHandlerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OfferStatusService offerStatusService;

	@TestConfiguration
	static class TestConfig {
		@Bean
		public GlobalExceptionHandler globalExceptionHandler() {
			return new GlobalExceptionHandler();
		}

		@Bean
		public TestController testController() {
			return new TestController();
		}
	}

	/**
	 * A test controller used to simulate endpoints that throw exceptions.
	 */
	@RestController
	static class TestController {
		@GetMapping("/test/resource/{id}")
		public String getResource(@PathVariable String id) {
			if ("notfound".equals(id)) {
				throw new ResourceNotFoundException("Resource not found");
			} else if ("error".equals(id)) {
				throw new RuntimeException("Internal Server Error");
			}
			return "Resource found";
		}
	}

	@BeforeEach
	void setUp() {
	}

	@Test
	void whenUserNotUnauthorized_thenReturns401() throws Exception {
		mockMvc.perform(get("/public/test/resource/isunauthorized")).andExpect(status().isUnauthorized());
	}

	/**
	 * Test that a {@link ResourceNotFoundException} results in a 404 Not Found
	 * response.
	 * 
	 * @throws Exception if an error occurs during request execution
	 */
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void whenResourceNotFoundException_thenReturns404() throws Exception {
		mockMvc.perform(get("/test/resource/notfound")).andExpect(status().isNotFound())
				.andExpect(content().string("Resource not found"));
	}

	/**
	 * Test that a generic {@link RuntimeException} results in a 500 Internal Server
	 * Error response.
	 * 
	 * @throws Exception if an error occurs during request execution
	 */
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void whenGenericException_thenReturns500() throws Exception {
		mockMvc.perform(get("/test/resource/error")).andExpect(status().isInternalServerError())
				.andExpect(content().string("Internal Server Error"));
	}
}
