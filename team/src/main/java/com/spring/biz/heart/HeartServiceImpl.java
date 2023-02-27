package com.spring.biz.heart;

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

}
