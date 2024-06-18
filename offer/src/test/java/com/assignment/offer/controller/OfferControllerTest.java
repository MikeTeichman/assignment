package com.assignment.offer.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Collections;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.assignment.offer.model.Offer;
import com.assignment.offer.model.OfferStatus;
import com.assignment.offer.service.OfferStatusService;

public class OfferControllerTest {

    @Mock
    private OfferStatusService offerStatusService;

    @InjectMocks
    private OfferController offerController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(offerController).build();
    }

    @Test
    public void testGetOffersByCustomerId() throws Exception {
        OfferStatus offerStatus = new OfferStatus(new Offer("offer1", "customer1", null, null), "CREATED");
        when(offerStatusService.getOffersWithStatusByCustomerId("customer1")).thenReturn(Collections.singletonList(offerStatus));

        mockMvc.perform(get("/customers/customer1/offers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'offer':{'id':'offer1','customerId':'customer1'},'status':'CREATED'}]"));
    }
}