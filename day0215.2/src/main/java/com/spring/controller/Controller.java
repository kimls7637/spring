package com.spring.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
}

// handleRequest() == execute()
// String != AF
// 기존에는 ViewResolver가 없었기에, "어디로" + "어떻게" 에 대한 정복 2가지가 필요하여 클래스를 사용
// 지금은 Spring ViewResolver가 있기 때문에, "어디로"에 대한 정보가 있으면 ㄱㅊ!