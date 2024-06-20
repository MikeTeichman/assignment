package com.assignment.offer.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.web.client.RestTemplate;

import com.assignment.offer.model.Contract;

/**
 * Unit tests for {@link ContractServiceImpl}.
 * <p>
 * This test class verifies the behavior of the {@link ContractServiceImpl} when
 * handling various service methods.
 * </p>
 */
public class ContractServiceImplTest {

	@Mock
	private RestTemplate restTemplate;

	@InjectMocks
	private ContractServiceImpl contractService;

	/**
	 * Sets up the test environment before each test.
	 *
	 * This method initializes the mocks and injects them into the
	 * ContractServiceImpl instance.
	 */
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	/**
	 * Test that a valid contract creation returns a non-null contract.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetContractsByOfferId() {
		Contract[] contracts = { new Contract() };
		contracts[0].setId("contract1");
		contracts[0].setOfferId("offer1");

		when(restTemplate.getForObject(anyString(), any(Class.class), anyString())).thenReturn(contracts);

		List<Contract> result = contractService.getContractsByOfferId("offer1");

		assertEquals(1, result.size());
		assertEquals("contract1", result.get(0).getId());
		assertEquals("offer1", result.get(0).getOfferId());
	}
}