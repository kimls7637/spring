package com.spring.biz.tag;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.biz.board.BoardVO;

@Repository("tagDAO")
public class TagDAO {
   @Autowired
   private JdbcTemplate jdbcTemplate;

   private final String SQL_TAGINSERT="INSERT INTO TAG2(TCONTENT,TBNUM) VALUES(?,?)";
   private final String SQL_TAGSELECT_ONE="SELECT * FROM TAG2 WHERE TBNUM=?";
   
   public boolean insertHashTagList(TagVO tvo) {
      System.out.println("TagDAO   insertHashTagList()");
      System.out.println("tvo: "+tvo);
      jdbcTemplate.update(SQL_TAGINSERT,tvo.getTcontent(),tvo.getTbnum());
      return true;
   }   
   

   public List<TagVO> HashTagSelectOne(BoardVO vo) {
      System.out.println("TAG셀렉실행 HashTagSelectOne()");
      Object[] args= {vo.getbNum()};
      return jdbcTemplate.query(SQL_TAGSELECT_ONE, args, new TagRowMapper());
   }   
   
}

class TagRowMapper implements RowMapper<TagVO> {

   @Override
   public TagVO mapRow(ResultSet rs, int rowNum) throws SQLException {
      TagVO data=new TagVO();
      data.setTnum(rs.getInt("TNUM"));
      data.setTcontent(rs.getString("TCONTENT"));
      data.setTbnum(rs.getInt("TBNUM"));
      return data;
   }
   
}