<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
form {
	display: flex;
    flex-direction: column;
    width: 20%;
}
form input {
	margin-bottom : 5px;
}
</style>
</head>
<body>

<h3>로그인</h3>
<form action="login.do" method="post">
	<input type="text" name="id" placeholder="id" required />
	<input type="password" name="pw" placeholder="pw" required />
	<input type="submit" value="로그인" />
</form>

<h3>회원가입</h3>
<form action="join.do" method="post">
	<input type="text" name="id" placeholder="id" required />
	<input type="password" name="pw" placeholder="pw" required />
	<input type="text" name="name" placeholder="name" required />
	<input type="text" name="role" placeholder="role" required />
	<input type="submit" value="회원가입" />
</form>

<script>
	if('${msg}' != ''){
		alert('${msg}');
	}
</script>
</body>
</html>