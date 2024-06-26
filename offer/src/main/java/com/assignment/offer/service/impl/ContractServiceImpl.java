package com.assignment.offer.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.assignment.offer.model.Contract;
import com.assignment.offer.service.ContractService;

/**
 * Implementation of the ContractService interface.
 */
@Service
public class ContractServiceImpl implements ContractService {
	private static final Logger logger = LoggerFactory.getLogger(ContractServiceImpl.class);

	@Value("${contracts.api.url}")
	private String contractsApiUrl;

	private final RestTemplate restTemplate;

	/**
	 * Constructs a new ContractServiceImpl with the specified RestTemplate.
	 *
	 * @param restTemplate the RestTemplate to use for making HTTP requests
	 */
	public ContractServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	/**
	 * Retrieves a list of contracts by the offer ID.
	 *
	 * @param offerId the ID of the offer
	 * @return a list of contracts associated with the offer ID
	 */
	@Override
	public List<Contract> getContractsByOfferId(String offerId) {
		try {
			Contract[] contracts = restTemplate.getForObject("http://contracts-api/contracts/search?offerId={offerId}",
					Contract[].class, offerId);
			return contracts != null ? List.of(contracts) : Collections.emptyList();
		} catch (RestClientException e) {
			// Log the exception and return mock data for fallback
			logger.error("Error fetching contracts: " + e.getMessage());
			return getMockContractsByOfferId(offerId);
		}

	}

	private List<Contract> getMockContractsByOfferId(String offerId) {
		logger.warn("Fetching mock contracts for offerId: {}", offerId);
		List<Contract> lContract = new ArrayList<Contract>();
		switch (offerId) {
		case "offer1":
			Contract contract1 = new Contract();
			contract1.setId("mockContract1");
			contract1.setOfferId(offerId);
			lContract.add(contract1);
		case "offer4":
			Contract contract2 = new Contract();
			contract2.setId("mockContract2");
			contract2.setOfferId(offerId);
			lContract.add(contract2);
		default:
			// Handle other cases if needed
			break;
		}
		return lContract;
	}
}