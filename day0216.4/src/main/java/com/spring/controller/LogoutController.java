package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LogoutController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:login.jsp");
		request.getSession().setAttribute("id", null);
		return mav;
	}

}
