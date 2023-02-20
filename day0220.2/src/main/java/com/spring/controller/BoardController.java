package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;

	// 검색조건들 전달하기위한 메서드
	// 1. 메서드 호출 순서
	//    @RequestMapping 보다 먼저 호출됨
	// 2. 싱글톤 유지 여부
	//   (별도 설정이없다면)컨테이너가 유지해줌
	@ModelAttribute("searchMap")
	public Map<String,String> searchConditionMap(){
		Map<String,String> map=new HashMap<String,String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		map.put("내용", "CONTENT");
		return map;
	}
	
	/*
	@RequestMapping(value="/search.do")
	public String selectAllBoard(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("SearchController 입장");
		System.out.println("searchCondition: "+searchCondition);
		System.out.println("searchContent: "+searchContent);
		
		model.addAttribute("datas", boardDAO.selectAll(vo));
		return "main.jsp";
	}
	*/
	@RequestMapping(value="/main.do")
	public String selectAllBoard(BoardVO vo, Model model) {
		System.out.println("selectAllBoard() 입장");
		System.out.println("searchCondition: "+vo.getSearchCondition());
		System.out.println("searchContent: "+vo.getSearchContent());
		
		model.addAttribute("datas", boardService.selectAll(vo));
		return "main.jsp";
	}
	
	@RequestMapping(value="/board.do")
	public String selectOneBoard(BoardVO vo, Model model) {
		System.out.println("selectOneBoard() 입장");
		
		model.addAttribute("data", boardService.selectOne(vo));
		return "board.jsp";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.GET)
	public String insertView() {
		System.out.println("insertView() 입장");
		
		return "insert.jsp";
	}
	
	@RequestMapping(value="/insert.do", method=RequestMethod.POST)
	public String insertBoard(BoardVO vo) {
		System.out.println("insertBoard() 입장");
		
		boardService.insertBoard(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/update.do")
	public String updateBoard(BoardVO vo) {
		System.out.println("updateBoard() 입장");
		
		boardService.updateBoard(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("deleteBoard() 입장");
		
		boardService.deleteBoard(vo);
		
		return "redirect:main.do";
	}

}
