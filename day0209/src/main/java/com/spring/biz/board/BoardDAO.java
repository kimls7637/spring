package com.spring.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.spring.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	private final String SQL_INSERT="INSERT INTO BOARD(TITLE,WRITER,CONTENT) VALUES(?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET TITLE=?, CONTENT=? WHERE BID=?";
	private final String SQL_DELETE="DELETE FROM BOARD WHERE BID=?";
	private final String SQL_SELECT_ALL="SELECT * FROM BOARD;";
	private final String SQL_SELECT_ONE="SELECT * FROM BOARD WHERE BID=?";
	
	public boolean insertBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
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
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setInt(3, vo.getBid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	public boolean deleteBoard(BoardVO vo) {
		conn = JDBCUtil.connect();
		try { 
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, vo.getWriter());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	
	public ArrayList<BoardVO> selectAll(BoardVO vo) {
		ArrayList<BoardVO> datas = new ArrayList<BoardVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data = new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
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
		BoardVO data = null;
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setInt(1, vo.getBid());
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				data = new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setTitle(rs.getString("TITLE"));
				data.setContent(rs.getString("CONTENT"));
				data.setWriter(rs.getString("WRITER"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally { 
			JDBCUtil.disconnect(conn, pstmt);
		}
		return data;
	}
}
