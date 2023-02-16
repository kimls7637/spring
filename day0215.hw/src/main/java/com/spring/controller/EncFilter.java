package com.spring.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

@SuppressWarnings("serial")
@WebFilter("*.do")
public class EncFilter extends HttpFilter implements Filter {
       
    @SuppressWarnings("unused")
	private String encoding;
    
    public EncFilter() {
        super();
    }

   public void destroy() {
   }

   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html;charset=utf-8");
      chain.doFilter(request, response);
   }

   public void init(FilterConfig fConfig) throws ServletException {
      this.encoding=fConfig.getServletContext().getInitParameter("encoding");
   }

}