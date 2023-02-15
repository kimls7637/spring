package com.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

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
    		String id = request.getParameter("id");
    		String pw = request.getParameter("pw");
    		MemberDAO mdao = new MemberDAO();
    		MemberVO vo = new MemberVO();
    		vo.setMid(id);
    		vo.setMpw(pw);
    		mdao.selectOne(vo);
    		
    		if(mdao.selectOne(vo) != null) {
    			request.getSession().setAttribute("id", id);
    			response.sendRedirect("test2.jsp");
    		} else {
    			PrintWriter out = response.getWriter();
    			System.out.println("로그인실패");
    			out.println("<script language='javascript'>");
    			out.println("alert('로그인 실패'); history.go(-1);");
    			out.println("</script>");
    			out.flush();
    			// response.sendRedirect("test.jsp");
    		}
    	}
    	else if (path.equals("/search.do")) {
    		String search = request.getParameter("search");
    		BoardDAO bdao = new BoardDAO();
    		BoardVO vo = new BoardVO();
    		vo.setWriter(search);
    		System.out.println(search);
    		System.out.println(bdao.selectAllSearch(vo));
    		
    		request.setAttribute("bList", bdao.selectAllSearch(vo));
    		
    		RequestDispatcher dis = request.getRequestDispatcher("test3.jsp");
    		dis.forward(request, response);
    	}
    	else if (path.equals("/bList.do")) {
    		BoardDAO bdao = new BoardDAO();
    		BoardVO vo = new BoardVO();
    		System.out.println(bdao.selectAll(vo));
    		
    		request.setAttribute("bList", bdao.selectAll(vo));
    		
    		RequestDispatcher dis = request.getRequestDispatcher("test3.jsp");
    		dis.forward(request, response);
    	}
    	else if (path.equals("/insertBoard.do")) {
    		BoardDAO bdao = new BoardDAO();
    		BoardVO vo = new BoardVO();
    		String title = request.getParameter("title");
    		String content = request.getParameter("content");
    		vo.setTitle(title);
    		vo.setContent(content);
    		vo.setWriter((String)request.getSession().getAttribute("id"));
    		bdao.insertBoard(vo);
    		
    		response.sendRedirect("test2.jsp");
    	}
    	else if (path.equals("/logout.do")) {
			request.getSession().setAttribute("id", null);
			response.sendRedirect("test.jsp");
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
