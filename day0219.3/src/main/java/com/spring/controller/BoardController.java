package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardVO;
import com.spring.biz.member.MemberVO;

@Controller
public class BoardController {

	// 검색시 조건들 전달하기 위한 메서드
	@ModelAttribute("searchMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> map = new HashMap<String, String>();
		map.put("제목", "TITLE");
		map.put("작성자", "WRITER");
		map.put("내용", "CONTENT");
		return map;
	}
	
//	@RequestMapping(value="/search.do")
//	public String selectAllBoard(@RequestParam(value="searchCondition", defaultValue="TITLE", required=false)String searchCondition, @RequestParam(value="searchContent", defaultValue="TITLE", required=false)String searchContent, BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("SearchController 입장");
//		System.out.println("searchCondition: " + searchCondition);
//		System.out.println("searchContent: " + searchContent);
//		model.addAttribute("datas", boardDAO.selectAll(vo));
//		return "main.jsp"; 
//	}
	
	@RequestMapping(value="/main.do")
	public String selectAllBoard(BoardVO vo, BoardDAO boardDAO,Model model) {
		System.out.println("MainController 입장");
		System.out.println("searchCondition: " + vo.getSearchCondition());
		System.out.println("searchContent: " + vo.getSearchContent());
//		mav.addObject("datas", boardDAO.selectAll(null));
//		mav.setViewName("main.jsp");
		model.addAttribute("datas", boardDAO.selectAll(null));
		return "main.jsp";
	}
	
	@RequestMapping(value="/board.do")
	public String selectOneBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("BoardController 입장");
		
//		mav.addObject("data", boardDAO.selectOne(vo));
//		mav.setViewName("board.jsp");
		model.addAttribute("data", boardDAO.selectOne(vo));
		return "board.jsp";
	}
	
	@RequestMapping(value="/insert.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO, HttpSession session) {
		MemberVO mvo = (MemberVO)session.getAttribute("member");
		vo.setWriter(mvo.getMid());
		boardDAO.insertBoard(vo);
		
		return "main.do";
	}
	
	@RequestMapping(value="/delete.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.deleteBoard(vo);
		return "main.do";
	}
	
	@RequestMapping(value="/update.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) {
		boardDAO.updateBoard(vo);
		return "main.do";
	}
	
	@RequestMapping(value="/search.do")
	public String selectAllSearch(BoardVO vo, BoardDAO boardDAO,Model model) {
		System.out.println("searchCondition: " + vo.getSearchCondition());
		System.out.println("searchContent: " + vo.getSearchContent());
		if(vo.getSearchCondition().equals("TITLE")) {
			vo.setTitle(vo.getSearchContent());
		} else if (vo.getSearchCondition().equals("WRITER")) {
			vo.setWriter(vo.getSearchContent());
		} else {
			vo.setContent(vo.getSearchContent());
		}
		model.addAttribute("datas", boardDAO.selectAllSearch(vo));
		return "main.jsp";
	}

}
