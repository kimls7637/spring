package com.spring.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

// 공통로직
// connect메서드명 변경해서 업데이트하게되면 공통로직 사용하고있는 클래스들은 문제발생
// aop없이 사용하다보니 문제발생 => oop의 한계(객체지향코드)
// aop설정으로 가져가는것이 바람직함
public class JDBCUtil {
   static final String driverName = "com.mysql.cj.jdbc.Driver";
   static final String url = "jdbc:mysql://localhost/sondb";
   static final String user = "root";
   static final String passwd = "1234";
   public static Connection connect() {
      Connection conn = null;
      try {
    	  System.out.println("commone들어옴");
         Class.forName(driverName);
         conn = DriverManager.getConnection(url, user, passwd);
         System.out.println(conn);
         
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         System.out.println("로그 : connect() 수행완료");
      }
      return conn;
   }
   public static void disconnect(Connection conn,PreparedStatement pstmt) {
      try {
         pstmt.close();
         conn.close();
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         System.out.println("로그 : disconnect() 수행완료");
      }
   }
}