package com.pazz.springboot.web.filter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * @author: 彭坚
 * @create: 2018/11/20 14:55
 * @description:
 */
public class TestFilter implements Filter {

    private static ServletContext servletContext;

    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter init...");
        getServletContext(filterConfig);
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter doFilter...");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    public void destroy() {
        System.out.println("Filter destroy...");
    }

    public static void getServletContext(FilterConfig config) {
        servletContext = config.getServletContext();
    }

}
