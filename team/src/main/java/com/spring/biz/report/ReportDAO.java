package com.spring.biz.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("reportDAO")
public class ReportDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "INSERT INTO REPORT (RTYPE, RID, RBNUM) VALUES (?, ?, ?);";
	private final String SQL_DELETE = "DELETE FROM REPORT WHERE RTYPE=? AND RID=? AND RBNUM=?;";
	private final String SQL_DELETE_BOARD = "DELETE FROM REPORT WHERE RTYPE='게시글' AND RBNUM=?;";
	
	public boolean insertReport(ReportVO vo) {
		jdbcTemplate.update(SQL_INSERT, vo.getRtype(), vo.getRid(), vo.getRbnum());
		return true;
	}

	public boolean deleteReport(ReportVO vo) {
		int res;
		if(vo.getRid() == null) {
			res=jdbcTemplate.update(SQL_DELETE, vo.getRtype(), vo.getRid(), vo.getRbnum());
		} else {
			res=jdbcTemplate.update(SQL_DELETE_BOARD, vo.getRbnum());
		}
		if(res<1) {
			return false;
		}
		return true;
	}
}