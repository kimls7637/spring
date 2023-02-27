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

	// 회원가입
	private final String SQL_INSERT = "INSERT INTO MEMBER (ID, PW, MNAME, MNICKNAME, MEMAIL, MJOINDATE) VALUES (?, ?, ?, ?, ?, NOW());";
	// 아이디찾기
	private final String SQL_SELECTONE_ID = "SELECT * FROM MEMBER WHERE MEMAIL=?;";
	// 비밀번호찾기
	private final String SQL_SELECTONE_PW = "SELECT * FROM MEMBER WHERE MEMAIL=? AND ID=?;";
	// 로그인
	private final String SQL_SELECTONE_LOGIN = "SELECT * FROM MEMBER WHERE ID=? AND PW=?;";
	// 회원목록(등급순)
	private final String SQL_SELECTALL_GRADE = 
			"SELECT MBH.*, G.GRADE\n"
			+ "FROM (\n"
			+ "	SELECT M.*, COUNT(HNUM) AS HEARTCNT\n"
			+ "	FROM MEMBER M\n"
			+ "	LEFT JOIN BOARD B\n"
			+ "	ON M.ID = B.BID\n"
			+ "	LEFT JOIN HEART H\n"
			+ "	ON B.BNUM = H.HBNUM\n"
			+ "	GROUP BY M.ID\n"
			+ ") MBH\n"
			+ "JOIN GRADE G \n"
			+ "ON MBH.HEARTCNT BETWEEN G.GMIN AND G.GMAX;";
	// 회원목록(신고순)
	private final String SQL_SELECTALL_REPORT = 
			"SELECT M.*, A.GRADE, A.REPORTCNT \n"
			+ "FROM MEMBER M\n"
			+ "JOIN(\n"
			+ "	SELECT *\n"
			+ "	FROM (\n"
			+ "		SELECT RB.*, SUM(RRCNT) AS REPORTCNT, SUM(HCNT) AS HEARTCNT\n"
			+ "		FROM (\n"
			+ "			SELECT B.*, COUNT(R.RNUM) AS RRCNT\n"
			+ "			FROM BOARD B\n"
			+ "			LEFT JOIN REPORT R\n"
			+ "			ON B.BNUM = R.RBNUM\n"
			+ "			GROUP BY B.BNUM	\n"
			+ "		) RB\n"
			+ "		JOIN (\n"
			+ "			SELECT B.*, COUNT(H.HNUM) AS HCNT\n"
			+ "			FROM BOARD B\n"
			+ "			LEFT JOIN HEART H\n"
			+ "			ON B.BNUM = H.HBNUM \n"
			+ "			GROUP BY B.BNUM\n"
			+ "		) HB\n"
			+ "		ON RB.BNUM = HB.BNUM\n"
			+ "		GROUP BY RB.BID\n"
			+ "	) BRH\n"
			+ "	JOIN GRADE G \n"
			+ "	ON BRH.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
			+ "	) A \n"
			+ "ON M.ID=A.BID;";
	// 정보변경
	private final String SQL_UPDATE_INFO = "UPDATE MEMBER SET PW=?, MNAME=?, MNICKNAME=?, MEMAIL=? WHERE ID=?;";
	// 회원정지
	private final String SQL_UPDATE_STOPDATE = "UPDATE MEMBER SET MSTOPDATE=DATE_ADD(NOW(), INTERVAL ? DAY) WHERE ID='ID';";
	// 회원탈퇴
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
			data.setGrade(rs.getString("GRADE"));
			data.setReportCnt(rs.getInt("REPORTCNT"));
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			return data;
		}
	}
}