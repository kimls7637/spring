<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kwon"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<!DOCTYPE html>
<html lang="en">
<!-- 의미를 갖는 시멘틱 태그 <html -->
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with JoeBLog landing page.">
<meta name="author" content="Devcrud">
<title>ACENSE</title>
<!-- font icons -->
<link rel="stylesheet"
	href="assets/vendors/themify-icons/css/themify-icons.css">
<link rel="icon" href="./assets/imgs/favicon.png" />
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<style type="text/css">
.text-left {
	text-align: left;
}

.pn {
	padding: 50px 0 20px 0;
	font-size: 17px;
}

.like {
	padding-top: 50px;
	font-size: 16px;
}

.chat {
	padding-top: 50px;
}

.input-box {
	position: relative;
	/* margin: 10px 0; */
}

.input-box>input {
	background: transparent;
	border: none;
	border-bottom: solid 1px #ccc;
	padding: 5px 0px 5px 0px;
	font-size: 10pt;
	width: 100%;
}

.profile {
	font-size: 13px;
}

#forgot {
	color: black;
	/* margin: 15px; */
	padding-top: 20px;
	text-decoration: none;
	font-size: 13px;
	text-align: center;
}
/* #forgot a {
    text-decoration: none;
    background-color: transparent;
} */
.login {
	padding: 10px;
	margin-top: 20px;
	border: 1px solid #ffffff00;
	border-radius: 10px;
	background-color: #a0ba83;
	color: white;
}

.login:hover {
	color: black;
}

.login button {
	color: white;
}

.login button:hover {
	color: black;
	text-decoration-line: none;
}

.page-sidebar {
	margin-left: 0px;
}

.profile a:hover {
	color: #ccc !important;
}

.col-lg-6 {
	padding-top: 50px;
}

.sidelike {
	border: 1px solid #9e9e9e;
	border-radius: 10px;
}

.btn-primary {
	color: white;
	background-color: #a0ba83;
}

.bg-primary {
	background-color: white !important;
	border-bottom: 1px solid #9e9e9e;
}

.ml-auto {
	list-style: none;
	margin-left: 0px !important;
}

img {
	vertical-align: middle;
	border-style: none;
}

.container {
	/* width: 80%; */
	padding-right: 15px;
	padding-left: 15px;
	margin-right: auto;
	margin-left: auto;
}

.navbar-expand-md .navbar-collapse {
	display: -webkit-box !important;
	display: -webkit-flex !important;
	display: -ms-flexbox !important;
	display: flex !important;
	-webkit-flex-basis: auto;
	-ms-flex-preferred-size: auto;
	flex-basis: auto;
	justify-content: flex-end;
}

.acense {
	padding-bottom: 0px;
}

.navbar .navbar-brand img {
	width: 90px;
}

img {
	width: 80px;
}

.btn-primary {
	color: white;
	background-color: #a0ba83;
}

