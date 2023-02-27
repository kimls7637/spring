package com.spring.biz.member;

import java.util.List;


public interface MemberService {
	public boolean insertMember(MemberVO vo);
	public boolean updateMember(MemberVO vo);
	public boolean deleteMember(MemberVO vo);
	public List<MemberVO> selectAll(MemberVO vo);
	public MemberVO selectOne(MemberVO vo);
}
