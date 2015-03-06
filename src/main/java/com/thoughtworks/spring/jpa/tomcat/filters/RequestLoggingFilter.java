package com.thoughtworks.spring.jpa.tomcat.filters;


import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.thoughtworks.spring.jpa.tomcat.commons.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RequestLoggingFilter implements Filter {

    public static final String NEED_FILTER_URLS = "needFilterUrls";
    public static final String LOGIN = "/login";
    private String needFilterUrls;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String initParameter = filterConfig.getInitParameter(NEED_FILTER_URLS);
        if(!Strings.isNullOrEmpty(initParameter)) {
            needFilterUrls = initParameter;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;
            HttpSession session = httpServletRequest.getSession();
        if (session != null) {
            Iterable<String> needFilterUrl = Splitter.on(",").split(needFilterUrls);
            if (Iterables.contains(needFilterUrl,httpServletRequest.getRequestURI())) {
                String status = (String)session.getAttribute(Constants.LOGIN_KEY);
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
