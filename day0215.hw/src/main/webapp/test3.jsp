<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form, button {
	display: flex;
    flex-direction: column;
    width: 20%;
    margin-bottom: 30px;
}
form input {
	margin-bottom: 5px;
}
button {
	align-items: center;
}
</style>
</head>
<body>
<h3>뒤로가기</h3>
<button onClick="location.href='mypage.do'">뒤로가기</button>
<h3>게시글</h3>
<c:if test="${bList.size() == 0}">
<p>게시글이 없네요...<p>
</c:if>
<c:forEach var="v" items="${bList}" begin="0" end="${bList.size()}" varStatus="status">
	<c:if test="${v.writer == id}">
		<form action="updateBoard.do" method="post">
			<input type="hidden" name="bid" value="${v.bid}" />
			<input type="text" name="writer" placeholder="writer" value="${v.writer}" readonly />
			<input type="text" name="title" placeholder="title" value="${v.title}" required />
			<input type="text" name="content" placeholder="content" value="${v.content}" required />
			<input type="submit" value="수정하기" />
			<input type="button" value="삭제하기" onclick="location.href='deleteBoard.do?bid=${v.bid}'" />
		</form>
	</c:if>
	<c:if test="${v.writer != id}">
		<form action="updateBoard.do" method="post">
			<input type="text" name="writer" placeholder="writer" value="${v.writer}" readonly />
			<input type="text" name="title" placeholder="title" value="${v.title}" readonly />
			<input type="text" name="content" placeholder="content" value="${v.content}" readonly />
		</form>
	</c:if>
</c:forEach>

</body>
</html>