package com.assignment.offer.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.offer.model.OfferStatus;
import com.assignment.offer.service.OfferStatusService;

import static org.mockito.Mockito.when;

/**
 * Unit tests for {@link OfferController}.
 * <p>
 * This test class verifies the behavior of the {@link OfferController} when
 * handling various requests.
 * </p>
 */
@WebMvcTest(OfferController.class)
class OfferControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private OfferStatusService offerStatusService;

	@BeforeEach
	void setUp() {
		when(offerStatusService.getOffersWithStatusByCustomerId("customer1"))
				.thenReturn(Collections.singletonList(new OfferStatus(null, "status")));
	}

	/**
	 * Test that a valid request to get offers by customer ID returns a 200 OK
	 * response.
	 * 
	 * @throws Exception if an error occurs during request execution
	 */
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void whenValidCustomerId_thenReturns200() throws Exception {
		mockMvc.perform(get("/customers/customer1/offers")).andExpect(status().isOk());
	}

	/**
	 * Test that an invalid request to get offers by customer ID returns a 404 Not
	 * Found response.
	 * 
	 * @throws Exception if an error occurs during request execution
	 */
	@Test
	@WithMockUser(username = "user", password = "password", roles = "USER")
	void whenInvalidCustomerId_thenReturns404() throws Exception {
		mockMvc.perform(get("/customers/invalidCustomerId/offers")).andExpect(status().isNotFound());
	}
}
