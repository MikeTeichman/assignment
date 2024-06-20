package com.assignment.offer.config;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Custom Basic Authentication Entry Point that handles unauthorized access attempts.
 */
@Component
public class CustomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    /**
     * Commences an authentication scheme.
     *
     * @param request   that resulted in an {@code AuthenticationException}
     * @param response  so that the user agent can begin authentication
     * @param authEx    that caused the invocation
     * @throws IOException if an input or output exception occurred
     */
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx)
            throws IOException {
        response.addHeader("WWW-Authenticate", "Basic realm=\"" + getRealmName() + "\"");
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        PrintWriter writer = response.getWriter();
        writer.println("HTTP Status 401 - " + authEx.getMessage());
    }

    /**
     * Sets the realm name after properties are set.
     */
    @Override
    public void afterPropertiesSet() {
        setRealmName("Your Realm");
        super.afterPropertiesSet();
    }
}
