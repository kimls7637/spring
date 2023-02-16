package com.spring.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
//	login.do new LoginController()
//	main.do new MainCOntroller()
//	String Controller류 객체반환
//	어떠한 String타입이 key값 --->> value로 controller 객체
	private Map<String, Controller> mappings;
	// 필수 멤버변수로 DI 필요로함
	
	// 현재 생성자주입 하고있음
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		mappings.put("/join.do", new JoinController());
		mappings.put("/updateMember.do", new UpdateMemberController());
		mappings.put("/deleteMember.do", new DeleteMemberController());
		mappings.put("/mypage.do", new MypageController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/selectBoard.do", new SelectBoardController());
		mappings.put("/searchBoard.do", new SearchBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}