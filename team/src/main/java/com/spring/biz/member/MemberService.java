package com.spring.biz.member;

import java.util.List;

public interface MemberService {
	public boolean insertMember(MemberVO vo);
	public boolean updateMember(MemberVO vo);
	public MemberVO selectOneMember(MemberVO vo);
	public List<MemberVO> selectAll_GRADE(MemberVO vo);
	public List<MemberVO> selectAll_REPORT(MemberVO vo);
	public boolean deleteMember(MemberVO vo);
}
