package com.spring.biz.comment;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("CommentDAO")
public class CommentDAO {
	
//	// 댓글 추가 
//	private final String SQL_INSERT = "INSERT INTO COMMENT(CGROUP,CSEQUENCE,CCONTENT,CDATE,CID,CBNUM) VALUES(?,?,?,NOW(),?,?)";
//	// 댓글 수정
//	private final String SQL_UPDATE = "UPDATE COMMENT SET CCONTENT=? WHERE CNUM=?";
//	// 댓글블라인드(삭제)
//	private final String SFQL_UPDATE_BLIND = "UPDATE COMMENT SET CCONTENT='(알수없음)', CID='(알수없음)' WHERE CNUM=?";
//	//탈퇴시 댓글블라인드(삭제) 
//	private final String SQL_UPDATE_ACCOUNT = "UPDATE COMMENT SET CCONTENT='(알수없음)', CID='(알수없음)' WHERE CID=?";
//	// 댓글 삭제
//	private final String SQL_DELETE = "DELETE FROM COMMENT WHERE CNUM=? ";
//	// 댓글 목록 
//	private final String SQL_SELECT_ALL = "SELECT * FROM COMMENT WHERE CBNUM=? ORDER BY CGROUP, CSEQUENCE";
//	//나의 댓글 목록 (최신순)
//	private final String SQL_SELECT_ALl_MYCOMMENTLIST= "SELECT * FROM COMMENT ORDER BY CDATE DESC";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

//	public boolean insertComment(CommentVO cvo) {
//		int res = jdbcTemplate.update(SQL_INSERT, cvo.getCgroup(),cvo.getCsequence(),cvo.getCcontent(),cvo.getCdate(),cvo.getCid(),cvo.getCbnum());
//		if(res<1) {
//			return false;
//		}
//		return true;
//	}
//
//	public boolean updateComment(CommentVO cvo) {
//		int res = 0;
//		if(cvo.getCid()==null) {
//			res=jdbcTemplate.update(SQL_UPDATE,cvo.getCcontent(),cvo.getCnum());
//		}else if(cvo.getCid()!= null) {
//			res=jdbcTemplate.update(SQL_UPDATE_ACCOUNT,cvo.getCid());
//		}else {
//			res=jdbcTemplate.update(SQL_UPDATE_BLIND, cvo.getCid());
//		}
//		if(res<1) {
//			return false;
//		}
//		return true;
//	}
//
//	public boolean deleteComment(CommentVO cvo) {
//		int res = jdbcTemplate.update(SQL_DELETE,cvo.getCnum());
//		if(res<1) {
//			return false;
//		}
//		return true;
//	}
//
//	public List<CommentVO> selectAll(CommentVO cvo) {
//		if(cvo.getCid()==null) {
//			Object[] args = {cvo.getCnum()};
//			return jdbcTemplate.query(SQL_SELECT_ALL,args,new CommentRowMapper());
//		}else {
//			return jdbcTemplate.query(SQL_SELECT_ALl_MYCOMMENTLIST,new CommentRowMapper());
//		}
//	}
	
	class CommentRowMapper implements RowMapper<CommentVO>{
		public CommentVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			CommentVO data = new CommentVO();
			data.setcNum(rs.getInt("CNUM"));
			data.setcGroup(rs.getInt("CGROUP"));
			data.setcSequence(rs.getInt("CSEQUENCE"));
			data.setcContent(rs.getString("CCONTENT"));
			data.setcDate(LocalDateTime.parse(rs.getString("CDATE"), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
			data.setcId(rs.getString("CID"));
			data.setcBnum(rs.getInt("CBNUM"));
			data.setHeartCnt(rs.getInt("HEARTCNT"));
			return data;
		}
	}
}