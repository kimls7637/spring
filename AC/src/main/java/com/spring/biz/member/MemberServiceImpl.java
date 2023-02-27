package com.spring.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;	
	
	@Override
	public boolean insertMember(MemberVO vo) {
		
		return memberDAO.insertMember(vo);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		return memberDAO.updateMember(vo);
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		return memberDAO.deleteMember(vo);
	}

	@Override
	public List<MemberVO> selectAll(MemberVO vo) {
		return memberDAO.selectAll(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		return memberDAO.selectOne(vo);
	}

}
