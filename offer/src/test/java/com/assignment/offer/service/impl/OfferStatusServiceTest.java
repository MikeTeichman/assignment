package com.assignment.offer.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.assignment.offer.model.Contract;
import com.assignment.offer.model.Offer;
import com.assignment.offer.model.OfferStatus;
import com.assignment.offer.service.ContractService;
import com.assignment.offer.service.OfferService;
import com.assignment.offer.service.OfferStatusService;

public class OfferStatusServiceTest {

	@Mock
	private OfferService offerService;

	@Mock
	private ContractService contractService;

	@InjectMocks
	private OfferStatusService offerStatusService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetOffersWithStatusByCustomerId_inProgress() {
		Offer offer = new Offer("offer1", "customer1", LocalDateTime.now().minusDays(5), null);
		when(offerService.getOffersByCustomerId("customer1")).thenReturn(Collections.singletonList(offer));
		when(contractService.getContractsByOfferId("offer1")).thenReturn(Collections.emptyList());

		List<OfferStatus> result = offerStatusService.getOffersWithStatusByCustomerId("customer1");

		assertEquals(1, result.size());
		assertEquals("IN PROGRESS", result.get(0).getStatus());
	}

	@Test
	public void testGetOffersWithStatusByCustomerId_rejected() {
		Offer offer = new Offer("offer2", "customer1", LocalDateTime.now().minusDays(10),
				LocalDateTime.now().minusDays(1));
		when(offerService.getOffersByCustomerId("customer1")).thenReturn(Collections.singletonList(offer));
		when(contractService.getContractsByOfferId("offer2")).thenReturn(Collections.emptyList());

		List<OfferStatus> result = offerStatusService.getOffersWithStatusByCustomerId("customer1");

		assertEquals(1, result.size());
		assertEquals("REJECTED", result.get(0).getStatus());
	}

	@Test
	public void testGetOffersWithStatusByCustomerId_converted() {
		Offer offer = new Offer("offer3", "customer1", LocalDateTime.now().minusDays(15), null);
		Contract contract = new Contract();
		contract.setOfferId("offer3");
		when(offerService.getOffersByCustomerId("customer1")).thenReturn(Collections.singletonList(offer));
		when(contractService.getContractsByOfferId("offer3")).thenReturn(Collections.singletonList(contract));

		List<OfferStatus> result = offerStatusService.getOffersWithStatusByCustomerId("customer1");

		assertEquals(1, result.size());
		assertEquals("CONVERTED", result.get(0).getStatus());
	}

	@Test
	public void testGetOffersWithStatusByCustomerId_created() {
		Offer offer = new Offer("offer4", "customer1", null, null);
		when(offerService.getOffersByCustomerId("customer1")).thenReturn(Collections.singletonList(offer));
		when(contractService.getContractsByOfferId("offer4")).thenReturn(Collections.emptyList());

		List<OfferStatus> result = offerStatusService.getOffersWithStatusByCustomerId("customer1");

		assertEquals(1, result.size());
		assertEquals("CREATED", result.get(0).getStatus());
	}
}