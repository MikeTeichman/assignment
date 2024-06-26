package com.assignment.offer.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.assignment.offer.model.Offer;
import com.assignment.offer.service.OfferService;

/**
 * Mock implementation of the OfferService interface.
 */
@Service
public class MockOfferService implements OfferService {

	private static final Logger logger = LoggerFactory.getLogger(MockOfferService.class);

	/**
	 * Simulates fetching offers for a specific customer by customer ID.
	 *
	 * @param customerId the ID of the customer
	 * @return a list of mock offers
	 */
	@Override
	public List<Offer> getOffersByCustomerId(String customerId) {
		logger.debug("Fetching offers for customerId: {}", customerId);
		List<Offer> lOffer = new ArrayList<Offer>();
		// Simulate fetching offers for different customers
		switch (customerId) {
		case "customer1":
			lOffer = Arrays.asList(new Offer("offer1", customerId, null, null),
					new Offer("offer2", customerId, LocalDateTime.now().minusDays(5), null), new Offer("offer3",
							customerId, LocalDateTime.now().minusDays(10), LocalDateTime.now().minusDays(1)));
			break;
		case "customer2":
			lOffer = Arrays.asList(new Offer("offer4", customerId, LocalDateTime.now().minusDays(6), null), new Offer(
					"offer5", customerId, LocalDateTime.now().minusDays(8), LocalDateTime.now().minusDays(3)));
			break;
		}
		logger.info("Offers found for customerId {}: {}", customerId, lOffer);
		return lOffer;

	}
}