.mList a:hover {
	color: #a0ba83 !important;
}
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<%@ include file="./header.jsp"%>


	<div class="container">
		<div class="page-container">
			<div class="page-content">


				<div style="height: 400px; margin: 10px; border: 1px solid gray;">

					<form method="post" style="display:flex;" action="insertInsta.do"
						enctype="multipart/form-data">

						<div style="width:50%;height:100%;">
							<input type="text" id="id" placeholder="id" name="multiId" style="width:100%;"/> 
							<input type="password" id="pw" placeholder="pw" name="multiPw" style="width:100%;"/>
							<textarea id="content" name="multiContent" style="width:100%;"></textarea>
						</div>
						<div style="width:50%;height:100%;">
							<input type="file" id="file" name="uploadFile" style="width:100%;"/> 
							<img src="" id="preview" style="width:100%;">
							<button style="width:100%;">인스타</button>
						</div>

					</form>

				</div>










				<!--  
				<div class="card"
					style="margin: 20px; background-color: #d0d2cf78; border-radius: 20px; height: 300px;">
					<div class="card-header text-center">
						<div class="top" >
							<h5 class="card-title" style="padding: 10px; font-size: 20px; margin:0"><spring:message code="message.main.campingFind"/></h5>
						</div>
					</div>
					<div class="campingSearch"
						style="height: 100%; margin: 0 20px 20px 0; border-radius: 10px; display: flex; align-items: center;">
						<div style="width:35%; display:flex; justify-content: center; flex-direction: column;">
						<div style="display: flex; justify-content: center;">
						<select name="region" style="border-radius:15px; margin-right: 15px; border: 0px;">
							<option value="지역">지역</option>
							<option value="지역">지역</option>
							<option value="지역">지역</option>
							<option value="지역">지역</option>
						</select> <select name="city" style="border-radius:15px; border: 0px;">
							<option value="시/구">시/구</option>  
							<option value="시/구">시/구</option>
							<option value="시/구">시/구</option>
							<option value="시/구">시/구</option>
						</select></div>
						<div style="display:flex; justify-content: center;">
						<button style="background-color:white; width:200px; border-radius:15px; height:40px; margin-top:15px;"><spring:message code="message.main.campingFindBtn"/></button>
						</div></div>
						<div style="width:65%; height:100%;">
						<div style="background-color:white; height:100%; border-radius: 10px;">
						</div>
						</div>
					</div>
				</div>
				-->

				<div class="row">
					<div class="col-lg-6">
						<div class="card text-center mb-5">
							<div class="card-header p-0">
								<div class="blog-media">
									<div class="text-left" style="font-weight: bold;">
										<spring:message code="message.main.recentBList" />
									</div>
									<hr>
								</div>
							</div>
							<!-- 글 예시 -->
							<div class="card-body px-0"
								style="display: flex; padding-top: 0px !important; font-size: 15px;">
								<div class="mList"
									style="margin-right: 20px; font-weight: bold;">커뮤니티</div>
								<div class="mList">
									<a href="commuDetail.jsp" style="color: black;">여자친구 몰래 술집
										가는 법</a>
								</div>
							</div>
							<div class="card-body px-0"
								style="display: flex; padding-top: 0px !important; font-size: 15px;">
								<div class="mList"
									style="margin-right: 20px; font-weight: bold;">꿀팁공유</div>
								<div class="mList">
									<a href="commuDetail.jsp" style="color: black;">캠핑 용품 구매시
										꿀팁!</a>
								</div>
							</div>

						</div>
					</div>
					<div class="col-lg-6">
						<div class="card text-center mb-5">
							<div class="card-header p-0">
								<div class="blog-media">
									<div class="text-left" style="font-weight: bold;">
										<spring:message code="message.main.likeList" />
									</div>
									<hr>
								</div>
							</div>
							<!-- 글 예시 -->
							<div class="card-body px-0"
								style="display: flex; padding-top: 0px !important; font-size: 15px;">
								<div class="mList"
									style="margin-right: 20px; font-weight: bold;">꿀팁공유</div>
								<div class="mList">
									<a href="commuDetail.jsp" style="color: black;">캠핑 장소 추천해요~</a>
								</div>
							</div>
							<div class="card-body px-0"
								style="display: flex; padding-top: 0px !important; font-size: 15px;">
								<div class="mList"
									style="margin-right: 20px; font-weight: bold;">커뮤니티</div>
								<div class="mList">
									<a href="commuDetail.jsp" style="color: black;">아니 님들아
										프로젝트해야져 허어어어엉</a>
								</div>
							</div>

						</div>
					</div>
				</div>


			</div>

			<!--  Sidebar 커스텀태그 활용 -->
			<kwon:sideInfo />
		</div>
	</div>


	<%@ include file="./footer.jsp"%>
		<script>
		const $fileInput = document.getElementById("file");
		// 사진
		const $previewImg = document.getElementById("preview");
		// 프리뷰
		const reader = new FileReader();
		// 파일리더

		reader.onload = function(e) {
			// 리더가 로드되면
			$previewImg.src = e.target.result;
			// 결과를 미리보기 이미지에 박아 
		}

		$fileInput.addEventListener("change", function() {
			// 파일이 들어오면
			var file = $('#file').val();
			try {
				const files = this.files;
				// 입력받은 파일
				if (files && files[0]) { // 파일을 여러개 선택해서 보낼 수 있어서 배열로 들어옴
					// 배열의 첫번째 값이 들어있는지 확인
					const fileName = this.value.split(".");
					// 파일형태를 알아보기 위해 . 을 기준으로 스플릿해서 자름 xxx.jsp > xxx jsp
					const ex = fileName.at(-1); // 배열의 제일 마지막것 jsp
					if (ex == "jpg" || ex == "jpeg" || ex == "png"
							|| ex == "gif") {
						// 형태가 사진형태라면
						reader.readAsDataURL(files[0]);
						// 리더 로드 (파일의 첫번째 값)
					} else {
						alert("사진만 첨부해주세요.");
						$previewImg.src = "";
					}
				} else { // 잘 안들어왔으면
					$previewImg.src = ""; //미리보기는 없어용!
				}
			} catch (error) {
			}
		})
	</script>
</body>
</html>