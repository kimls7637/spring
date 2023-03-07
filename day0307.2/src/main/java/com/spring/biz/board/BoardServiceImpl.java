package com.spring.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("boardService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardDAO BoardDAO;

	@Override
	public boolean insertBoard(BoardVO vo) {
		return BoardDAO.insertBoard(vo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return BoardDAO.updateBoard(vo);
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		return BoardDAO.deleteBoard(vo);
	}

	@Override
	public List<BoardVO> selectAll_cate_recent(BoardVO vo) {
		return BoardDAO.selectAll_cate_recent(vo);
	}

	@Override
	public List<BoardVO> selectAll_cate_hits(BoardVO vo) {
		return BoardDAO.selectAll_cate_hits(vo);
	}

	@Override
	public List<BoardVO> selectAll_main_recent(BoardVO vo) {
		return BoardDAO.selectAll_main_recent(vo);
	}

	@Override
	public List<BoardVO> selectAll_main_heartCnt(BoardVO vo) {
		return BoardDAO.selectAll_main_heartCnt(vo);
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		return BoardDAO.selectAll(vo);
	}

	@Override
	public BoardVO selectOneBoard(BoardVO vo) {
		return BoardDAO.selectOneBoard(vo);
	}
	
	@Override
	public BoardVO selectTag(BoardVO vo) {
		// TODO Auto-generated method stub
		return BoardDAO.selectTag(vo);
	}

}
