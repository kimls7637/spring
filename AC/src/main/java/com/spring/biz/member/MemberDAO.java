package com.spring.biz.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.biz.common.JDBCUtil;

@Repository("memberDAO")
public class MemberDAO {
	private Connection conn;
	private PreparedStatement pstmt;

	private final String SQL_INSERT="INSERT INTO MEMBER (MID,MPW,MNAME) VALUES (?,?,?)";
	private final String SQL_UPDATE="UPDATE BOARD SET MPW=?,MNAME=? WHERE MID=?";
	private final String SQL_DELETE="DELETE FROM MEMBER WHERE MID=?";

	private final String SQL_SELECT_ALL="SELECT * FROM MEMBER";
	private final String SQL_SELECT_ONE="SELECT * FROM MEMBER WHERE MID=?";

	public boolean insertMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_INSERT);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPw());
			pstmt.setString(3, vo.getmName());
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

	public boolean updateMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_UPDATE);
			pstmt.setString(1, vo.getPw());
			pstmt.setString(2, vo.getmName());
			pstmt.setString(3, vo.getId());
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

	public boolean deleteMember(MemberVO vo) {
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_DELETE);
			pstmt.setString(1, vo.getId());
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

	public List<MemberVO> selectAll(MemberVO vo) {
		System.out.println("1");
		List<MemberVO> datas=new ArrayList<MemberVO>(); // 리스트는 추상화 new안됨
		System.out.println("2");
		conn=JDBCUtil.connect();
		System.out.println("3");
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_ALL);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				MemberVO data=new MemberVO();
				data.setId(rs.getString("MID"));
				data.setPw(rs.getString("MPW"));
				data.setmName(rs.getString("MNAME"));
				data.setRole(rs.getString("ROLE"));
				datas.add(data);
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(conn, pstmt);
		return datas;
	}

	public MemberVO selectOne(MemberVO vo) {
		MemberVO data=null;
		conn=JDBCUtil.connect();
		try {
			pstmt=conn.prepareStatement(SQL_SELECT_ONE);
			pstmt.setString(1, vo.getId());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				data=new MemberVO();
				data.setId(rs.getString("MID"));
				data.setPw(rs.getString("MPW"));
				data.setmName(rs.getString("MNAME"));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		JDBCUtil.disconnect(conn, pstmt);
		return data;
	}
}
