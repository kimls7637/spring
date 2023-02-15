<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${bList.size() == 0}">
게시글이 없습니다.
</c:if>
<c:forEach var="v" items="${bList}" begin="0" end="${bList.size()}" varStatus="status">
	제목 : ${v.title}		
	작성자 : ${v.writer}
	내용 : ${v.content}
	<br>		
</c:forEach>

<button onClick="location.href='test2.jsp'">돌아가기</button>

</body>
</html>