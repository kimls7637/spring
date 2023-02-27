package com.spring.biz.heart;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("heartDAO")
public class HeartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "INSERT INTO HEART (HTYPE, HID, HBNUM) VALUES (?, ?, ?);";
	private final String SQL_DELETE = "DELETE FROM HEART WHERE HTYPE=? AND HID=? AND HBNUM=?;";
	private final String SQL_DELETE_BOARD = "DELETE FROM HEART WHERE HTYPE='게시글' AND HBNUM=?;";
	
	public boolean insertHeart(HeartVO vo) {
		jdbcTemplate.update(SQL_INSERT, vo.getHtype(), vo.getHid(), vo.getHbnum());
		return true;
	}

	public boolean deleteHeart(HeartVO vo) {
		int res;
		if(vo.getHid() == null) {
			res=jdbcTemplate.update(SQL_DELETE, vo.getHtype(), vo.getHid(), vo.getHbnum());
		} else {
			res=jdbcTemplate.update(SQL_DELETE_BOARD, vo.getHbnum());
		}
		if(res<1) {
			return false;
		}
		return true;
	}
}