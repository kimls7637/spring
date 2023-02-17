package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class UpdateBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setBid(bid);
		bvo.setTitle(title);
		bvo.setContent(content);
		if(bdao.updateBoard(bvo)) {
			request.setAttribute("msg", "게시글 수정 성공");
		} else {
			request.setAttribute("msg", "게시글 수정 실패");
		}
		return "mypage.do";
	}

}
