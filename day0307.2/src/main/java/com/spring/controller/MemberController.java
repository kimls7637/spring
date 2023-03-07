package com.spring.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MailSendService;
import com.spring.biz.member.MemberService;
import com.spring.biz.member.MemberVO;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private MailSendService mss;


	@RequestMapping(value="/join.do", method=RequestMethod.GET)
	public String joinView(@ModelAttribute("user")MemberVO vo) {
		System.out.println("insert: join 입장");
		return "join.jsp";
	}

	//메일전송후 해당 멤버의 AUTHKEY디비에 업데이트
	@RequestMapping(value="/join.do", method=RequestMethod.POST)
	public String join(MemberVO vo, Model model) {
		System.out.println("insert: join 입장");
		memberService.insertMember(vo);

		//임의의 authKey 생성 & 이메일 발송
		String authKey = mss.sendAuthMail(vo.getmEmail());
		vo.setmAuthkey(authKey);

		Map<String, String> map = new HashMap<String, String>();
		map.put("email", vo.getmEmail());
		map.put("authKey", vo.getmAuthkey());


		//DB에 authKey 업데이트
		memberService.updateMemberChk(vo);

		model.addAttribute("msg", "회원가입을 완료하였습니다. 이메일인증 후 로그인 해주세요.");
		model.addAttribute("url", "/app/index.jsp");

		return "alert.jsp";
	}

	//메일 인증완료시 FLAG =1로 업데이트
	@RequestMapping(value="/signUpConfirm", method=RequestMethod.GET)
	public String signUpConfirm(@RequestParam Map<String, String> map,MemberVO vo, ModelAndView mav, Model model){
		//email, authKey 가 일치할경우 authStatus 업데이트
		System.out.println("signUpConfirm        GET입장");
		vo.setmEmail(map.get("email"));
		vo.setmAuthkey(map.get("authKey"));

		memberService.updateAuthStatus(vo);

		model.addAttribute("msg", "메일 인증을 완료하였습니다. 로그인해주세요.");
		model.addAttribute("url", "/app/index.jsp");

		return "alert.jsp";
	}


	//---------------로그인---------------
	@RequestMapping(value="/login.do", method=RequestMethod.GET) 
	public String loginView() {
		return "login.jsp";
	}
	//---------------로그인---------------
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(MemberVO vo,HttpSession session, Model model,BoardVO bvo, HttpServletRequest request) {
		System.out.println("selectOne: login 입장");
		vo=memberService.selectOneMember(vo);   

		if(vo==null) {
			model.addAttribute("msg", "아이디 비밀번호를 확인해주세요.");
			model.addAttribute("url", "/app/index.jsp");
			return "alert.jsp";
		}
		else if(vo.getmFlag()==0) {
			model.addAttribute("msg", "email 인증 후 로그인해주세요.");
			model.addAttribute("url", "/app/index.jsp");
			return "alert.jsp";
		}
		else {
			if(vo.getId().equals("admin")) {

				//model.addAttribute("allMember", memberService.selectAll(vo));
				//model.addAttribute("allBoard", boardService.selectAll(bvo));
				return "admin.jsp";
				//로그인 해도 메인으로 이동하지 않고 해당 페이지에 남아있게 해주는 코드
			}else if(request.getHeader("Referer") != null) {
				session.setAttribute("member", vo);
				return "redirect:" + request.getHeader("Referer");
			}
			else {
				return "redirect:main.do";
			}
		}
	}

	//---------------로그아웃---------------
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		System.out.println("logout 입장  GET");

		//session.invalidate();
		session.removeAttribute("member");
		return "redirect:main.do";
	}

	//--------------- 회원 탈퇴 ---------------
	@RequestMapping(value="/deleteMember.do", method=RequestMethod.GET)
	public String deleteMember() {
		System.out.println("delete: deleteMember    ");

		return "unJoin.jsp";
	}

	//--------------- 회원 탈퇴 ---------------
	@RequestMapping(value="/deleteMember.do", method=RequestMethod.POST)
	public String deleteMember(MemberVO vo, MemberVO mvo, Model model, HttpSession session) {
		System.out.println("delete: deleteMember    ");

		mvo=(MemberVO)session.getAttribute("member");
		mvo.getId();
		memberService.deleteMember(mvo);

		model.addAttribute("msg", "정말 탈퇴하시겠습니까?");
		model.addAttribute("url", "/app/index.jsp");
		session.removeAttribute("member");
		return "alert.jsp";
	}

	//---------------마이페이지---------------
	@RequestMapping(value="/myPage.do", method=RequestMethod.GET)
	public String mypage() {
		System.out.println("myPage 입장    GET");		
		return "myPage.jsp";
	}

	//---------------마이페이지---------------
	@RequestMapping(value="/myPage.do", method=RequestMethod.POST)
	public String mypage(HttpSession session) {
		System.out.println("myPage 입장    POST");		
		return "myPage.jsp";
	}

	//---------------나의댓글---------------
	@RequestMapping(value="/myComment.do", method=RequestMethod.GET)
	public String myComment() {
		System.out.println("myComment 입장    GET");		
		return "myComment.jsp";
	}

	//---------------나의댓글---------------
	@RequestMapping(value="/myComment.do", method=RequestMethod.POST)
	public String myComment(HttpSession session) {
		System.out.println("myComment 입장    POST");		
		return "myComment.jsp";
	}		

	//--------------- 아이디중복확인 ---------------
	@RequestMapping(value="/idCheck.do", method=RequestMethod.POST) 
	public void idCheck(MemberVO vo,HttpServletResponse response)throws ServletException, IOException {
		System.out.println("selectOne: idCheck 입장 POST");		
		vo=memberService.checkId(vo);
		if(vo==null) {
			System.out.println("사용 가능");
			response.getWriter().println("1");
		}
		else {
			System.out.println("사용 불가능");
			response.getWriter().println("0");
		}
	}

	//--------------- 아이디중복확인 ---------------
	@RequestMapping(value="/idCheck2.do", method=RequestMethod.POST) 
	public String idCheck2(MemberVO vo){
		System.out.println("selectOne: idCheck 입장");		
		vo=memberService.checkId(vo);			
		if(vo==null) {
			return "1";
		}
		else {
			return "0";
		}
	}

	//--------------- 닉네임중복확인 ---------------
	@RequestMapping(value="/nickCheck.do", method=RequestMethod.POST) 
	public void nickCheck(MemberVO vo,HttpServletResponse response)throws ServletException, IOException {
		System.out.println("nickCheck.do  입장 POST");
		vo=memberService.checkNickName(vo);
		if(vo==null) {
			response.getWriter().println("1");
		}
		else {
			response.getWriter().println("0");
		}
	}

	//--------------- 닉네임중복확인 ---------------	
	@RequestMapping(value="/nickCheck2.do", method=RequestMethod.POST) 
	public String nickCheck2(MemberVO vo) {
		System.out.println("nickCheck.do  입장 POST");
		vo=memberService.selectOneMember(vo);
		if(vo==null) {
			return "사용가능한 닉네임입니다.";
		}
		else {
			return "중복된 닉네임입니다.";
		}
	}

	//--------------- 아이디 찾기 ---------------
	@RequestMapping(value="/searchId.do", method=RequestMethod.GET)
	public String serachIdView(HttpSession session,MemberVO vo,Model model) {
		System.out.println("searchId     입장   GET");
		// 입력한 이메일이 있는지 확인
		//		vo=memberService.selectOneMember(vo);
		//		if(vo.getmEmail()==null) {
		//			model.addAttribute("msg", "가입된 이메일이 아닙니다.");
		//			model.addAttribute("url", "/app/searchId.jsp");
		//			return "alert.jsp";
		//		}

		//입력한 이메일로 인증번호 이메일전송
		//임의의 authKey 생성 & 이메일 발송
		String authKey = mss.sendChkMail(vo.getmEmail());
		//		vo.setmAuthkey(authKey);
		//
		//		Map<String, String> map = new HashMap<String, String>();
		//		map.put("email", vo.getmEmail());
		//		map.put("authKey", vo.getmAuthkey());

		System.out.println("메일로 발송한 인증키"+authKey);
		//DB에 인증키 업데이트

		return "searchId.jsp";
	}


	//	//---------------아이디찾기---------------
	//	@RequestMapping(value="/searchId.do", method=RequestMethod.POST) 
	//	public String searchId(MemberVO vo, Model model) {
	//		System.out.println("searchId     입장   POST");
	//		//입력한 이메일이 있는지 확인
	//		vo=memberService.selectOneMember(vo);
	//		if(vo.getmEmail()==null) {
	//			return "2";
	//		}
	//		//입력한 이메일로 인증번호 이메일전송
	//		//임의의 authKey 생성 & 이메일 발송
	//		String authKey = mss.sendChkMail(vo.getmEmail());
	//		vo.setmAuthkey(authKey);	
	//		System.out.println("메일로 발송한 인증키"+authKey);
	//		
	//		return "1";
	//		
	//	}

	//--------------- 아이디찾기 인증번호발송 ---------------
	@RequestMapping(value="/searchId.do", method=RequestMethod.POST) 
	public void searchId(MemberVO vo,HttpServletResponse response)throws ServletException, IOException {
		System.out.println("searchId.do  입장 POST");
		vo=memberService.selectOneMember(vo);

		if(vo==null) {
			response.getWriter().println("0");
		}
		else {
			String authKey = mss.sendChkMail(vo.getmEmail());
			vo.setmEmailChk(authKey);
			memberService.updateKey(vo);
			response.getWriter().println("1");
		}
	}

	//--------------- 아이디찾기 인증번호 확인 ---------------
	@RequestMapping(value="/emailNumConfirm.do", method=RequestMethod.POST) 
	public void emailNumConfirm(MemberVO vo,HttpServletResponse response)throws ServletException, IOException {
		System.out.println("confirm.do  입장 POST");
		//
		System.out.println(vo);

		if(vo==null) {
			response.getWriter().println("0");
		}
		else {
			System.out.println("ddddddddddddddddddddddddddddddddddddddddddddd");
			response.getWriter().println("1");
		}
	}



	//---------------비밀번호찾기---------------
	@RequestMapping(value="/searchPw.do", method=RequestMethod.GET)
	public String serachPwView() {
		System.out.println("��й�ȣã���������� �̵�");
		return "searchId.jsp";
	}

	//---------------비밀번호찾기---------------
	@RequestMapping(value="/searchPw.do", method=RequestMethod.POST) 
	public String searchPw(MemberVO vo, Model model) {
		System.out.println("selectOne: searchPw ����");
		vo=memberService.selectOneMember(vo);
		if(vo==null) {
			return "";
		}
		else {
			return "";
		}
	}

	//	//--------------- 관리자 ---------------
	//	@RequestMapping(value="/managementMember.do") 
	//	public String selectAllGrade(MemberVO vo, Model model) {
	//
	//		System.out.println("selectAllGrade: managementMember ����");
	//		model.addAttribute("datas", memberService.selectAllGrade(vo));
	//		return "admin.jsp";
	//	}

	//--------------- 회원정보변경---------------
	@RequestMapping(value="/changeMyInfo.do",  method=RequestMethod.GET)
	public String changeMyInfo() {
		System.out.println("update: changeMyInfo GET");

		return "main.do";
	}

	//--------------- 회원정보변경---------------
	@RequestMapping(value="/changeMyInfo.do", method=RequestMethod.POST)
	public String changeMyInfo (MemberVO vo) {

		System.out.println("update: changeMyInfo POST");
		memberService.updateMember(vo);

		return "redirect:main.do";
	}


}