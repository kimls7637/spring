package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		mvo.setMid(id);
		mvo.setMpw(pw);
		MemberVO result = mdao.selectOne(mvo);
		if(result != null) {
			request.getSession().setAttribute("id", result.getMid());
			request.setAttribute("member", result);
			request.setAttribute("msg", "로그인 성공");
			return "mypage.do";
		} else {
			System.out.println("로그인 실패");
			request.setAttribute("msg", "로그인 실패");
			return "test";
		}
	}

}
