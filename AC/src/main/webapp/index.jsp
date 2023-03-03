<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 

   response.sendRedirect("main.do");
// 아주 작은 데이터라도  보낼려고하면 컨트롤러를 거쳐야하기에
// 필터적용 안되기때문에 .do로 보내는 게 맞다

%>