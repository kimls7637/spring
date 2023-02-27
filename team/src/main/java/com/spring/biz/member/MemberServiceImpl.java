package com.spring.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO MemberDAO;

	@Override
	public boolean insertMember(MemberVO vo) {
		return MemberDAO.insertMember(vo);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return MemberDAO.updateMember(vo);
	}

	@Override
	public MemberVO selectOneMember(MemberVO vo) {
		return MemberDAO.selectOneMember(vo);
	}

	@Override
	public List<MemberVO> selectAll_GRADE(MemberVO vo) {
		return MemberDAO.selectAll_GRADE(vo);
	}

	@Override
	public List<MemberVO> selectAll_REPORT(MemberVO vo) {
		return MemberDAO.selectAll_REPORT(vo);
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		return MemberDAO.deleteMember(vo);
	}

}
