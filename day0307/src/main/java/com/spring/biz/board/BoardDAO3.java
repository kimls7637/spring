package com.spring.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("boardDAO")
public class BoardDAO3 {
   // Mybatis 프레임워크
   //  -> 해당 프레임워크에서 제공해주는 객체를 사용해야함!
	@Autowired
   private SqlSessionTemplate mybatis;
   
   public boolean insertBoard(BoardVO vo) {
      System.out.println("BoardDAO3의 insert()");
      mybatis.insert("BoardDAO.insertBoard", vo);
      // "namespace.id"
      return true;
   }
   public boolean updateBoard(BoardVO vo) {
      int res=mybatis.update("BoardDAO.updateBoard", vo);
      if(res<1) {
         return false;
      }
      return true;
   }
   public boolean deleteBoard(BoardVO vo) {
      int res=mybatis.delete("BoardDAO.deleteBoard", vo);
      if(res<1) {
         return false;
      }
      return true;
   }

   public List<BoardVO> selectAll(BoardVO vo) {
      System.out.println("BoardDAO3의 selectAll()");
      return mybatis.selectList("BoardDAO.selectBoardList", vo);
   }
   public BoardVO selectOne(BoardVO vo) {
      return mybatis.selectOne("BoardDAO.selectBoard", vo);
   }
}