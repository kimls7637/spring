package com.spring.biz.member;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
		MemberVO vo=new MemberVO();
		vo.setMid("kimls");
		vo.setMpw("1234");
		vo.setMname("이슬");
		vo.setRole("학생");
		
		for(MemberVO v:ms.selectAll(vo)) {
			System.out.println(v);
		}
		
		System.out.println("깃 테스트");
		ms.selectOne(vo);
		vo.setMid("admin");
		ms.selectOne(vo);
		
		factory.close();
	}
}
