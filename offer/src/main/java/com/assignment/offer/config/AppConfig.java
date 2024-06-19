package com.assignment.offer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for defining application-wide beans.
 */
@Configuration
public class AppConfig {

	private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);
	/**
     * Creates and configures a RestTemplate bean.
     *
     * <p>The RestTemplate is a synchronous client to perform HTTP requests,
     * exposing a simple, template method API over underlying HTTP client libraries.</p>
     *
     * <p>The purpose of defining RestTemplate as a bean:</p>
     * <ul>
     *   <li><strong>Reuse:</strong> Allows for reusing the same RestTemplate instance across the application.</li>
     *   <li><strong>Configuration:</strong> Ensures that any configurations (e.g., custom request factories, interceptors)
     *       are applied globally to all RestTemplate instances in the application.</li>
     *   <li><strong>Testing:</strong> Simplifies testing by allowing the RestTemplate bean to be easily mocked.</li>
     * </ul>
     *
     * @return a configured RestTemplate instance
     */
    @Bean
    public RestTemplate restTemplate() {
    	logger.debug("Creating RestTemplate bean");
    	return new RestTemplate();
    }
}