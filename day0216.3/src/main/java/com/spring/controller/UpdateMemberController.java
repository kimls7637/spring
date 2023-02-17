package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class UpdateMemberController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo.setMid(id);
		mvo.setMpw(pw);
		mvo.setMname(name);
		mvo.setRole(role);
		if(mdao.updateMember(mvo)) {
			request.setAttribute("msg", "정보변경 성공");
		} else {
			request.setAttribute("msg", "정보변경 실패");
		}
		return "mypage.do";
	}

}
