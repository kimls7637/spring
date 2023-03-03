<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<select id="esul">
	<option>전국</option>
	<option>경기도</option>
	<option>강원도</option>
	<option>제주도</option>
	<option>충청남도</option>
	<option>충청북도</option>
	<option>경상남도</option>
	<option>경상북도</option>
	<option>전라남도</option>
	<option>전라북도</option>
</select>

<select id="esul2">
	<option>전체</option>
</select>


</body>

<script>
const es = document.getElementById("esul");
const es2 = document.getElementById("esul2");

es.addEventListener('change', function(){
	console.log("냐");
	console.log(es.value);
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option><option>가평군</option><option>양평군</option><option>남양주시</option><option>용인시</option><option>전체</option><option>전체</option><option>전체</option><option>전체</option><option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
	es2.innerHTML = "<option>전체</option>";
})


</script>




</html>