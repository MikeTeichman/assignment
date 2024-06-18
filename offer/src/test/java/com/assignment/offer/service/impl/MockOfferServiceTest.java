package com.assignment.offer.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.assignment.offer.model.Offer;

public class MockOfferServiceTest {

    private final MockOfferService mockOfferService = new MockOfferService();

    @Test
    public void testGetOffersByCustomerId() {
        List<Offer> offers = mockOfferService.getOffersByCustomerId("customer1");

        assertEquals(2, offers.size());

        Offer offer1 = offers.get(0);
        assertEquals("offer1", offer1.getId());
        assertEquals("customer1", offer1.getCustomerId());
        assertEquals(LocalDateTime.now().minusDays(5).getDayOfMonth(), offer1.getCreationDate().getDayOfMonth());
        assertEquals(null, offer1.getRejectionDate());

        Offer offer2 = offers.get(1);
        assertEquals("offer2", offer2.getId());
        assertEquals("customer1", offer2.getCustomerId());
        assertEquals(LocalDateTime.now().minusDays(10).getDayOfMonth(), offer2.getCreationDate().getDayOfMonth());
        assertEquals(LocalDateTime.now().minusDays(1).getDayOfMonth(), offer2.getRejectionDate().getDayOfMonth());
    }
}