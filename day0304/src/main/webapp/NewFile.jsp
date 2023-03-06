<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div id="esul" style="cursor: pointer; font-size: 500px;">❤</div>
<script>

const esul = document.getElementById("esul");
esul.addEventListener('click', function(){
	if(esul.style.color == "red"){
		esul.style.color = "black";
	} else{
		esul.style.color = "red";
	}
})

</script>



</html>