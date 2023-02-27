package com.spring.controller;

import org.springframework.stereotype.Controller;



// Controller 자동 임포트 - 스프링에서 제공해주는 MVC Controller 받아옴★
// 오버라이딩 강제

@Controller
public class MemberController {
	
//	@RequestMapping(value="/join.do", method=RequestMethod.GET)
//	public String insertMemberView(MemberVO vo, MemberDAO memberDAO,Model model) {
//		// @ModelAttribute("user") -> 뷰에서 이렇게 사용 value="${user.mId}"
//		System.out.println("joinController 입장");
//	
//		return "join.jsp";
//		
//	}
//	
//	@RequestMapping(value="/join.do", method=RequestMethod.POST)
//	public String insertMember(MemberVO vo, MemberDAO memberDAO,Model model) {
//		System.out.println("joinController 입장");
//		
//		if(memberDAO.insertMember(vo)) {
//			model.addAttribute("msg", "회원가입 성공");
//			model.addAttribute("url", "login.jsp");
//		}
//		return "alert.jsp";
//		
//	}
//	
//	
//	// 멤버컨트롤러에서 테스트계정
//		@RequestMapping(value="/login.do", method=RequestMethod.GET)
//		public String loginView(@ModelAttribute("user")MemberVO vo) {
//			// @ModelAttribute("user") -> 뷰에서 이렇게 사용 value="${user.mId}"
//			System.out.println("login.jsp로 이동");
//			// login.jsp로 이동할적에 이 화면에 테스트계정을 뿌릴것
//			vo.setmId("test");
//			vo.setmPw("1234");
//
//			return "login.jsp";
//		}
//
//	// 같은 요청이어도 방식이 어떤지에 따라 다르게 진행될 예정 ★★★
//	@RequestMapping(value="/login.do", method=RequestMethod.POST) // HM대신해주는 어노테이션
//	public String selectOneMember(MemberVO vo, MemberDAO memberDAO,HttpSession session,Model model) {
//		System.out.println("LoginController 입장");
//
//		MemberVO member=memberDAO.selectOne(vo);
//		if(member!=null) { // 로그인 성공
//			// 기존에 인자가 request, response로 고정되어있었기때문에
//			// 세션을 리퀘스트로부터 뽑아내서 사용하는방법밖에없다
//			session.setAttribute("member", member);  
//			// Spring 디폴트 == forward
//			// "redirect:" 붙이면 Spring이 알아서 redirect로 보내줌
//			// redirect는 prefix,suffix가 안 붙음
//			// 보통 세션에 로그인 정보 저장하게되면 redirect로 보내도 됨
//			return "redirect:main.do";
//		}
//		else { // 로그인실패
//			model.addAttribute("msg", "로그인 실패");
//			model.addAttribute("url", "login.jsp");
//			return "alert.jsp";
//		}
//	}
//		
//		// 현재 handleRequest(== execute)는 mav를 반환하기때문에
//		// mav객체 만들어주고 반환하는 형태로 맞춰줌
//
//	@RequestMapping(value="/logout.do") // HM대신해주는 어노테이션
//	public String logoutMember(HttpSession session) {
//		System.out.println("LogoutController 입장");
//		session.invalidate(); // 세션 비워줌 
//
//		// 모델이있을이유가 없음 -> 아웃풋 String으로
//		return "main.jsp";
//
//	}

}
