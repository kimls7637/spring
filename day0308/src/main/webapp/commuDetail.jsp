<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kwon"%>
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
<title>ACENSE : 게시글 상세보기</title>
<!-- font icons -->
<link rel="stylesheet"
	href="assets/vendors/themify-icons/css/themify-icons.css">
<link rel="icon" href="./assets/imgs/favicon.png" />
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<script src="https://cdn.ckeditor.com/4.19.0/full/ckeditor.js"></script>
<style type="text/css">
.text-left {
	text-align: left;
}

.top {
	padding-top: 34px;
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
	margin: 10px 0;
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
	padding: 0 40px 0 40px;
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

.campingSearch {
	border: 1px solid #9e9e9e;
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

.blog-media {
	padding-top: 50px;
}

.text-left a:hover {
	color: #ccc !important;
}

.left {
	text-align: left;
	/* padding: 20px 0 0 40px; */
}

.align-items-center {
	-webkit-box-align: center !important;
	-webkit-align-items: center !important;
	-ms-flex-align: center !important;
	/* align-items: center !important; */
}

.justify-between {
	justify-content: space-between;
}

.flex {
	display: flex;
}

.com {
	padding: 20px;
	border: 1px solid #9e9e9e;
	border-radius: 10px;
	margin: 5px 0 30px 0;
	font-size: 14px;
}

.comcom {
	margin: 30px 45px 30px 45px;
}

.comcom2 {
	margin: 5px 45px 30px 45px;
}

.com1 input {
	border: 0px solid black;
	font-size: 14px;
}

.com1 input:focus {
	border: 1px solid black;
}

button:focus {
	outline: none !important;
}

button:hover {
	color: #a0ba83;
}

.rebt {
	padding: 7px 13px;
	border: 2px solid #a0ba83;
	border-radius: 10px;
	/* background-color: #a0ba83;  */
	color: black;
	font-size: 13px;
}

.re:hover {
	color: #a0ba83;
}

#re {
	display: flex;
	justify-content: flex-end;
}

.updecomcom {
	margin-right: 45px;
}

.upde a:hover {
	color: #a0ba83 !important;
}
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<%@ include file="./header.jsp"%>


	<div class="container">
		<div class="page-container">
			<div class="page-content">


				<div class="row">
					<!-- <div class="col-lg-6"> -->
					<div class="card text-center mb-5" style="width: 100%;">
						<div class="card-header p-0">
							<div class="blog-media">
								<div class="text-left">
									<!-- 커뮤니티글일때는 커뮤니티, 꿀팁공유글일때는 꿀팁공유나오게 처리  -->
									<a href="commuList.jsp" style="color: #a0ba83;"> 커뮤니티</a> / 글
									상세보기
								</div>
								<hr>
								<!-- <img src="assets/imgs/blog-2.jpg" alt="" class="w-100"> -->

							</div>
						</div>
						<!-- 수정 삭제  -->
						<div class="upde"
							style="display: flex; justify-content: flex-end; font-size: 14px;">
							<a href="insertBoard.jsp" class="up"
								style="margin: 0 5px 0 5px; color: black;">수정</a>/ <a href=""
								class="de" style="margin: 0 5px 0 5px; color: black;">삭제</a>
						</div>


						<div class="com"
							style="border: 1px solid #9e9e9e; border-radius: 10px;">
							<!-- 게시글 상세 띄어주기 -->
							<!-- 등급 닉네임
								 작성날짜 
								 제목, 글 내용  -->
							<div class="left">
								<div class="card-title mb-2"
									style="display: flex; justify-content: space-between; align-items: center;">
									<div class="nick" style="display: flex; align-items: center;">
										<!-- level1 씨앗 -->
										<!-- level2 새싹 -->
										<!-- level3 가지 -->
										<!-- level4 열매 -->
										<!-- level5 관리자 : jstl로 이미지 바꾸기-->

										<div style="width: 30%; margin: 0 15px 0 0;">
											<img src="./assets/imgs/level1.png">
										</div>
										<div>닉네임</div>

									</div>
									<div>2023.01.21</div>
								</div>
							</div>
							<!-- 글 제목 -->
							<!-- 글 내용 -->
							<textarea id="txt"
								style="width: 100%; height: scrollheight; border: transparent; resize: none;"
								disabled>여기에이엘식추가해주세요</textarea>

							<!-- 태그란 -->
							<div class="tl" style="display: flex;">
								<div class="t" style="margin: 10px 10px 10px 0;">#카라반</div>
								<div class="t" style="margin: 10px 10px 10px 0;">#캠핑 용품</div>
								<div class="t" style="margin: 10px 10px 10px 0;">#캠핑장 추천</div>
							</div>

							<!-- 좌측 하단에 좋아요 / 신고 -->
							<div class="llrr" style="display: flex;">
								<div class="ll">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">좋아요</button>
								</div>
								<div class="rr">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">신고</button>
								</div>
								<div id="re">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">댓글</button>
								</div>
							</div>

						</div>



						<!-- 댓글 작성창 -->
						<div class="com">
							<form action="" class="flex justify-between align-items-center">
								<div class="com1">
									<input type="text" placeholder="댓글을 남겨주세요.">
								</div>
								<div class="com2">
									<button class="rebt" type="submit">댓글 등록</button>
								</div>
							</form>
						</div>

						<!-- 댓글 등록 누르면 업로드된 댓글창 (작성자 닉네임 / 작성날짜 / 댓글내용)
					 + 대댓글 작성 버튼 (버튼누르면 대댓글 작성창 뜸) -->
						<!-- 수정 삭제  -->
						<div class="upde"
							style="display: flex; justify-content: flex-end; font-size: 14px;">
							<a href="" class="up" style="margin: 0 5px 0 5px; color: black;">수정</a>/
							<a href="" class="de" style="margin: 0 5px 0 5px; color: black;">삭제</a>
						</div>

						<div class="com">
							<div>댓글 작성자 작성날짜</div>
							<br>
							<div>댓글 내용</div>

							<!-- 좌측 하단에 좋아요 / 신고 -->
							<div class="llrr" style="display: flex;">
								<div class="ll">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">좋아요</button>
								</div>
								<div class="rr">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">신고</button>
								</div>
								<div id="re">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">댓글</button>
								</div>
							</div>
						</div>

						<!-- 대댓글 작성창 -->
						<div class="com comcom">
							<form action="" class="flex justify-between align-items-center">
								<div class="com1">
									<input type="text" placeholder="댓글을 남겨주세요.">
								</div>
								<div class="com2">
									<button class="rebt" type="submit">댓글 등록</button>
								</div>
							</form>
						</div>

						<!-- 업로된 대댓글창 -->
						<!-- 수정 삭제  -->
						<div class="upde updecomcom"
							style="display: flex; justify-content: flex-end; font-size: 14px;">
							<a href="" class="up" style="margin: 0 5px 0 5px; color: black;">수정</a>/
							<a href="" class="de" style="margin: 0 5px 0 5px; color: black;">삭제</a>
						</div>

						<div class="com comcom2">
							<div>대댓글 작성자 작성날짜</div>
							<br>
							<div>대댓글 내용</div>
							<!-- 좌측 하단에 좋아요 / 신고 -->
							<div class="llrr" style="display: flex;">
								<div class="ll">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">좋아요</button>
								</div>
								<div class="rr">
									<button class="rebt" style="margin: 10px 10px 0px 0px;">신고</button>
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

<!-- 
	<script>
		const txt = document.getElementById("txt");
		txt.style.height = (txt.scrollHeight) + 'px';
	</script>
-->
	 
		<script>
            CKEDITOR.replace("txt", {
            });

            window.onload = function(){
            const ckeTop = document.getElementById("cke_1_top");
            ckeTop.style.display = "none";
            const ckeBot = document.getElementById("cke_1_bottom");
            ckeBot.style.display = "none";
            const ckeCon = document.getElementById("cke_1_contents");
            
           /* 
            const iframe = document.getElementsByTagName('iframe')[0];
            const iframeDoc = iframe.contentDocument || iframe.contentWindow.document;
            console.log(iframeDoc.body.getBoundingClientRect().height);
           	console.log(iframeDoc.body.scrollHeight);
           	console.log(iframeDoc.body.offsetHeight);
           	console.log(iframeDoc.body.clientHeight);
           	console.log(iframeDoc.clientHeight);
            */
           	ckeCon.style.height = 300+"px";
            }
            
            
        </script>

</body>
</html>
