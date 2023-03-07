package com.spring.biz.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("reportService")
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDAO ReportDAO;

	@Override
	public boolean insertReport(ReportVO vo) {
		return ReportDAO.insertReport(vo);
	}

	@Override
	public boolean deleteReport(ReportVO vo) {
		return ReportDAO.deleteReport(vo);
	}

}
