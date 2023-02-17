package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class MypageController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		MemberDAO mdao = new MemberDAO();
		MemberVO mvo = new MemberVO();
		String id = (String)request.getSession().getAttribute("id");
		mvo.setMid(id);
		System.out.println(mvo);
		MemberVO result = mdao.selectOne(mvo);
		request.setAttribute("member", result);
		System.out.println("리저트는 "+result);
		return "test2";
	}

}
