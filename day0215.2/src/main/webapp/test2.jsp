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

<form action="search.do" method="post">
	<input type="text" name="search" placeholder="작성자" required>
	<input type="submit" value="검색" />
</form>
<button onClick="location.href='bList.do'">전체글</button>

<form action="insertBoard.do" method="post">
	<input type="text" name="title" placeholder="제목" required>
	<input type="text" name="content" placeholder="내용" required>
	<input type="submit" value="글쓰기" />
</form>
<button onClick="location.href='logout.do'">로그아웃</button>
</body>
</html>