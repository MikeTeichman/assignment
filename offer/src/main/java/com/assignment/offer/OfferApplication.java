package com.assignment.offer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

/**
 * Main entry point for the Offers application.
 */
@SpringBootApplication
@RestController
public class OfferApplication {

	/**
	 * Main method to launch the Spring Boot application.
	 *
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(OfferApplication.class, args);
	}

}
