package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;

/**
 * Servlet implementation class DispatcherServlet
 */

// Frontcontroller
// 어노테이션 살아있음
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DispatcherServlet() { // 기본생성자
        super();
        // TODO Auto-generated constructor stub
    }

    private void doAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String uri = request.getRequestURI();
    	String path = uri.substring(uri.lastIndexOf("/")); // 마지막 슬래시 기준으로 서브스트링
    	System.out.println("DS : " + path);
    	
    	if(path.equals("/login.do")) {
    		System.out.println("로그인 로직 수행");
    		
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
    		response.sendRedirect("test2.jsp");
    	}
    	else if (path.equals("/main.do")) {
    		
    	}
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doAction(request, response);
	}

}
