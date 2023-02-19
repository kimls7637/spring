package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.member.MemberDAO;
import com.spring.biz.member.MemberVO;

@Controller
public class MemberController {

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
//	public String loginView(@ModelAttribute("user")MemberVO vo) {
	public String loginView(MemberVO vo) {
		System.out.println("login.jsp로 이동");
		vo.setMid("test");
		vo.setMpw("1234");
		System.out.println("vo확인" + vo);
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String selectOneMember(MemberVO vo,MemberDAO memberDAO,HttpSession session) {
		System.out.println("LoginController 입장");

		vo=memberDAO.selectOne(vo);
		
		if(vo==null) {
			return "redirect:login.jsp";
		}
		else {
			session.setAttribute("member", vo);
			return "redirect:main.do";
		}
	}
	
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String insertMember(MemberVO vo,MemberDAO memberDAO) {
		System.out.println("JoinController 입장");

		if(memberDAO.insertMember(vo)) {
			System.out.println("회원가입성공");
			vo.setMsg("회원가입성공");
			vo.setUrl("login.do");
			return "alertPage.jsp";
		}
		else {
			System.out.println("회원가입실패");
			vo.setMsg("회원가입실패");
			vo.setUrl("login.do");
			return "alertPage.jsp";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logoutMember(HttpSession session) {
		System.out.println("LogoutController 입장");

		session.invalidate();
		
		return "redirect:login.do";
	}

}
