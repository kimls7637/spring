package com.spring.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
       
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
	
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
    	
    	Controller ctrl = handlerMapping.getController(path);
    	String viewName = ctrl.handleRequest(request, response);
    	
    	if(!viewName.contains(".do")) {
    		viewName = viewResolver.getView(viewName);
    	}
    	response.sendRedirect(viewName);
    	
//    	if(path.equals("/login.do")) {
//    		System.out.println("로그인 로직 수행");
//    		new LoginController().handleRequest(request, response);
//    		// 응답
//    		response.sendRedirect("test2.jsp");
//    	}
//    	else if (path.equals("/search.do")) {
//    		String search = request.getParameter("search");
//    		BoardDAO bdao = new BoardDAO();
//    		BoardVO vo = new BoardVO();
//    		vo.setWriter(search);
//    		System.out.println(search);
//    		System.out.println(bdao.selectAllSearch(vo));
//    		
//    		request.setAttribute("bList", bdao.selectAllSearch(vo));
//    		
//    		RequestDispatcher dis = request.getRequestDispatcher("test2.jsp");
//    		dis.forward(request, response);
//    	}
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
