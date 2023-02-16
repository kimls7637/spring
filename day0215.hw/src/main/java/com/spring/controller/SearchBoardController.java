package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class SearchBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		String title = request.getParameter("title");
		bvo.setTitle(title);
		request.setAttribute("bList", bdao.selectAllSearch(bvo));
		return "test3";
	}

}
