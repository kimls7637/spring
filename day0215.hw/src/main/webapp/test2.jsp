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

<h3>정보변경 / 회원탈퇴</h3>
<form action="updateMember.do" method="post">
	<input type="text" name="id" value="${member.mid}" readonly />
	<input type="password" name="pw" placeholder="pw" value="${member.mpw}" required />
	<input type="text" name="name" placeholder="name" value="${member.mname}" required />
	<input type="text" name="role" placeholder="role" value="${member.role}" required />
	<input type="submit" value="변경하기" />
</form>
<button onClick="location.href='deleteMember.do'">탈퇴하기</button>

<h3>글작성</h3>
<form action="insertBoard.do" method="post">
	<input type="text" name="title" placeholder="title" required />
	<input type="text" name="content" placeholder="content" required />
	<input type="submit" value="작성하기" />
</form>

<h3>검색 / 조회</h3>
<form action="searchBoard.do" method="post">
	<input type="text" name="title" placeholder="title" required />
	<input type="submit" value="검색하기" />
</form>
<button onClick="location.href='selectBoard.do'">전체보기</button>

<h3>로그아웃</h3>
<button onClick="location.href='logout.do'">로그아웃</button>

<script>
	if('${msg}' != '') {
		alert('${msg}');	
	}
</script>
</body>
</html>