package com.example.springsecuritydemoapp.filter;

import jakarta.servlet.*;

import java.io.IOException;
import java.util.logging.Logger;

public class AuthoritiesLoggingAtFilter implements Filter {

    Logger LOG = Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
LOG.info("authentication is in progress");
        filterChain.doFilter(servletRequest,servletResponse);
        LOG.info("authentication is completed");
    }
}
