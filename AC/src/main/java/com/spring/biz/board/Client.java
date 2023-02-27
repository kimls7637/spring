package com.spring.biz.board;

import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;


public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");	
		
		Scanner sc=new Scanner(System.in);
		System.out.println("제목을 입력하세요. >> ");
		String title=sc.next();
		System.out.println("작성자를 입력하세요. >> ");
		String writer=sc.next();
		System.out.println("내용을 입력하세요. >> ");
		String content=sc.next();
		
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO vo=new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		bs.insertBoard(vo);
		vo.setBid(101);
		// bs.selectOne(vo);
		
		for(BoardVO v:bs.selectAll(vo)) {
			System.out.println(v);
		}
		       
		factory.close();
	}
}
