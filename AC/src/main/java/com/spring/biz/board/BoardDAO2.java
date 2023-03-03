package com.spring.biz.board;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

public class BoardDAO2 { // 스프링 JDBC를 활용하는 DAO(버전 업그레이드)
	// DI 의존주입
	@Autowired // 메모리에 있는 객체 넣어줘~ 메모리에 만들러가야지~! xml로
	private JdbcTemplate jdbcTemplate; // 템플릿클래스 가져와서 쓸래

	private final String SQL_INSERT="INSERT INTO BOARD (TITLE, WRITER, CONTENT) VALUES (?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET TITLE=?,WRITER=?,CONTENT=? WHERE BID=?";
	private final String SQL_DELETE="DELETE FROM BOARD WHERE BID=?";

	private final String SQL_SELECT_ALL="SELECT * FROM BOARD";
	// MySQL일때 검색
	private final String SQL_SELECT_SEARCH="SELECT * FROM BOARD WHERE WRITER LIKE CONCAT('%',?,'%')";
	private final String SQL_SELECT_ONE="SELECT * FROM BOARD WHERE BID=?";

	public boolean insertBoard(BoardVO vo) {
		System.out.println("BoardDAO2의 insert()");
		jdbcTemplate.update(SQL_INSERT,vo.getTitle(),vo.getWriter(),vo.getContent()); // CUD는 update()사용
		// pstmt set하는 부분이라고 보면됨, sql문,?에 차례대로 들어갈 값
		// 첫번째인자는 sql문 그뒤로는 자유 설정 
		return true;
	}

	public boolean updateBoard(BoardVO vo) {
		jdbcTemplate.update(SQL_UPDATE,vo.getTitle(),vo.getWriter(),vo.getBid()); // CUD는 update()사용
		return true;
	}

	public boolean deleteBoard(BoardVO vo) {
		jdbcTemplate.update(SQL_DELETE,vo.getBid()); // CUD는 update()사용
		return true;
	}

	public List<BoardVO> selectAll(BoardVO vo) { // 셀렉올은 query()
		System.out.println("BoardDAO2의 selectAll()");
		if(vo == null) {
			return jdbcTemplate.query(SQL_SELECT_ALL, new BoardRowMapper());
		}
		else{
			Object[] args = {vo.getWriter()}; 
			return jdbcTemplate.query(SQL_SELECT_SEARCH, args, new BoardRowMapper());
		}

		// 첫번째 인자는 무조건 sql, 마지막인자 중요함
		// output만들어내는 과정필요했었음
		// output을 만들어주는 작업을 다른 클래스에게 맡길것(BoardRowMapper)★ 아래에서 직접 만들것
	}

	public BoardVO selectOne(BoardVO vo) { // 셀렉원은 queryForObject()
		// 타입을 모르는 여러가지 것들이 들어올예정이기때문에 Object로 사용
		Object[] args = {vo.getBid()}; // 물음표설정부분, 물음표에 넣을것 일일히 넣어주면됨
		return jdbcTemplate.queryForObject(SQL_SELECT_ONE, args, new BoardRowMapper());
		// 첫번째 인자는 무조건 sql, 마지막인자 중요함 
		// 사이에 물음표 무한하게 넣지않고, 오브젝트 배열(인자값 묶음)을 넣어둠★
	}
}




// 멤버에서 했으면 멤버로우매퍼일것, <>안에는 vo이름 적어줌
// ★ RowMapper: 스프링에서 제공해주는 근본 인터페이스
// 그걸 상속받아 구현한 클래스이기때문에 BoardRowMapper
// 어떤vo를 연결해서 쓰고 싶어하는지 제네릭에 적어주면 됨
// 제네릭에 내가 만든 구조를 넣어줘서 내 VO구조를 인지 시킨것
class BoardRowMapper implements RowMapper<BoardVO>{
	@Override
	public BoardVO mapRow(ResultSet rs, int rowNum) throws SQLException {
		BoardVO data=new BoardVO();
		data.setBid(rs.getInt("BID"));
		data.setTitle(rs.getString("TITLE"));
		data.setWriter(rs.getString("WRITER"));
		data.setContent(rs.getString("CONTENT"));
		return data;
	}



}
