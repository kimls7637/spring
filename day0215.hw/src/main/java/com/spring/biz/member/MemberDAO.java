package com.spring.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.spring.biz.common.JDBCUtil;
import org.springframework.stereotype.Repository;

public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	
	private final String SQL_INSERT="INSERT INTO MEMBER(MID,MPW,MNAME,ROLE) VALUES(?,?,?,?)";
	private final String SQL_UPDATE="UPDATE MEMBER SET MPW=?, MNAME=?, ROLE=? WHERE MID=?";
	private final String SQL_DELETE="DELETE FROM MEMBER WHERE MID=?";
	private final String SQL_SELECT_ALL="SELECT * FROM MEMBER;";
	private final String SQL_SELECT_ONE="SELECT * FROM MEMBER WHERE MID=? AND MPW=?";
	private final String SQL_SELECT_ID="SELECT * FROM MEMBER WHERE MID=?";
	
	public boolean insertMember(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getMid());
			pstmt.setString(2, vo.getMpw());
			pstmt.setString(3, vo.getMname());
			pstmt.setString(4, vo.getRole());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	public boolean updateMember(MemberVO vo) {
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getMpw());
			pstmt.setString(2, vo.getMname());
			pstmt.setString(3, vo.getRole());
			pstmt.setString(4, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	public boolean deleteMember(MemberVO vo) {
		conn = JDBCUtil.connect();
		try { 
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, vo.getMid());
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return true;
	}
	
	public ArrayList<MemberVO> selectAll(MemberVO vo) {
		ArrayList<MemberVO> datas = new ArrayList<MemberVO>();
		conn = JDBCUtil.connect();
		try {
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data = new MemberVO();
				data.setMid(rs.getString("MID"));
				data.setMpw(rs.getString("MPW"));
				data.setMname(rs.getString("MNAME"));
				data.setRole(rs.getString("ROLE"));
				datas.add(data);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.disconnect(conn, pstmt);
		}
		return datas;
	}
	public MemberVO selectOne(MemberVO vo) {
		MemberVO data = null;
		conn = JDBCUtil.connect();
		if(vo.getMpw() == null) {
			try {
				pstmt = conn.prepareStatement(SQL_SELECT_ID);
				pstmt.setString(1, vo.getMid());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					data = new MemberVO();
					data.setMid(rs.getString("MID"));
					data.setMpw(rs.getString("MPW"));
					data.setMname(rs.getString("MNAME"));
					data.setRole(rs.getString("ROLE"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally { 
				JDBCUtil.disconnect(conn, pstmt);
			}
			return data;
		} else {
			try {
				pstmt = conn.prepareStatement(SQL_SELECT_ONE);
				pstmt.setString(1, vo.getMid());
				pstmt.setString(2, vo.getMpw());
				ResultSet rs = pstmt.executeQuery();
				if(rs.next()) {
					data = new MemberVO();
					data.setMid(rs.getString("MID"));
					data.setMpw(rs.getString("MPW"));
					data.setMname(rs.getString("MNAME"));
					data.setRole(rs.getString("ROLE"));
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
}
