package com.spring.biz.heart;

import java.util.List;

public interface HeartService {
	public boolean insertHeart(HeartVO vo);
	public boolean deleteHeart(HeartVO vo);
	public List<HeartVO> selectAll(HeartVO vo);
}
