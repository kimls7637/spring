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
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}