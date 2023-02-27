package com.spring.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {

	// 게시글 작성
	private final String SQL_INSERT = "INSERT INTO BOARD(BTITLE,CONTENT, BCATE, BDATE, BID) VALUSE(?,?,?,NOW(),?)";
	// 게시글 수정
	private final String SQL_UPDATE = "UPDATE BOARD SET BTITLE=?,BCONTENT=? WHERE BNUM=?";
	// 게시글 조회수 증가
	private final String SQL_UPDATE_BHITS = "UPDATE BOARD SET BHITS=BHITS+1 WHERE BNUM=?";
	// 게시글 삭제
	private final String SQL_DELETE = "DELETE FROM BOARD WHERE BNUM=?";
	// 탈퇴한 사람 게시글 삭제
	private final String SQL_DELETE_MEMBER = "DELECT FROM BOARD WHERE BID=?";
	// 게시글 상세보기
	private final String SQL_SELECTONE = 
			"SELECT *\n"
			+ "FROM (\n"
			+ "	SELECT *, COUNT(HNUM) AS HEARTCNT\n"
			+ "	FROM (\n"
			+ "		SELECT *\n"
			+ "		FROM(\n"
			+ "			SELECT * \n"
			+ "			FROM BOARD \n"
			+ "			WHERE BNUM=?\n"
			+ "		) B\n"
			+ "		JOIN MEMBER M \n"
			+ "		ON B.BID = M.ID\n"
			+ "	) BM\n"
			+ "	JOIN HEART H \n"
			+ "	ON BM.BNUM = H.HBNUM\n"
			+ "	GROUP BY BM.BNUM\n"
			+ ") HBM\n"
			+ "JOIN GRADE G \n"
			+ "ON HBM.HEARTCNT BETWEEN G.GMIN AND G.GMAX;";
	// 카테고리 최신순
	private final String SQL_SELECTALL_CATE_RECENT = 
			"SELECT *, COUNT(C.CNUM) AS COMMENTCNT\n"
			+ "FROM (\n"
			+ "	SELECT B.*, M.*, COUNT(*) AS HEARTCNT \n"
			+ "	FROM BOARD B \n"
			+ "	JOIN MEMBER M \n"
			+ "	ON B.BID=M.ID \n"
			+ "	LEFT JOIN HEART H \n"
			+ "	ON B.BNUM=H.HBNUM \n"
			+ "	GROUP BY B.BNUM\n"
			+ "	HAVING BCATE='CATE1'\n"
			+ ") A\n"
			+ "JOIN GRADE G \n"
			+ "ON A.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
			+ "LEFT JOIN COMMENT C \n"
			+ "ON A.BNUM=C.CBNUM\n"
			+ "GROUP BY A.BNUM\n"
			+ "ORDER BY BDATE DESC;";
	// 카테고리 조회순
	private final String SQL_SELECTALL_CATE_HITS = 
			"SELECT *, COUNT(C.CNUM) AS COMMENTCNT\n"
			+ "FROM (\n"
			+ "	SELECT B.*, M.*, COUNT(*) AS HEARTCNT \n"
			+ "	FROM BOARD B \n"
			+ "	JOIN MEMBER M \n"
			+ "	ON B.BID=M.ID \n"
			+ "	LEFT JOIN HEART H \n"
			+ "	ON B.BNUM=H.HBNUM \n"
			+ "	GROUP BY B.BNUM\n"
			+ "	HAVING BCATE='CATE1'\n"
			+ ") A\n"
			+ "JOIN GRADE G \n"
			+ "ON A.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
			+ "LEFT JOIN COMMENT C \n"
			+ "ON A.BNUM=C.CBNUM\n"
			+ "GROUP BY A.BNUM\n"
			+ "ORDER BY BHITS DESC;";
	// 메인 좋아요순 목록
	private final String SQL_SELECTALL_MAIN_HEARTCNT = "SELECT *, COUNT(HNUM) AS HCNT FROM BOARD B LEFT JOIN HEART H ON B.BNUM = H.HBNUM GROUP BY B.BNUM ORDER BY HCNT DESC;";
	// 메인 최신순 목록
	private final String SQL_SELECTALL_MAIN_RECENT = "SELECT * FROM BOARD ORDER BY BDATE DESC;";
	// 태그 검색 목록
	private final String SQL_SELECTALL_TAG = 
			"	SELECT TBMCH.*, G.GRADE\n"
			+ "	FROM (\n"
			+ "		SELECT TBMC.*, COUNT(HNUM) AS HEARTCNT\n"
			+ "		FROM (\n"
			+ "			SELECT TB.*, M.*, COUNT(CNUM) AS COMENTCNT\n"
			+ "			FROM (\n"
			+ "					SELECT *\n"
			+ "					FROM TAG T\n"
			+ "					JOIN BOARD B \n"
			+ "					ON T.TBNUM = B.BNUM\n"
			+ "					WHERE TCONTENT=? \n"
			+ "			) TB\n"
			+ "			JOIN MEMBER M\n"
			+ "			ON TB.BID = M.ID\n"
			+ "			LEFT JOIN COMMENT C\n"
			+ "			ON TB.BNUM = C.CBNUM\n"
			+ "			GROUP BY BNUM\n"
			+ "		) TBMC\n"
			+ "		LEFT JOIN HEART H\n"
			+ "		ON TBMC.BNUM = H.HBNUM\n"
			+ "		GROUP BY BNUM\n"
			+ "	) TBMCH\n"
			+ "	JOIN GRADE G\n"
			+ "	ON TBMCH.HEARTCNT \n"
			+ "	BETWEEN G.GMIN AND G.GMAX\n"
			+ "	ORDER BY TBMCH.BDATE DESC;";
	// 나의 게시글 목록
	private final String SQL_SELECTALL_MY = "SELECT * FROM BOARD WHERE BID=? ORDER BY BDATE DESC";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertBoard(BoardVO vo) {
		int res = jdbcTemplate.update(SQL_INSERT, vo.getbTitle(), vo.getbContent(), vo.getbCate(), vo.getbId());
		if (res < 1) {
			return false;
		}
		return true;
	}

	public boolean updateBoard(BoardVO vo) {
		int res = 0;
		if (vo.getbTitle() == null) {
			res = jdbcTemplate.update(SQL_UPDATE_BHITS, vo.getbNum());
		} else {
			res = jdbcTemplate.update(SQL_UPDATE, vo.getbTitle(), vo.getbContent(), vo.getbNum());
		}
		if (res < 1) {
			return false;
		}
		return true;
	}

	public boolean deleteBoard(BoardVO vo) {
		int res = 0;
		if (vo.getbId() == null) {
			res = jdbcTemplate.update(SQL_DELETE, vo.getbNum());
		} else {
			res = jdbcTemplate.update(SQL_DELETE_MEMBER, vo.getbId());
		}
		if (res < 1) {
			return false;
		}
		return true;
	}

	public BoardVO selectOneBoard(BoardVO vo) {
		Object[] args= {vo.getbNum()};
		BoardVO bvo = jdbcTemplate.queryForObject(SQL_SELECTONE, args, new BoardRowMapper());
		return bvo;
	}
	
	public List<BoardVO> selectAll_cate_recent(BoardVO vo){
		return jdbcTemplate.query(SQL_SELECTALL_CATE_RECENT, new BoardRowMapper());
	}
	public List<BoardVO> selectAll_cate_hits(BoardVO vo){
		return jdbcTemplate.query(SQL_SELECTALL_CATE_HITS, new BoardRowMapper());
	}
	public List<BoardVO> selectAll_main_recent(BoardVO vo){
		return jdbcTemplate.query(SQL_SELECTALL_MAIN_RECENT, new BoardRowMapper());
	}
	public List<BoardVO> selectAll_main_heartCnt(BoardVO vo){
		return jdbcTemplate.query(SQL_SELECTALL_MAIN_HEARTCNT, new BoardRowMapper());
	}
	public List<BoardVO> selectAll(BoardVO vo) {
		if(vo.getTag() != null) {
			Object[] args = {vo.getbId()};
			return jdbcTemplate.query(SQL_SELECTALL_TAG, args, new BoardRowMapper());
		} else {
			Object[] args = {vo.getbId()};
			return jdbcTemplate.query(SQL_SELECTALL_MY, args, new BoardRowMapper());
		}
	}

	class BoardRowMapper implements RowMapper<BoardVO> {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setbNum(rs.getInt("BNUM"));
			data.setbTitle(rs.getString("BTITLE"));
			data.setbContent(rs.getString("BCONTENT"));
			data.setbCate(rs.getString("BCATE"));
			data.setbDate(LocalDateTime.parse(rs.getString("BDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setbHits(rs.getInt("BHITS"));
			data.setbId(rs.getString("BID"));
			data.setGrade(rs.getString("GRADE"));
			data.setmNickName(rs.getString("MNICKNAME"));
			data.setCommentCnt(rs.getInt("COMMENTCNT"));
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			data.setReportCnt(rs.getInt("REPORTCNT"));
			data.setTag(rs.getString("TAG"));
			return data;
		}
	}

}
