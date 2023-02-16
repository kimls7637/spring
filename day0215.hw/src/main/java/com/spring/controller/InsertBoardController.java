package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class InsertBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = (String)request.getSession().getAttribute("id");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setTitle(title);
		bvo.setContent(content);
		bvo.setWriter(id);
		if(bdao.insertBoard(bvo)) {
			request.setAttribute("msg", "게시글 작성 성공");
		} else {
			request.setAttribute("msg", "게시글 작성 실패");
		}
		return "mypage.do";
	}

}
