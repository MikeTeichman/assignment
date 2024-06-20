package com.assignment.offer.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.assignment.offer.model.Offer;

public class MockOfferServiceTest {

	private final MockOfferService mockOfferService = new MockOfferService();

	@Test
	public void testGetOffersByCustomerId() {
		List<Offer> offersCust1 = mockOfferService.getOffersByCustomerId("customer1");

		assertEquals(3, offersCust1.size());

		Offer offer1 = offersCust1.get(0);
		assertEquals("offer1", offer1.getId());
		assertEquals("customer1", offer1.getCustomerId());
		assertNull(offer1.getCreationDate());
		assertNull(offer1.getRejectionDate());

		Offer offer2 = offersCust1.get(1);
		assertEquals("offer2", offer2.getId());
		assertEquals("customer1", offer2.getCustomerId());
		assertEquals(LocalDateTime.now().minusDays(5).format(DateTimeFormatter.ofPattern("dd-MM-yyyy")), offer2.getCreationDate().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
		assertNull(offer2.getRejectionDate());
	}
}