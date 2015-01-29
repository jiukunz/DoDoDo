package com.thoughtworks.spring.jpa.tomcat.filters;


import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

public class RequestLoggingFilter implements Filter {

    public static final String LOGIN_STATUS = "LOGIN_STATUS";
    public static final String NO_FILTER_URLS = "noFilterUrls";
    public static final String LOGIN = "/login";
    private String noFilterUrls;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParameter = filterConfig.getInitParameter(NO_FILTER_URLS);
        if(!Strings.isNullOrEmpty(initParameter)) {
            noFilterUrls = initParameter;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            Iterable<String> noFilterUrl = Splitter.on(",").split(noFilterUrls);
            if (!Iterables.contains(noFilterUrl,httpServletRequest.getRequestURI())) {
                String status = (String)session.getAttribute(LOGIN_STATUS);
                if (Strings.isNullOrEmpty(status) || !Objects.equals(status, "login")) {
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
