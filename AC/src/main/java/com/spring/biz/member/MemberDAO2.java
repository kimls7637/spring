package com.spring.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;


public class MemberDAO2 {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT="INSERT INTO MEMBER (MID,MPW,MNAME) VALUES (?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET MPW=?,MNAME=? WHERE MID=?";
	private final String SQL_DELETE="DELETE FROM MEMBER WHERE MID=?";

	private final String SQL_SELECT_ALL="SELECT * FROM MEMBER";
	
	private final String SQL_SELECT_ONE="SELECT * FROM MEMBER WHERE MID=?";

	public boolean insertMember(MemberVO vo) {
		jdbcTemplate.update(SQL_INSERT,vo.getId(),vo.getPw(),vo.getmName());
		return true;
	}

	public boolean updateMember(MemberVO vo) {
		jdbcTemplate.update(SQL_UPDATE,vo.getPw(),vo.getmName(),vo.getId());
		return true;
	}

	public boolean deleteMember(MemberVO vo) {
		jdbcTemplate.update(SQL_DELETE,vo.getId());
		return true;
	}

	public List<MemberVO> selectAll(MemberVO vo) {
		return jdbcTemplate.query(SQL_SELECT_ALL, new MemberRowMapper());
		// 첫번째 인자 sql문, 마지막인자 output만들어주는 클래스
	}

	public MemberVO selectOne(MemberVO vo) {
		Object[] args = {vo.getId()};
		
		try {
			return jdbcTemplate.queryForObject(SQL_SELECT_ONE, args, new MemberRowMapper());
		} catch (EmptyResultDataAccessException e) {
			// e.printStackTrace();
			return null;
		}
		
	}
}

class MemberRowMapper implements RowMapper<MemberVO>{
// 실제하는 rs가 있으면 
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("알수있게 민성"+rowNum);
		MemberVO data=new MemberVO();
		data.setId(rs.getString("MID"));
		data.setPw(rs.getString("MPW"));
		data.setmName(rs.getString("MNAME"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}
	
}
