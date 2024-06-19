package com.assignment.offer.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.offer.exception.ResourceNotFoundException;
import com.assignment.offer.model.OfferStatus;
import com.assignment.offer.service.OfferStatusService;

/**
 * REST controller for managing offers.
 */
@RestController
public class OfferController {

	private static final Logger logger = LoggerFactory.getLogger(OfferController.class);

	private final OfferStatusService offerStatusService;

	/**
	 * Constructs a new OfferController with the specified OfferStatusService.
	 *
	 * @param offerStatusService the service to handle offer status logic
	 */
	@Autowired
	public OfferController(OfferStatusService offerStatusService) {
		this.offerStatusService = offerStatusService;
	}

	/**
	 * Retrieves offers for a specific customer by customer ID.
	 *
	 * @param customerId the ID of the customer
	 * @return a list of offers with their statuses
	 */
	@GetMapping(value = "/customers/{customerId}/offers")
	public List<OfferStatus> getOffersByCustomerId(@PathVariable String customerId) {
		logger.info("Fetching offers for customerId: {}", customerId);
		List<OfferStatus> offers = offerStatusService.getOffersWithStatusByCustomerId(customerId);
		if (offers.isEmpty()) {
			throw new ResourceNotFoundException("No offers found for customer ID: " + customerId);
		}
		return offers;
	}

}