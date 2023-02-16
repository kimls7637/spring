package com.spring.biz.common;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.member.*;
import com.spring.biz.board.*;
import java.util.List;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		MemberService ms=(MemberService)factory.getBean("memberService");
		BoardService bs=(BoardService)factory.getBean("boardService");
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("1. 로그인");
			System.out.println("2. 종료");
			System.out.print("입력 : ");
			int num = sc.nextInt();
			if(num == 1) {
				System.out.print("아이디 : ");
				String id = sc.next();
				System.out.print("비밀번호 : ");
				String pw = sc.next();
				MemberVO vo = new MemberVO();
				vo.setMid(id);
				vo.setMpw(pw);
				vo = ms.selectOne(vo);
				if(vo != null) {
					System.out.println(vo.getMname()+"님, 안녕하세요!");
					while(true) {
						System.out.println("1. 내가 쓴 글");
						System.out.println("2. 검색");
						System.out.println("3. 로그아웃");
						System.out.print("입력 : ");
						num = sc.nextInt();
						if(num == 1) {
							BoardVO bvo = new BoardVO();
							bvo.setWriter(vo.getMid());
							List<BoardVO> list = bs.selectAll(bvo);
							if(list != null) {
								for(BoardVO v:list) {
									System.out.println(v.getTitle() + " / " + v.getContent());
								}
							} else {
								System.out.println("게시글이 없습니다");
							}
						} else if(num == 2) {
							System.out.print("검색할 작성자명 : ");
							String search = sc.next();
							BoardVO bvo = new BoardVO();
							bvo.setWriter(search);
							List<BoardVO> list = bs.selectSearch(bvo);
							if(list != null) {
								for(BoardVO v:list) {
									System.out.println(v.getTitle() + " / " + v.getContent());
								}
							} else {
								System.out.println("게시글이 없습니다");
							}
						} else {
							System.out.println("로그아웃하였습니다 !");
							break;
						}
					}
				} else {
					System.out.println("로그인 실패");
				}

			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
		}
		
		factory.close();
		sc.close();
		
	}
}
