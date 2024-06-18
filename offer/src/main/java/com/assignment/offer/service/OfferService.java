package com.assignment.offer.service;

import java.util.List;

import com.assignment.offer.model.Offer;

/**
 * Service interface for managing offers.
 */
public interface OfferService {

    /**
     * Retrieves a list of offers by the customer ID.
     *
     * @param customerId the ID of the customer
     * @return a list of offers associated with the customer ID
     */
    List<Offer> getOffersByCustomerId(String customerId);
}