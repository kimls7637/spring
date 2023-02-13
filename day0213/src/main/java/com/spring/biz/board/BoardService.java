package com.spring.biz.board;

import java.util.ArrayList;

public interface BoardService {
	public boolean insertBoard(BoardVO vo);
	public boolean updateBoard(BoardVO vo);
	public boolean deleteBoard(BoardVO vo);
	public ArrayList<BoardVO> selectAll(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
}
