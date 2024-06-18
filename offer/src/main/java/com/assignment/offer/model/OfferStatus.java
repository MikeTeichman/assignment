package com.assignment.offer.model;

/**
 * Represents the status of an offer.
 */
public class OfferStatus {
	private Offer offer;
	private String status;

	/**
	 * Constructs a new OfferStatus with the specified offer and status.
	 *
	 * @param offer  the offer
	 * @param status the status of the offer
	 */
	public OfferStatus(Offer offer, String status) {
		this.offer = offer;
		this.status = status;
	}

	/**
	 * Gets the offer.
	 *
	 * @return the offer
	 */
	public Offer getOffer() {
		return offer;
	}

	/**
	 * Sets the offer.
	 *
	 * @param offer the offer
	 */
	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	/**
	 * Gets the status of the offer.
	 *
	 * @return the status of the offer
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status of the offer.
	 *
	 * @param status the status of the offer
	 */
	public void setStatus(String status) {
		this.status = status;
	}
}