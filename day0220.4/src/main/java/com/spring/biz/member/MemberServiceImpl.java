package com.spring.biz.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO2 MemberDAO;

	@Override
	public boolean insertMember(MemberVO vo) {
		System.out.println("DAO2동작");
		return MemberDAO.insertMember(vo);
	}

	@Override
	public boolean updateMember(MemberVO vo) {
		System.out.println("DAO2동작");
		return MemberDAO.updateMember(vo);
	}

	@Override
	public boolean deleteMember(MemberVO vo) {
		System.out.println("DAO2동작");
		return MemberDAO.deleteMember(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		System.out.println("DAO2동작");
		return MemberDAO.selectOne(vo);
	}

}
