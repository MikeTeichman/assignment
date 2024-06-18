package com.assignment.offer.model;

/**
 * Represents a contract linked to an offer.
 */
public class Contract {
    private String id;
    private String offerId;

    /**
     * Gets the contract ID.
     *
     * @return the contract ID
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the contract ID.
     *
     * @param id the contract ID
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Gets the offer ID associated with this contract.
     *
     * @return the offer ID
     */
    public String getOfferId() {
        return offerId;
    }

    /**
     * Sets the offer ID associated with this contract.
     *
     * @param offerId the offer ID
     */
    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }
}