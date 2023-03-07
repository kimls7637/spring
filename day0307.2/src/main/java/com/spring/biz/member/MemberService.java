package com.spring.biz.member;

import java.util.List;

public interface MemberService {
	public boolean insertMember(MemberVO vo);
	public boolean updateMember(MemberVO vo);
	public boolean updateMemberChk(MemberVO vo);
	public boolean updateAuthStatus(MemberVO vo);
	public boolean updateKey(MemberVO vo);
	public MemberVO selectOneMember(MemberVO vo);
	public MemberVO checkNickName(MemberVO vo);
	public MemberVO checkId(MemberVO vo);
	public List<MemberVO> selectAll_GRADE(MemberVO vo);
	public List<MemberVO> selectAll_REPORT(MemberVO vo);
	public boolean deleteMember(MemberVO vo);
}
