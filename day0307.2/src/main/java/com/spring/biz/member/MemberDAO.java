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


@Repository("memberDAO")
public class MemberDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	// 회원가입
	private final String SQL_INSERT = "INSERT INTO MEMBER2 (ID, PW, MNAME, MNICKNAME, MEMAIL, MAUTHKEY) VALUES (?, ?, ?, ?, ?, ?);";
	// 아이디 중복확인
	private final String SQL_CHECK_ID = "SELECT * FROM MEMBER2 WHERE ID=?;";
	// 닉네임 중복확인
	private final String SQL_CHECK_NICKNAME = "SELECT * FROM MEMBER2 WHERE MNICKNAME=?;";
	// 아이디찾기
	private final String SQL_SELECTONE_ID = "SELECT * FROM MEMBER2 WHERE MEMAIL=?;";
	// 비밀번호찾기
	private final String SQL_SELECTONE_PW = "SELECT * FROM MEMBER2 WHERE MEMAIL=? AND ID=?;";
	// 로그인
	private final String SQL_SELECTONE_LOGIN = 
			"select * \r\n"
					+ "from (\r\n"
					+ "   select *, count(hnum) as heartcnt\r\n"
					+ "   from member2 m\r\n"
					+ "   left join board2 b \r\n"
					+ "   on m.id = b.bid\r\n"
					+ "   left join heart2 h \r\n"
					+ "   on b.bnum = h.hbnum\r\n"
					+ "   group by m.id\r\n"
					+ ") mbh\r\n"
					+ "join grade2 g\r\n"
					+ "on mbh.heartcnt between g.gmin and g.gmax\r\n"
					+ "where id=? and pw=?;";

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
					+ "FROM MEMBER2 M\n"
					+ "JOIN(\n"
					+ "	SELECT *\n"
					+ "	FROM (\n"
					+ "		SELECT RB.*, SUM(RRCNT) AS REPORTCNT, SUM(HCNT) AS HEARTCNT\n"
					+ "		FROM (\n"
					+ "			SELECT B.*, COUNT(R.RNUM) AS RRCNT\n"
					+ "			FROM BOARD2 B\n"
					+ "			LEFT JOIN REPORT2 R\n"
					+ "			ON B.BNUM = R.RBNUM\n"
					+ "			GROUP BY B.BNUM	\n"
					+ "		) RB\n"
					+ "		JOIN (\n"
					+ "			SELECT B.*, COUNT(H.HNUM) AS HCNT\n"
					+ "			FROM BOARD2 B\n"
					+ "			LEFT JOIN HEART2 H\n"
					+ "			ON B.BNUM = H.HBNUM \n"
					+ "			GROUP BY B.BNUM\n"
					+ "		) HB\n"
					+ "		ON RB.BNUM = HB.BNUM\n"
					+ "		GROUP BY RB.BID\n"
					+ "	) BRH\n"
					+ "	JOIN GRADE2 G \n"
					+ "	ON BRH.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
					+ "	) A \n"
					+ "ON M.ID=A.BID;";
	// 정보변경
	private final String SQL_UPDATE_NICK = "UPDATE MEMBER2 SET MNICKNAME=? WHERE ID=?;";
	// 정보변경
	private final String SQL_UPDATE_PW = "UPDATE MEMBER2 SET PW=? WHERE ID=?;";
	
	private final String SQL_UPDATE_ALL = "UPDATE MEMBER2 SET PW=?,MNICKNAME=? WHERE ID=?;";
	// 회원정지
	private final String SQL_UPDATE_STOPDATE = "UPDATE MEMBER2 SET MSTOPDATE=DATE_ADD(NOW(), INTERVAL ? DAY) WHERE ID=?;";

	private final String SQL_UPDATE_CHK="UPDATE MEMBER2 SET MAUTHKEY=? WHERE ID=?";
	
	private final String SQL_UPDATE_FIND_ID="UPDATE MEMBER2 SET MEMAILCHK=? WHERE MEMAIL=?";

	private final String SQL_UPDATE_FLAG="UPDATE MEMBER2 SET MFLAG='1' WHERE MEMAIL=? AND MAUTHKEY=? ";
	// 회원탈퇴
	private final String SQL_DELETE = "DELETE FROM MEMBER2 WHERE ID=?;";

	public boolean insertMember(MemberVO vo) {
		jdbcTemplate.update(SQL_INSERT, vo.getId(), vo.getPw(), vo.getmName(), vo.getmNickname(), vo.getmEmail(),vo.getmAuthkey());
		return true;
	}

	public boolean updateMember(MemberVO vo) {
		int res;
		if(vo.getmStopDate() == null) {
			if(vo.getmNickname()=="") {
				res=jdbcTemplate.update(SQL_UPDATE_PW, vo.getPw(), vo.getId());				
			}else if(vo.getPw()=="") {
				res=jdbcTemplate.update(SQL_UPDATE_NICK, vo.getmNickname(), vo.getId());
			}else {
				res=jdbcTemplate.update(SQL_UPDATE_ALL, vo.getmNickname(), vo.getPw(), vo.getId());
			}
		} else {
			res=jdbcTemplate.update(SQL_UPDATE_STOPDATE, vo.getmStopDate(), vo.getId());
		}
		if(res<1) {
			return false;
		}
		return true;
	}
	//메일로 받은 링크인증키 업뎃
	public boolean updateMemberChk(MemberVO vo) {
		jdbcTemplate.update(SQL_UPDATE_CHK,vo.getmAuthkey(),vo.getId());
		return true;
	}
	//인증키 클릭시 플레그1 업뎃
	public boolean updateAuthStatus(MemberVO vo) {
		jdbcTemplate.update(SQL_UPDATE_FLAG,vo.getmEmail(),vo.getmAuthkey());
		return true;
	}
	//인증키 발송 후 업뎃
	public boolean updateKey(MemberVO vo) {
		jdbcTemplate.update(SQL_UPDATE_FIND_ID,vo.getmEmailChk(),vo.getmEmail());
		return true;
	}

	public MemberVO selectOneMember(MemberVO vo) {
		try {
			MemberVO mvo = new MemberVO();
			if(vo.getPw()!=null) {
				Object[] args= {vo.getId(), vo.getPw()};
				mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_LOGIN, args, new MemberRowMapper_grade());
			} else if(vo.getId()!=null) {
				Object[] args= {vo.getmEmail(), vo.getId()};
				mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_PW, args, new MemberRowMapper());
			} else {
				Object[] args= {vo.getmEmail()};
				mvo = jdbcTemplate.queryForObject(SQL_SELECTONE_ID, args, new MemberRowMapper_email());
			}
			return mvo;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public MemberVO checkNickName(MemberVO vo) {
		try {
			Object[] args = {vo.getmNickname()};
			MemberVO mvo = jdbcTemplate.queryForObject(SQL_CHECK_NICKNAME, args, new MemberRowMapper());
			return mvo;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public MemberVO checkId(MemberVO vo) {
		try {
		Object[] args = {vo.getId()};
		MemberVO mvo = jdbcTemplate.queryForObject(SQL_CHECK_ID, args, new MemberRowMapper());
		return mvo;
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public List<MemberVO> selectAll_GRADE(MemberVO vo) {
		try {
		return jdbcTemplate.query(SQL_SELECTALL_GRADE, new MemberRowMapper_grade());
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	public List<MemberVO> selectAll_REPORT(MemberVO vo) {
		try {
		return jdbcTemplate.query(SQL_SELECTALL_REPORT, new MemberRowMapper_report());
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public boolean deleteMember(MemberVO vo) {
		int res=jdbcTemplate.update(SQL_DELETE, vo.getId());
		if(res<1) {
			return false;
		}
		return true;
	}
}

// 로그인, 등급순 회원목록
class MemberRowMapper_grade implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setId(rs.getString("ID"));
		data.setPw(rs.getString("PW"));
		data.setmName(rs.getString("MNAME"));
		data.setmNickname(rs.getString("MNICKNAME"));
		data.setmEmail(rs.getString("MEMAIL"));
		data.setmEmailChk(rs.getString("MEMAILCHK"));
		data.setmJoinDate(LocalDateTime.parse(rs.getString("MJOINDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setmStopDate(LocalDateTime.parse(rs.getString("MSTOPDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setGrade(rs.getString("GRADE"));
		data.setHeartCnt(rs.getInt("HEARTCNT"));
		data.setmFlag(rs.getInt("MFLAG"));
		return data;
	}
}

// 닉네임중복확인, 아이디중복확인, 아이디찾기, 비밀번호찾기
class MemberRowMapper implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setId(rs.getString("ID"));
		data.setPw(rs.getString("PW"));
		data.setmName(rs.getString("MNAME"));
		data.setmNickname(rs.getString("MNICKNAME"));
		data.setmEmail(rs.getString("MEMAIL"));
		data.setmEmailChk(rs.getString("MEMAILCHK"));
		data.setmJoinDate(LocalDateTime.parse(rs.getString("MJOINDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setmStopDate(LocalDateTime.parse(rs.getString("MSTOPDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		return data;
	}
}

// 신고순 회원목록
class MemberRowMapper_report implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		MemberVO data=new MemberVO();
		data.setId(rs.getString("ID"));
		data.setPw(rs.getString("PW"));
		data.setmName(rs.getString("MNAME"));
		data.setmNickname(rs.getString("MNICKNAME"));
		data.setmEmail(rs.getString("MEMAIL"));
		data.setmEmailChk(rs.getString("MEMAILCHK"));
		data.setmJoinDate(LocalDateTime.parse(rs.getString("MJOINDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setmStopDate(LocalDateTime.parse(rs.getString("MSTOPDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setGrade(rs.getString("GRADE"));
		data.setHeartCnt(rs.getInt("HEARTCNT"));
		return data;
	}
}

class MemberRowMapper_email implements RowMapper<MemberVO> {
	@Override
	public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println();
		MemberVO data=new MemberVO();
		data.setId(rs.getString("ID"));
		data.setPw(rs.getString("PW"));
		data.setmName(rs.getString("MNAME"));
		data.setmNickname(rs.getString("MNICKNAME"));
		data.setmEmail(rs.getString("MEMAIL"));
		data.setmEmailChk(rs.getString("MEMAILCHK"));
		data.setmJoinDate(LocalDateTime.parse(rs.getString("MJOINDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setmStopDate(LocalDateTime.parse(rs.getString("MSTOPDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		data.setmFlag(rs.getInt("MFLAG"));
		return data;
	}
}