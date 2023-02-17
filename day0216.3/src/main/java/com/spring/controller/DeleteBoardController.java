package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class DeleteBoardController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int bid = Integer.parseInt(request.getParameter("bid"));
		BoardDAO bdao = new BoardDAO();
		BoardVO bvo = new BoardVO();
		bvo.setBid(bid);
		if(bdao.deleteBoard(bvo)) {
			request.setAttribute("msg", "게시글 삭제 성공");
		} else {
			request.setAttribute("msg", "게시글 삭제 실패");
		}
		return "mypage.do";
	}

}
