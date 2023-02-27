package com.spring.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.common.LogAdvice;

// 유사 컨트롤 역할을 하는중

// 컴포넌트를 상속받아 만들어짐
@Service("boardService")
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	// DAO를 watch처럼 사용하겠다
	// private LogAdvice la; // 객체지향 OOP마냥 멤버변수로 들어가있는것이 문제
	// 생성자주입했었음
	// 업데이트할적에 메서드명도 함께 업데이트되어서 직접 하나하나 코드를 수정해야함 문제.

	@Override
	public boolean insertBoard(BoardVO vo) {
		//  예외가 throw될적에 after-throwing 반응함
		if(vo.getWriter().equals("timo")){
			throw new IllegalArgumentException("일부러 발생시킨 예외");
		}
		
		// 비즈니스 레이어야 너가가진 다오 수행시켜줘?
		// LogAdvice la=new LogAdvice();
		// la.printLog(); 
		// 문제상황
		// : 반드시 수행해야 하는 객체(la)를 코드안에 직접 new하고있기 때문에
		// 의존관계 생겼고 결합도 높은 상태!!!
		return boardDAO.insertBoard(vo);
		
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		//la.printLog();
		return boardDAO.updateBoard(vo);
			
	}

	@Override
	public boolean deleteBoard(BoardVO vo) {
		//la.printLog();
		return boardDAO.deleteBoard(vo);
		
	}

	@Override
	public List<BoardVO> selectAll(BoardVO vo) {
		//la.printLog();
		return boardDAO.selectAll(vo);
		
	}

	@Override
	public BoardVO selectOne(BoardVO vo) {
		//la.printLog();
		return boardDAO.selectOne(vo);
	}

}
