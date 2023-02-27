package com.spring.biz.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import com.spring.biz.common.JDBCUtil;

// 모델영역

// DAO류라는 것을 안다 모델이 돌아가는시점에 만들어진다
@Repository("boardDAO")
public class BoardDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	


	private final String SQL_INSERT="INSERT INTO BOARD (TITLE, WRITER, CONTENT) VALUES (?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET TITLE=?,WRITER=?,CONTENT=? WHERE BID=?";
	private final String SQL_DELETE="DELETE FROM BOARD WHERE BID=?";

	private final String SQL_SELECT_ALL="SELECT * FROM BOARD";
	private final String SQL_SELECT_ONE="SELECT * FROM BOARD WHERE BID=?";

	public boolean insertBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			int res=pstmt.executeUpdate();
			if(res<=0) {
				return false;
			}
		}

		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(conn, pstmt);
		return true;
	}

	public boolean updateBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			pstmt.setInt(4, vo.getBid());
			int res=pstmt.executeUpdate();
			if(res<=0) {
				return false;
			}

		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(conn, pstmt);
		return true;
	}

	public boolean deleteBoard(BoardVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, vo.getBid());
			int res=pstmt.executeUpdate();
			if(res<=0) {
				return false;
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return false;
		}
		JDBCUtil.disconnect(conn, pstmt);
		return true;
	}

	public List<BoardVO> selectAll(BoardVO vo) {
		List<BoardVO> datas=new ArrayList<BoardVO>(); // 리스트는 추상화 new안됨
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardVO data=new BoardVO();
				data.setBid(rs.getInt("BID"));
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
				datas.add(data);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(conn, pstmt);
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
				data.setTitle(rs.getString("TITLE"));
				data.setWriter(rs.getString("WRITER"));
				data.setContent(rs.getString("CONTENT"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(conn, pstmt);
		return data;
	}
}
