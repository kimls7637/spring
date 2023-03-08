package com.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.biz.report.ReportService;
import com.spring.biz.report.ReportVO;


@Controller
public class ReportController {
	
	@Autowired
	private ReportService reportService;
	
	//---------------신고---------------
	@RequestMapping(value = "/report.do", method = RequestMethod.GET)
	public void report(ReportVO vo, Model model) {
		System.out.println("board에 있는 report.do 입장   GET");
		reportService.insertReport(vo);	
	}
	
}
