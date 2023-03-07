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
<img class="esull" src="./images/logo.svg"/>
<img class="esull" src=""/>
<script>

const esul = document.getElementById("esul");
esul.addEventListener('click', function(){
	if(esul.style.color == "red"){
		esul.style.color = "black";
	} else{
		esul.style.color = "red";
	}
})

const esul2 = document.getElementsByClassName("esull");
console.log(esul2.length);
for(let i = 0; i < esul2.length; i++){
	esul2[i].addEventListener('click', function(){
		console.log(i+"뻔쨰클릭");
	})
}

</script>



</html>