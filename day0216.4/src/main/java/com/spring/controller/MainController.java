package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;

public class MainController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainController 입장");
		
		BoardDAO boardDAO=new BoardDAO();
		
//		request.getSession().setAttribute("datas", boardDAO.selectAll(null));
		
		ModelAndView mav=new ModelAndView();
		mav.addObject("datas", boardDAO.selectAll(null));
		mav.setViewName("main");
		return mav;
	}

}
