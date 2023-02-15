package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

public class LoginController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginController 입장");
		
		// 사용자가 전달한 정보를 추출
		// M 파트와 작업
		String msg = request.getParameter("msg");
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		vo.setTitle("TEST");
		vo.setWriter("KIM");
		vo.setContent(msg);
		boardDAO.insertBoard(vo);
		
		// 응답
		return "test2"; // ".jsp"를 생략하여 반환!
		// return "main.do"; --->> ".xxx"가 존재한다면, VR가 알아서 경로 관리해줌!
		
	}

}
