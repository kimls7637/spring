package com.spring.biz.tag;

import java.util.List;

import com.spring.biz.board.BoardVO;

public interface TagService {
   public boolean insertTag(TagVO tvo);
   public List<TagVO> HashTagSelectOne(BoardVO vo);
}