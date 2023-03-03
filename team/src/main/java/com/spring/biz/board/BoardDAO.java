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
	private final String SQL_INSERT = "INSERT INTO BOARD2(BTITLE, BCONTENT, BCATE, BID) VALUES (?,?,?,?)";
	// 게시글 수정
	private final String SQL_UPDATE = "UPDATE BOARD2 SET BTITLE=?,BCONTENT=? WHERE BNUM=?";
	// 게시글 조회수 증가
	private final String SQL_UPDATE_BHITS = "UPDATE BOARD2 SET BHITS=BHITS+1 WHERE BNUM=?";
	// 게시글 삭제
	private final String SQL_DELETE = "DELETE FROM BOARD2 WHERE BNUM=?";
	// 탈퇴한 사람 게시글 삭제
	private final String SQL_DELETE_MEMBER = "DELECT FROM BOARD2 WHERE BID=?";
	// 게시글 상세보기
	private final String SQL_SELECTONE = 
			"SELECT *\n"
					+ "FROM (\n"
					+ "   SELECT *, COUNT(HNUM) AS HEARTCNT\n"
					+ "   FROM (\n"
					+ "      SELECT *\n"
					+ "      FROM(\n"
					+ "         SELECT * \n"
					+ "         FROM BOARD2 \n"
					+ "         WHERE BNUM=?\n"
					+ "      ) B\n"
					+ "      JOIN MEMBER2 M \n"
					+ "      ON B.BID = M.ID\n"
					+ "   ) BM\n"
					+ "   JOIN HEART2 H \n"
					+ "   ON BM.BNUM = H.HBNUM\n"
					+ "   GROUP BY BM.BNUM\n"
					+ ") HBM\n"
					+ "JOIN GRADE2 G \n"
					+ "ON HBM.HEARTCNT BETWEEN G.GMIN AND G.GMAX;";
	// 카테고리 최신순
	private final String SQL_SELECTALL_CATE_RECENT = 
			"SELECT *, COUNT(C.CNUM) AS COMMENTCNT\n"
					+ "FROM (\n"
					+ "   SELECT B.*, M.*, COUNT(*) AS HEARTCNT \n"
					+ "   FROM BOARD2 B \n"
					+ "   JOIN MEMBER2 M \n"
					+ "   ON B.BID=M.ID \n"
					+ "   LEFT JOIN HEART2 H \n"
					+ "   ON B.BNUM=H.HBNUM \n"
					+ "   GROUP BY B.BNUM\n"
					+ "   HAVING BCATE='CATE1'\n"
					+ ") A\n"
					+ "JOIN GRADE2 G \n"
					+ "ON A.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
					+ "LEFT JOIN COMMENT2 C \n"
					+ "ON A.BNUM=C.CBNUM\n"
					+ "GROUP BY A.BNUM\n"
					+ "ORDER BY BDATE DESC;";
	// 카테고리 조회순
	private final String SQL_SELECTALL_CATE_HITS = 
			"SELECT *, COUNT(C.CNUM) AS COMMENTCNT\n"
					+ "FROM (\n"
					+ "   SELECT B.*, M.*, COUNT(*) AS HEARTCNT \n"
					+ "   FROM BOARD2 B \n"
					+ "   JOIN MEMBER2 M \n"
					+ "   ON B.BID=M.ID \n"
					+ "   LEFT JOIN HEART2 H \n"
					+ "   ON B.BNUM=H.HBNUM \n"
					+ "   GROUP BY B.BNUM\n"
					+ "   HAVING BCATE='CATE1'\n"
					+ ") A\n"
					+ "JOIN GRADE2 G \n"
					+ "ON A.HEARTCNT BETWEEN G.GMIN AND G.GMAX\n"
					+ "LEFT JOIN COMMENT2 C \n"
					+ "ON A.BNUM=C.CBNUM\n"
					+ "GROUP BY A.BNUM\n"
					+ "ORDER BY BHITS DESC;";
	// 메인 좋아요순 목록
	private final String SQL_SELECTALL_MAIN_HEARTCNT = "SELECT *, COUNT(HNUM) AS HCNT FROM BOARD2 B LEFT JOIN HEART2 H ON B.BNUM = H.HBNUM GROUP BY B.BNUM ORDER BY HCNT DESC;";
	// 메인 최신순 목록
	private final String SQL_SELECTALL_MAIN_RECENT = "SELECT * FROM BOARD2 ORDER BY BDATE DESC;";
	// 태그 검색 목록
	private final String SQL_SELECTALL_TAG = 
			"   SELECT TBMCH.*, G.GRADE\n"
					+ "   FROM (\n"
					+ "      SELECT TBMC.*, COUNT(HNUM) AS HEARTCNT\n"
					+ "      FROM (\n"
					+ "         SELECT TB.*, M.*, COUNT(CNUM) AS COMENTCNT\n"
					+ "         FROM (\n"
					+ "               SELECT *\n"
					+ "               FROM TAG2 T\n"
					+ "               JOIN BOARD2 B \n"
					+ "               ON T.TBNUM = B.BNUM\n"
					+ "               WHERE TCONTENT=? \n"
					// tag,board 조인하여 tbnum과 bnum의 같은 tcontent
					+ "         ) TB\n"
					+ "         JOIN MEMBER2 M\n"
					+ "         ON TB.BID = M.ID\n"
					+ "         LEFT JOIN COMMENT2 C\n"
					+ "         ON TB.BNUM = C.CBNUM\n"
					+ "         GROUP BY BNUM\n"
					// 그 tag의 tbnum중에 게시글 번호
					+ "      ) TBMC\n"
					+ "      LEFT JOIN HEART2 H\n"
					+ "      ON TBMC.BNUM = H.HBNUM\n"
					+ "      GROUP BY BNUM\n"
					// 좋아요 숫자
					+ "   ) TBMCH\n"
					+ "   JOIN GRADE2 G\n"
					+ "   ON TBMCH.HEARTCNT \n"
					+ "   BETWEEN G.GMIN AND G.GMAX\n"
					+ "   ORDER BY TBMCH.BDATE DESC;";
	// 등급 

	// 나의 게시글 목록
	private final String SQL_SELECTALL_MY = "SELECT * FROM BOARD2 WHERE BID=? ORDER BY BDATE DESC";
	private final String SQL_SELECTALL = "SELECT * FROM BOARD2 ORDER BY BDATE DESC";



	@Autowired
	private JdbcTemplate jdbcTemplate;

	public boolean insertBoard(BoardVO vo) {
		System.out.println("BoardDAO의 insert");
		int res = jdbcTemplate.update(SQL_INSERT, vo.getbTitle(), vo.getbContent(), vo.getbCate(), vo.getbId());
		if (res < 1) {
			System.out.println("insert 실패");
			return false;
		}
		System.out.println("insert 성공");
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
		try {
			Object[] args= {vo.getbNum()};
			BoardVO bvo = jdbcTemplate.queryForObject(SQL_SELECTONE, args, new BoardRowMapper_detail());
			return bvo;
		} catch (Exception e) {
			return null;
		}
	}

	public List<BoardVO> selectAll_cate_recent(BoardVO vo){
		try {
			return jdbcTemplate.query(SQL_SELECTALL_CATE_RECENT, new BoardRowMapper_cate());
		} catch(Exception e) {
			return null;
		}
	}
	public List<BoardVO> selectAll_cate_hits(BoardVO vo){
		try {
			return jdbcTemplate.query(SQL_SELECTALL_CATE_HITS, new BoardRowMapper_cate());
		} catch(Exception e) {
			return null;
		}
	}
	public List<BoardVO> selectAll_main_recent(BoardVO vo){
		try {
			return jdbcTemplate.query(SQL_SELECTALL_MAIN_RECENT, new BoardRowMapper_recent());
		} catch(Exception e) {
			return null;
		}
	}
	public List<BoardVO> selectAll_main_heartCnt(BoardVO vo){
		try {
			return jdbcTemplate.query(SQL_SELECTALL_MAIN_HEARTCNT, new BoardRowMapper_heart());
		} catch(Exception e) {
			return null;
		}
	}

	/////////////select All 추가/////////////
	public List<BoardVO> selectAll(BoardVO vo) {
		try {
			if(vo.getTag() != null) {
				Object[] args = {vo.getbId()};
				return jdbcTemplate.query(SQL_SELECTALL_TAG, args, new BoardRowMapper_tag());
			} else if(vo.getbId()!=null) {
				Object[] args = {vo.getbId()};
				return jdbcTemplate.query(SQL_SELECTALL_MY, args, new BoardRowMapper_recent());

			}
			else {
				return jdbcTemplate.query(SQL_SELECTALL, new BoardRowMapperAll());
			}
		}catch (Exception e) {
			return null;
		}
	}
	///////////////셀렉올 왜추가한거에요요오오오ㅗㅇ? 그냥 최신순 아니에여? 
	///////////////////////////////////////////

	// 상세보기
	class BoardRowMapper_detail implements RowMapper<BoardVO> {
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
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			return data;
		}
	}

	// 카테고리 최신순, 조회순
	class BoardRowMapper_cate implements RowMapper<BoardVO> {
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
			return data;
		}
	}

	// 메인최신순, 나의게시글
	class BoardRowMapper_recent implements RowMapper<BoardVO> {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setbNum(rs.getInt("BNUM"));
			data.setbTitle(rs.getString("BTITLE"));
			data.setbContent(rs.getString("BCONTENT"));
			data.setbCate(rs.getString("BCATE"));
			data.setbDate(LocalDateTime.parse(rs.getString("BDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setbHits(rs.getInt("BHITS"));
			data.setbId(rs.getString("BID"));
			return data;
		}
	}

	// 메인 좋아요순
	class BoardRowMapper_heart implements RowMapper<BoardVO> {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setbNum(rs.getInt("BNUM"));
			data.setbTitle(rs.getString("BTITLE"));
			data.setbContent(rs.getString("BCONTENT"));
			data.setbCate(rs.getString("BCATE"));
			data.setbDate(LocalDateTime.parse(rs.getString("BDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setbHits(rs.getInt("BHITS"));
			data.setbId(rs.getString("BID"));
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			return data;
		}
	}

	// 태그검색목록
	class BoardRowMapper_tag implements RowMapper<BoardVO> {
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
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			data.setTag(rs.getString("TAG"));
			return data;
		}
	}


	///////////////////// 임시 추가///////////////////////////
	class BoardRowMapperAll implements RowMapper<BoardVO> {
		public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BoardVO data = new BoardVO();
			data.setbNum(rs.getInt("BNUM"));
			data.setbTitle(rs.getString("BTITLE"));
			data.setbContent(rs.getString("BCONTENT"));
			data.setbCate(rs.getString("BCATE"));
			data.setbDate(LocalDateTime.parse(rs.getString("BDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setbHits(rs.getInt("BHITS"));
			data.setbId(rs.getString("BID"));
			return data;
		}
	}
	/////////////////////////////////////////////////////

}