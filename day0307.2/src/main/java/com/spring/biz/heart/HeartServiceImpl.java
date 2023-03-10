package com.spring.biz.heart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("heartService")
public class HeartServiceImpl implements HeartService {
	
	@Autowired
	private HeartDAO HeartDAO;

	@Override
	public boolean insertHeart(HeartVO vo) {
		return HeartDAO.insertHeart(vo);
	}

	@Override
	public boolean deleteHeart(HeartVO vo) {
		return HeartDAO.deleteHeart(vo);
	}

	@Override
	public List<HeartVO> selectAll(HeartVO vo) {
		return HeartDAO.selectAll(vo);
	}
}
