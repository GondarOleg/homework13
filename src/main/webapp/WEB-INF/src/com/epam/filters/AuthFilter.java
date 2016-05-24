package com.epam.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

/**
 * Created by Oleg on 24.05.2016.
 */
@WebFilter("/AuthenticationFilter")
public class AuthFilter implements Filter{

    private Logger logger = Logger.getLogger(AuthFilter.class);

    public void init(FilterConfig fConfig) throws ServletException {

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        String uri = req.getRequestURI();

        logger.info("Requested Resource::"+uri);

        HttpSession session = req.getSession(false);

        if(session == null && uri.endsWith("cookiesTable.html")){

            logger.error("Unauthorized access request");
            res.sendRedirect("index.html");
        }else{

            chain.doFilter(request, response);
        }


    }

    public void destroy() {

    }

}
