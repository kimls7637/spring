package com.spring.biz.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public boolean insertBoard(BoardVO vo) {
		if(vo.getWriter().equals("timo")) {
			throw new NumberFormatException("내가만든에러발생!!");
		}
		return boardDAO.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return boardDAO.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		return boardDAO.deleteBoard(vo);
	}

	@Override
	public ArrayList<BoardVO> selectAll(BoardVO vo) {
		return boardDAO.selectAll(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		return boardDAO.selectOne(vo);
	}

}
