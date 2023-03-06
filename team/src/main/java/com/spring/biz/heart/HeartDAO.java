package com.spring.biz.heart;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("heartDAO")
public class HeartDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT = "INSERT INTO HEART2 (HTYPE, HID, HBNUM) VALUES (?, ?, ?);";
	private final String SQL_DELETE = "DELETE FROM HEART2 WHERE HTYPE=? AND HID=? AND HBNUM=?;";
	private final String SQL_DELETE_BOARD = "DELETE FROM HEART2 WHERE HTYPE='게시글' AND HBNUM=?;";
	private final String SQL_SELECT_HEARTCNT = "SELECT COUNT(*) AS HEARTCNT FROM HEART WHERE HTYPE=? AND HBNUM=?";
	
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
	
	public List<HeartVO> selectAll(HeartVO vo){
		Object[] args = {vo.getHtype(), vo.getHbnum()};
		try {
			return jdbcTemplate.query(SQL_SELECT_HEARTCNT, args, new HeartRowMapper());
		} catch(Exception e) {
			return null;
		}
	}
}




class HeartRowMapper implements RowMapper<HeartVO> {
	public HeartVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		HeartVO data = new HeartVO();
		data.setHeartCnt(rs.getInt("HEARTCNT"));
		return data;
	}
}