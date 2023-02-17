package com.spring.controller;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("LoginController 입장");

		// 사용자가 전달한 정보를 추출
		// M 파트와 작업
		MemberDAO memberDAO=new MemberDAO();
		MemberVO vo=new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo=memberDAO.selectOne(vo);

		ModelAndView mav=new ModelAndView();
		mav.setViewName("redirect:main.do");
		if(vo==null) {
//			response.setCharacterEncoding("UTF-8");
//			response.setContentType("text/html; charset=UTF-8");
//			PrintWriter out = response.getWriter();
//	          out.println("<script>alert('로그인 실패'); </script>");
//	          out.flush();
//	          out.close();
			mav.setViewName("redirect:login.jsp");
		} else {
			request.getSession().setAttribute("id", vo.getMid());
		}
		return mav;
	}

}
