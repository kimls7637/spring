package com.spring.biz.heart;

public interface HeartService {
	public boolean insertHeart(HeartVO vo);
	public boolean deleteHeart(HeartVO vo);
	public HeartVO selectAll(HeartVO vo);
}
