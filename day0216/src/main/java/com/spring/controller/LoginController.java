package com.spring.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 컨트롤러 수행 결과로 모델과 뷰를 준다
		
		System.out.println("LoginController 입장");
		
		// 사용자가 전달한 정보를 추출
		// M 파트와 작업
		
		MemberDAO mdao = new MemberDAO();
		MemberVO vo = new MemberVO();
		vo.setMid(request.getParameter("mid"));
		vo.setMpw(request.getParameter("mpw"));
		vo = mdao.selectOne(vo);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("main.do");
		
		if(vo == null) {
			mav.setViewName("login.jsp");
		}
		
		return mav;
		
	}

//	@Override
//	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		System.out.println("LoginController 입장");
//		
//		// 사용자가 전달한 정보를 추출
//		// M 파트와 작업
//		String msg = request.getParameter("msg");
//		BoardDAO boardDAO = new BoardDAO();
//		BoardVO vo = new BoardVO();
//		vo.setTitle("TEST");
//		vo.setWriter("KIM");
//		vo.setContent(msg);
//		boardDAO.insertBoard(vo);
//		
//		return "test2"; // ".jsp"를 생략하여 반환!
//		// return "main.do"; --->> ".xxx"가 존재한다면, VR가 알아서 경로 관리해줌!
//	}

}
