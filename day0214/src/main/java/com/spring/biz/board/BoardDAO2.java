package com.spring.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.spring.biz.common.JDBCUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO2 {
	// DI 의존주입
	@Autowired
	private JdbcTemplate jdbcTemplate;

	private final String SQL_INSERT="INSERT INTO BOARD(TITLE,WRITER,CONTENT) VALUES(?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BID=?";
	private final String SQL_DELETE="DELETE FROM BOARD WHERE BID=?";
	private final String SQL_SELECT_ALL="SELECT * FROM BOARD WHERE WRITER=?;";
	private final String SQL_SELECT_ONE="SELECT * FROM BOARD WHERE BID=?";
	private final String SQL_SELECT_SEARCH="SELECT * FROM BOARD WHERE WRITER LIKE CONCAT('%', ?, '%')";
	

	public boolean insertBoard(BoardVO vo) {
		System.out.println("BoardDAO2의 insert()");
		jdbcTemplate.update(SQL_INSERT, vo.getTitle(), vo.getWriter(), vo.getContent());
		return true;
	}
	public boolean updateBoard(BoardVO vo) {
		jdbcTemplate.update(SQL_UPDATE, vo.getTitle(), vo.getContent(), vo.getBid());
		return true;
	}
	public boolean deleteBoard(BoardVO vo) {
		jdbcTemplate.update(SQL_DELETE, vo.getBid());
		return true;
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		Object[] args = {vo.getWriter()};
		try {
			 return jdbcTemplate.query(SQL_SELECT_ALL, args, new BoardRowMapper());
		} catch(Exception e) {
			return null;
		}
		// 아웃풋을 만들어내는 작업을 다른 클래스한테 패스할건데, 그 클래스 이름이 보드로우매퍼
	}
	public BoardVO selectOne(BoardVO vo) {
		Object[] args = {vo.getBid()};
		try {
		return jdbcTemplate.queryForObject(SQL_SELECT_ONE, args, new BoardRowMapper());
		} catch(Exception e) {
			return null;
		}
//		return jdbcTemplate.queryForObject(SQL_SELECT_ONE, args, new BoardRowMapper());
	}
	public List<BoardVO> selectSearch(BoardVO vo) {
		System.out.println("읭");
		Object[] args = {vo.getWriter()};
		try {
			 return jdbcTemplate.query(SQL_SELECT_SEARCH, args, new BoardRowMapper());
		} catch(Exception e) {
			return null;
		}
		// 아웃풋을 만들어내는 작업을 다른 클래스한테 패스할건데, 그 클래스 이름이 보드로우매퍼
	}
}

//스프링에서 제공해주는 근본 인터페이스 RowMapper
class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBid(rs.getInt("BID"));
		data.setContent(rs.getString("CONTENT"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		return data;
	}
}