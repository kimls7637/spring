package com.spring.biz.tag;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.biz.board.BoardVO;

@Service("tagService")
public class TagServiceImpl implements TagService {
   
   @Autowired
   private TagDAO TagDAO;
   
   @Override
   public boolean insertTag(TagVO tvo) {
      System.out.println("TagService의 insertTag()");
      System.out.println("tvo: "+tvo);
      return TagDAO.insertHashTagList(tvo);
   }

   @Override
   public List<TagVO> HashTagSelectOne(BoardVO vo) {
      // TODO Auto-generated method stub
      return TagDAO.HashTagSelectOne(vo);
      
   }

}