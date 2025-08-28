package com.mjc813.swimpool_app.security;

import jakarta.servlet.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

//@Component
public class SameSiteFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest
            , ServletResponse servletResponse
            , FilterChain filterChain) throws IOException, ServletException {
//        filterChain.doFilter(servletRequest, servletResponse);
    }
}
