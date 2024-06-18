package com.assignment.offer.service;

import java.util.List;

import com.assignment.offer.model.Contract;

/**
 * Service interface for managing contracts.
 */
public interface ContractService {

    /**
     * Retrieves a list of contracts by the offer ID.
     *
     * @param offerId the ID of the offer
     * @return a list of contracts associated with the offer ID
     */
    List<Contract> getContractsByOfferId(String offerId);
}