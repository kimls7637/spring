package com.spring.biz.member;

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

@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	//	private final String SQL_INSERT="INSERT INTO MEMBER VALUES(?,?,?,?)";
	private final String SQL_INSERT = "INSERT INTO MEMBER (ID, PW, MNAME, MNICKNAME, MEMAIL, MJOINDATE) VALUES (?, ?, ?, ?, ?, NOW());";
	private final String SQL_SELECTONE_ID = "SELECT * FROM MEMBER WHERE MEMAIL=?;";
	private final String SQL_SELECTONE_PW = "SELECT * FROM MEMBER WHERE MEMAIL=? AND ID=?;";
	private final String SQL_SELECTONE_LOGIN = "SELECT * FROM MEMBER WHERE ID=? AND PW=?;";
	private final String SQL_SELECTALL_GRADE = "";
	private final String SQL_SELECTALL_REPORT = "";
	private final String SQL_UPDATE_INFO = "UPDATE MEMBER SET PW=?, MNAME=?, MNICKNAME=?, MEMAIL=? WHERE ID=?;";
	private final String SQL_UPDATE_STOPDATE = "UPDATE MEMBER SET MSTOPDATE=? WHERE ID=?;";
	private final String SQL_DELETE = "DELETE FROM MEMBER WHERE ID=?;";

	public boolean insertMember(MemberVO vo) {
		jdbcTemplate.update(SQL_INSERT, vo.getId(), vo.getPw(), vo.getmName(), vo.getmNickname(), vo.getmEmail());
		return true;
	}

	public boolean updateMember(MemberVO vo) {
		int res;
		if(vo.getmStopDate() == null) {
			res=jdbcTemplate.update(SQL_UPDATE_INFO, vo.getPw(), vo.getmName(), vo.getmNickname(), vo.getmEmail(), vo.getId());
		} else {
			res=jdbcTemplate.update(SQL_UPDATE_STOPDATE, vo.getmStopDate(), vo.getId());
		}
		if(res<1) {
			return false;
		}
		return true;
	}

	public MemberVO selectOneMember(MemberVO vo) {
		MemberVO mvo = new MemberVO();
		if(!vo.getPw().isEmpty()) {
			Object[] args= {vo.getId(), vo.getPw()};
			mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_LOGIN, args, new MemberRowMapper());
		} else if(!vo.getId().isEmpty()) {
			Object[] args= {vo.getmEmail(), vo.getId()};
			mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_PW, args, new MemberRowMapper());
		} else {
			Object[] args= {vo.getmEmail()};
			mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_ID, args, new MemberRowMapper());
		}
		return mvo;
	}

	public List<MemberVO> selectAll_GRADE(MemberVO vo) {
		return jdbcTemplate.query(SQL_SELECTALL_GRADE, new MemberRowMapper());
	}
	public List<MemberVO> selectAll_REPORT(MemberVO vo) {
		return jdbcTemplate.query(SQL_SELECTALL_REPORT, new MemberRowMapper());
	}

	public boolean deleteMember(MemberVO vo) {
		int res=jdbcTemplate.update(SQL_DELETE, vo.getId());
		if(res<1) {
			return false;
		}
		return true;
	}

	class MemberRowMapper implements RowMapper<MemberVO> {
		@Override
		public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			MemberVO data=new MemberVO();
			data.setId(rs.getString("ID"));
			data.setPw(rs.getString("PW"));
			data.setmName(rs.getString("MNAME"));
			data.setmNickname(rs.getString("MNICKNAME"));
			data.setmEmail(rs.getString("MEMAIL"));
			data.setmEmailChk(rs.getInt("MEMAILCHK"));
			data.setmJoinDate(LocalDateTime.parse(rs.getString("MJOINDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setmStopDate(LocalDateTime.parse(rs.getString("MSTOPDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			return data;
		}
	}
}