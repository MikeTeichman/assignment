package com.assignment.offer.model;

import java.time.LocalDateTime;

/**
 * Represents an offer made to a customer.
 */
public class Offer {
	private String id;
	private String customerId;
	private LocalDateTime creationDate;
	private LocalDateTime rejectionDate;

	/**
	 * Constructs a new Offer with the specified details.
	 *
	 * @param id            the offer ID
	 * @param customerId    the customer ID
	 * @param creationDate  the creation date of the offer
	 * @param rejectionDate the rejection date of the offer
	 */
	public Offer(String id, String customerId, LocalDateTime creationDate, LocalDateTime rejectionDate) {
		this.id = id;
		this.customerId = customerId;
		this.creationDate = creationDate;
		this.rejectionDate = rejectionDate;
	}

	/**
	 * Gets the offer ID.
	 *
	 * @return the offer ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the offer ID.
	 *
	 * @param id the offer ID
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the customer ID associated with this offer.
	 *
	 * @return the customer ID
	 */
	public String getCustomerId() {
		return customerId;
	}

	/**
	 * Sets the customer ID associated with this offer.
	 *
	 * @param customerId the customer ID
	 */
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	/**
	 * Gets the creation date of the offer.
	 *
	 * @return the creation date
	 */
	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	/**
	 * Sets the creation date of the offer.
	 *
	 * @param creationDate the creation date
	 */
	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	/**
	 * Gets the rejection date of the offer.
	 *
	 * @return the rejection date
	 */
	public LocalDateTime getRejectionDate() {
		return rejectionDate;
	}

	/**
	 * Sets the rejection date of the offer.
	 *
	 * @param rejectionDate the rejection date
	 */
	public void setRejectionDate(LocalDateTime rejectionDate) {
		this.rejectionDate = rejectionDate;
	}
}