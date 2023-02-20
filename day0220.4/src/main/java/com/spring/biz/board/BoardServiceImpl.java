package com.spring.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAO2 boardDAO;

	@Override
	public boolean insertBoard(BoardVO vo) {
		System.out.println("DAO2동작");
		/*
		if(vo.getWriter().equals("timo")) {
			throw new IllegalArgumentException("일부러 발생시킨 예외");
		}
		*/
		return boardDAO.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		System.out.println("DAO2동작");
		return boardDAO.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		System.out.println("DAO2동작");
		return boardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		System.out.println("DAO2동작");
		return boardDAO.selectAll(vo);
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		System.out.println("DAO2동작");
		return boardDAO.selectOne(vo);
	}

}
