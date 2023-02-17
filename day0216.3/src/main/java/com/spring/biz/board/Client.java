package com.spring.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		Scanner sc = new Scanner(System.in);
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO vo=new BoardVO();
		System.out.print("제목 : ");
		vo.setTitle(sc.next());
		System.out.print("작가 : ");
		vo.setWriter(sc.next());
		System.out.print("내용 : ");
		vo.setContent(sc.next());
		bs.insertBoard(vo);
		for(BoardVO v:bs.selectAll(vo)) {
			System.out.println(v.getTitle() + (" / ") + v.getContent());
		}
		
		vo.setBid(-3);
		bs.selectOne(vo);
		
		factory.close();
	}
}