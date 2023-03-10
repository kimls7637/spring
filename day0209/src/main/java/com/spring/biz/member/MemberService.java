package com.spring.biz.member;

import java.util.ArrayList;

public interface MemberService {
	public void insertMember(MemberVO vo);
	public void updateMember(MemberVO vo);
	public void deleteMember(MemberVO vo);
	public ArrayList<MemberVO> selectAll(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
}
