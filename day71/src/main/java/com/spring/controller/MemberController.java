package com.spring.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.member.MemberService;
import com.spring.biz.member.MemberVO;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;

	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(@ModelAttribute("user")MemberVO vo) {
		System.out.println("loginView() 입장");
		
		vo.setMid("test");
		vo.setMpw("1234");
		
		return "login.jsp";
	}
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String selectOneMember(MemberVO vo,HttpSession session) {
		System.out.println("selectOneMember() 입장");

		if(vo.getMid().equals("timo")) {
	         throw new IllegalArgumentException("내가만든에러");
	     }
		
		vo=memberService.selectOne(vo);
		
		if(vo==null) {
			return "redirect:login.do";
		}
		else {
			session.setAttribute("member", vo);
			return "redirect:main.do";
		}
	}
	
	@RequestMapping(value="/logout.do")
	public String logoutMember(HttpSession session) {
		System.out.println("logoutMember() 입장");

		session.invalidate();
		
		return "redirect:login.do";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String signupView() {
		System.out.println("signupView() 입장");
				
		return "signup.jsp";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public String insertMember(MemberVO vo) {
		System.out.println("insertMember() 입장");
		
		memberService.insertMember(vo);

		return "redirect:login.do";
	}

}
