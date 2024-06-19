package com.assignment.offer.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.offer.exception.ResourceNotFoundException;
import com.assignment.offer.model.Offer;
import com.assignment.offer.model.OfferStatus;

/**
 * Service for managing offer statuses.
 */
@Service
public class OfferStatusService {

	private static final Logger logger = LoggerFactory.getLogger(OfferStatusService.class);
	
	private final OfferService offerService;
	private final ContractService contractService;

	/**
	 * Constructs a new OfferStatusService with the specified OfferService and
	 * ContractService.
	 *
	 * @param offerService    the service to handle offer retrieval
	 * @param contractService the service to handle contract retrieval
	 */
	@Autowired
	public OfferStatusService(OfferService offerService, ContractService contractService) {
		this.offerService = offerService;
		this.contractService = contractService;
	}

	/**
	 * Retrieves offers with their statuses for a specific customer by customer ID.
	 *
	 * @param customerId the ID of the customer
	 * @return a list of offers with their statuses
	 */
	public List<OfferStatus> getOffersWithStatusByCustomerId(String customerId) {
		logger.debug("Getting offer statuses for customerId: {}", customerId);
		List<Offer> offers = offerService.getOffersByCustomerId(customerId);
        if (offers.isEmpty()) {
            throw new ResourceNotFoundException("No offers found for customer ID: " + customerId);
        }

		return offers.stream().map(offer -> {
			String status;
			if (offer.getRejectionDate() != null) {
				status = "REJECTED";
			} else if (!contractService.getContractsByOfferId(offer.getId()).isEmpty()) {
				status = "CONVERTED";
			} else if (offer.getCreationDate() != null) {
				status = "IN PROGRESS";
			} else {
				status = "CREATED";
			}
			logger.debug("Offer ID: {}, Status: {}", offer.getId(), status);
			return new OfferStatus(offer, status);
		}).collect(Collectors.toList());
	}
}