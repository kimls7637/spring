package com.spring.biz.board;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.mysql.cj.x.protobuf.MysqlxCrud.Insert;

public class Client {
	public static void main(String[] args) {
		AbstractApplicationContext factory=new GenericXmlApplicationContext("applicationContext.xml");
		
		BoardService bs=(BoardService)factory.getBean("boardService");
		BoardVO vo=new BoardVO();
		vo.setTitle("제목");
		vo.setWriter("티모3");
		vo.setContent("내용");
		bs.insertBoard(vo);
		
		for(BoardVO v:bs.selectAll(vo)) {
			System.out.println(v);
		}
		
		vo.setBid(3);
		bs.selectOne(vo);
		
		factory.close();
	}
}
