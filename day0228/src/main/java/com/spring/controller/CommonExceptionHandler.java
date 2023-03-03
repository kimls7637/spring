package com.spring.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice("com.spring.view")
public class CommonExceptionHandler {

		@ExceptionHandler(ArithmeticException.class)
		public ModelAndView handleArtihmeticException(Exception e) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.setViewName("/error/error01.jsp");
			return mav;
		}
		
		@ExceptionHandler(Exception.class)
		public ModelAndView handleException(Exception e) {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.setViewName("/error/error02.jsp");
			return mav;
		}
}
