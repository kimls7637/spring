package com.spring.biz.member;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("memberDAO")
public class MemberDAO2 {
	// DI 의존주입
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private final String SQL_INSERT="INSERT INTO MEMBER(MID,MPW,MNAME,ROLE) VALUES(?,?,?,?)";
	private final String SQL_UPDATE="UPDATE MEMBER SET MPW=?, MNAME=?, ROLE=? WHERE MID=?";
	private final String SQL_DELETE="DELETE FROM MEMBER WHERE MID=?";
	private final String SQL_SELECT_ALL="SELECT * FROM MEMBER;";
	private final String SQL_SELECT_ONE="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	
	public boolean insertMember(MemberVO vo) {
		jdbcTemplate.update(SQL_INSERT, vo.getMid(), vo.getMpw(), vo.getMname(), vo.getRole());
		return true;
	}
	public boolean updateMember(MemberVO vo) {
		jdbcTemplate.update(SQL_UPDATE, vo.getMpw(), vo.getMname(), vo.getRole(), vo.getMid());
		return true;
	}
	public boolean deleteMember(MemberVO vo) {
		jdbcTemplate.update(SQL_DELETE, vo.getMid());
		return true;
	}
	
	public List<MemberVO> selectAll(MemberVO vo) {
		 return jdbcTemplate.query(SQL_SELECT_ALL, new MemberRowMapper());
	}
	public MemberVO selectOne(MemberVO vo) {
		Object[] args = {vo.getMid(), vo.getMpw()};
		try {
		return jdbcTemplate.queryForObject(SQL_SELECT_ONE, args, new MemberRowMapper());
		} catch(Exception e) {
			return null;
		}
	}
}

//스프링에서 제공해주는 근본 인터페이스 RowMapper
class MemberRowMapper implements RowMapper<MemberVO>{
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setMid(rs.getString("MID"));
		data.setMname(rs.getString("MNAME"));
		data.setMpw(rs.getString("MPW"));
		data.setRole(rs.getString("ROLE"));
		return data;
	}
}