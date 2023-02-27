package com.spring.biz.board;

import java.util.List;

// 컨트롤러 영역

public interface BoardService {
	public boolean insertBoard(BoardVO vo);
	public boolean updateBoard(BoardVO vo);
	public boolean deleteBoard(BoardVO vo);
	public List<BoardVO> selectAll(BoardVO vo);
	public BoardVO selectOne(BoardVO vo);
}
