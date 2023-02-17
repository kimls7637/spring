package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class DeleteMemberController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = (String)request.getSession().getAttribute("id");
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo.setMid(id);
		if(mdao.deleteMember(mvo)) {
			BoardDAO bdao = new BoardDAO();
			BoardVO bvo = new BoardVO();
			bvo.setWriter(id);
			bdao.deleteBoard(bvo);
			request.setAttribute("msg", "회원탈퇴 성공");
		} else {
			request.setAttribute("msg", "회원탈퇴 실패");
			return "mypage.do";
		}
		return "test";
	}

}
