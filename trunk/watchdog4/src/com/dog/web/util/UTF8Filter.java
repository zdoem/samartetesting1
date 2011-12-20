package com.dog.web.util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
/*
 * date:2011-12-12
 * author: pradoem wongkraso
 * contact : go2doem@gmail.com,destar_@hotmail.com
 * description: this is class Utility for use  frequent 
 * */

/**
 * Servlet Filter implementation class UTF8Filter
 */
public class UTF8Filter implements Filter {
     
    /**
     * Default constructor. 
     */
	FilterConfig filterConfig;
	
    public UTF8Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");		
		//request.setCharacterEncoding("tis-620");
		
	     System.out.println("******* doFilter ********");
		 // pass the request along the filter chain
		 chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		filterConfig = fConfig;
	}

}
