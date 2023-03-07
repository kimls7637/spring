package com.spring.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private final String SQL_INSERT="INSERT INTO BOARD(TITLE,WRITER,CONTENT) VALUES(?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET TITLE=?,CONTENT=? WHERE BID=?";
	private final String SQL_DELETE="DELETE FROM BOARD WHERE BID=?";

	private final String SQL_SELECT_ALL="SELECT * FROM BOARD";
	private final String SQL_SELECT_ONE="SELECT * FROM BOARD WHERE BID=?";
	private final String SQL_SELECT_SEARCH="SELECT * FROM BOARD WHERE TITLE=? or WRITER=? or CONTENT=?";

	public boolean insertBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	public boolean updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			int res=pstmt.executeUpdate();
			if(res<=0) {
				System.out.println("   로그 : UPDATE 수행결과없음");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	public boolean deleteBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getBid());
			int res=pstmt.executeUpdate();
			if(res<=0) {
				System.out.println("   로그 : DELETE 수행결과없음");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return datas;
	}
	
	public List<BoardVO> selectAllSearch(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>();
		conn=JDBCUtil.connect();
		try {
			System.out.println("서치");
			pstmt=conn.prepareStatement(SQL_SELECT_SEARCH);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return datas;
	}
	
	public BoardVO selectOne(BoardVO vo) {
		BoardVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setContent(rs.getString("CONTENT"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return data;
	}
}
