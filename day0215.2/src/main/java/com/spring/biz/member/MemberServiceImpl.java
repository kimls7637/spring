package com.spring.biz.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO2 mDAO;

	@Override
	public void insertMember(MemberVO vo) {
		mDAO.insertMember(vo);
		
	}

	@Override
	public void updateMember(MemberVO vo) {
		mDAO.updateMember(vo);
		
	}

	@Override
	public void deleteMember(MemberVO vo) {
		mDAO.deleteMember(vo);
		
	}

	@Override
	public List<MemberVO> selectAll(MemberVO vo) {
		return mDAO.selectAll(vo);
	}

	@Override
	public MemberVO selectOne(MemberVO vo) {
		return mDAO.selectOne(vo);
	}


}
