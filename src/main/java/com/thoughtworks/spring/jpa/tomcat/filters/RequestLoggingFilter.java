package com.thoughtworks.spring.jpa.tomcat.filters;


import com.google.common.base.Strings;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

/**
 * Created by tshen on 1/22/15.
 */
public class RequestLoggingFilter implements Filter {

    public static final String LOGIN_STATUS = "LOGIN_STATUS";
    public static final String LOGIN = "/login";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
        HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            if (!Objects.equals(httpServletRequest.getRequestURI(), LOGIN)) {
                String status = (String)session.getAttribute(LOGIN_STATUS);
                if (Strings.isNullOrEmpty(status)) {
                    httpServletResponse.sendRedirect(LOGIN);
                    return;
                }
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
