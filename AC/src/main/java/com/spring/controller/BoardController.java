package com.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; // @Controller쓰면서 생긴 임포트
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.biz.board.BoardDAO;
import com.spring.biz.board.BoardDAO2;
import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

// @Component --> 일반 new
// 	▼ 상속관계
// @Controller--> Controller타입의 객체를 new
// @Service --> 서비스타입
// @Repositroy --> dao타입

@Controller // new<bean> + implements
public class BoardController {
	

	// 검색시 조건들 전달하기위한 메서드
	// 1. 메서드 호출 순서
	// 	: @가 컨트롤러 내부에 끼워져있으면 무조건 @RequestMapping보다 먼저 호출됨(스프링이 그렇게 해줌)
	// 2. new 직접 썼는데 메모리 갠춘? 싱글톤 유지 여부
	//  : (별도 설정이 없다면) 스프링 컨테이너가 유지해줌
	
	// 반환이 있는 메서드 만들어놓고
	// @ModelAttribute - 뷰에서 이 이름으로 메서드 불러올수있다
	@ModelAttribute("searchMap")
	public Map<String,String> searchConditionMap(){
		// 어떤 검색어에 대해 어떤 값을 전달해야한다고 한쌍의 데이터를 보낼예정 => Map사용
		
		Map<String,String> map=new HashMap<String,String>();
		map.put("제목", "TITLE"); // 향후 DB로 넘어갈 예정이라 대문자로 작성
		map.put("작성자", "WRITER"); 
		map.put("내용", "CONTENT");
		return map;
	}
	
//	@RequestMapping(value="/search.do") // HM대신해주는 어노테이션
//	// 뷔오에서 멤버변수로 갖고있지않는 변수를 가지고 올때 리퀘스트파람으로 받아올수있음
//	public String selectAllBoard(@RequestParam(value="searchCondition",defaultValue="TITLE",required=false)String searchCondition,@RequestParam(value="searchContent",defaultValue="",required=false)String searchContent,BoardVO vo, BoardDAO boardDAO, Model model) {
//		System.out.println("SearchController 입장");
//		System.out.println("searchCondition "+ searchCondition);
//		System.out.println("searchContent "+searchContent);
//		// 뭘 검색할지를 알아야하기때문에 VO 커멘트객체 생성
//		model.addAttribute("datas",boardDAO.selectAll(vo)); 
//
//		model.setViewName("main");
//		// 메인을 포워딩해야하는데 앞뒤로 붙여서 포워딩할래~
//		// 데이터를 봐야하는 경우 -> forward
//		// 앞 WEB-INF / 뒤 .jsp는 VR가 붙여줌
//		return model;
//		// 정보를 가져가야해서 포워드방식으로, redirect안적어줘도됌
//	}
	
	// vo에 검색관련 멤버변수 만들어주고 사용
	// 검색하는것도 메인보여줘~이기때문에 main.do 같이 사용
	@RequestMapping(value="/main.do") // HM대신해주는 어노테이션
	public String selectAllBoard(BoardVO vo,BoardDAO boardDAO, Model model) {
		System.out.println("MainController 입장");
		// 검색관련 보긴해야하니까 작성
		System.out.println("searchCondition "+ vo.getSearchCondition());
		System.out.println("searchContent "+vo.getSearchContent());
		// model.addAttribute("datas",boardDAO.selectAll(vo)); 
		
		return "main.jsp";
		// 정보를 가져가야해서 포워드방식으로, redirect안적어줘도됌
	}
	
	@RequestMapping(value="/insertBoard.do",method=RequestMethod.POST) // HM대신해주는 어노테이션
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) { 
		System.out.println("insertBoardController 입장");
	
		boardDAO.insertBoard(vo); 

		return "redirect:main.do";
	}
	
	@RequestMapping(value="/insertBoard.do", method=RequestMethod.GET) // HM대신해주는 어노테이션
	public String insertBoardView() { 
		System.out.println("insertBoardController view입장");
	
		return "insertBoard.jsp";
	}
	
	
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.POST) // HM대신해주는 어노테이션
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) { 
		System.out.println("updateBoardController 입장");
		
		boardDAO.updateBoard(vo);
		
		return "redirect:main.do";
	}
	
	@RequestMapping(value="/updateBoard.do", method=RequestMethod.GET) // HM대신해주는 어노테이션
	public String updateBoardView() { 
		System.out.println("updateBoardController view입장");
	
		return "updateBoard.jsp";
	}
	
	@RequestMapping(value="/deleteBoard.do", method=RequestMethod.GET) // HM대신해주는 어노테이션
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) { 
		System.out.println("updateBoardController 입장");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:main.do";
	}
	
	// 핸들러매핑은 객체를 보고
	// 리퀘스트매핑은 메서드를 본다 => 메서드류합치기

	// 현재 메서드 강제성 없음 -> 인아웃 맘대로 변경가능
	// 점점 pojo에 가까운 컨트롤러로 바뀌어감
	// 원래 컨트롤러로 사용 -> 스프링에서 제공하는 컨트롤러를 implements -> @
	// xml에 있는 new를 대신하면서 동시에 컨트롤러인걸 알려주려면 @Component를 상속받은 @Controller사용 
	
	
	@RequestMapping(value="/board.do") // HM대신해주는 어노테이션
	public String selectOneBoard(BoardVO vo, BoardDAO boardDAO,Model model) { 
		System.out.println("BoardController 입장");
		// 나 사용자한테서 데이터 받아올건데 타입이 BoardVO야 메서드안에서는 vo라고 부를거야 
		// : @Controller가 붙은 클래스의 메서드의 인자를 Command객체라고 부름
		// [vo] 선언한 순간 1) new (메모리공간 생김)
		// 2) 사용자의 입력값을 추출(request로부터 추출)
		// 3) 해당 객체(vo)에 자동으로 set 매핑하여 저장
		// => 유즈빈부터 셋프로퍼티를 다해줌

		model.addAttribute("data",boardDAO.selectOne(vo)); // 일반포조로 다룰수있기때문에 더 가볍다
		// "data"는 뷰에 던져줄 일회용 객체 느낌, 그 페이지에서만 쓰고 말것
		// model == request랑 비슷함
		
		return "board.jsp";
	}
	
	@RequestMapping(value="/commuList.do") // HM대신해주는 어노테이션
	public String commuList(BoardVO vo, BoardDAO boardDAO) { 
		System.out.println("commuList 입장");
		
		
		
		return "commuList.jsp";
	}
	
	

}
