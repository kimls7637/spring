package com.spring.biz.member;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;


public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");

		MemberService ms=(MemberService)factory.getBean("memberService");
		MemberVO mvo=new MemberVO();
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO bvo=new BoardVO();
		
		Scanner sc=new Scanner(System.in);

		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		System.out.println("3. 검색");
		System.out.println("4. 종료");
		int num=sc.nextInt();


		if(num==1) { // 회원가입
			System.out.println("id를 입력하세요. >> ");
			String id=sc.next();
			System.out.println("pw를 입력하세요. >> ");
			String pw=sc.next();
			System.out.println("이름을 입력하세요. >> ");
			String name=sc.next();
			
			mvo.setmId(id);
			mvo.setmPw(pw);
			mvo.setmName(name);
			if(ms.insertMember(mvo)) {
				System.out.println("회원가입 성공");
			}
			else{
				System.out.println("회원가입 실풰");
			}
		}
		else if(num==2) { // 로그인
			System.out.println("id : ");
			String id=sc.next();
			System.out.println("pw : ");
			String pw=sc.next();
			
			mvo.setmId(id);
			mvo.setmPw(pw);
			mvo=ms.selectOne(mvo);
			
			if(mvo==null) {
				System.out.println("로그인 실패");
				
			} 
			else {
				System.out.println(mvo);
				System.out.println("로그인 성공");
				// com.spring.biz.board.Client.main(args);
				bvo.setWriter(id);
				for(BoardVO v:bs.selectAll(bvo)) {
					System.out.println(v);
				}
			}
		}
		else if(num==3) { // 검색
			System.out.println("검색 >> ");
			String msg=sc.next();
			bvo.setWriter(msg);
			for(BoardVO v:bs.selectAll(bvo)) {
				System.out.println(v);
			}
		}
		
		factory.close();
	}
}
