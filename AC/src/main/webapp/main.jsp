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
<link rel="stylesheet" href="assets/css/seach.css">
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
.btn-primary {
    color: white;
    background-color: #a0ba83;
   
}
 .lan select{
 margin-left:10px;
     border: 1px solid #dee2e6;
    border-radius: 43px;
    font-size: 14px;
 }
</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<%@ include file="./header.jsp"%>


	<div class="container">
		<div class="page-container">
			<div class="page-content">

				<div class="card"
					style="margin: 20px; background-color: #d0d2cf78; border-radius: 20px; height: 300px;">
					<div class="card-header text-center">
						<div class="top">
							<h5 class="card-title"
								style="padding: 10px; font-size: 20px; margin: 0">
								<spring:message code="message.main.campingFind" />
							</h5>
						</div>
					</div>
					<div class="campingSearch"
						style="height: 100%; margin: 0 20px 20px 0; border-radius: 10px; display: flex; align-items: center;">
						<!-- <div class="blog-media">
							<img src="assets/imgs/blog-6.jpg" alt="" class="w-100"> <a
								href="#" class="badge badge-primary">#Salupt</a>
						</div> -->
						<div
							style="width: 35%; display: flex; justify-content: center; flex-direction: column;">
							<div style="display: flex; justify-content: center;">
								<select name="region"
									style="border-radius: 15px; margin-right: 15px; border: 0px;">
									<option value="지역">지역</option>
									<option value="지역">지역</option>
									<option value="지역">지역</option>
									<option value="지역">지역</option>
								</select> <select name="city" style="border-radius: 15px; border: 0px;">
									<option value="시/구">시/구</option>
									<option value="시/구">시/구</option>
									<option value="시/구">시/구</option>
									<option value="시/구">시/구</option>
								</select>
							</div>
							<div style="display: flex; justify-content: center;">
								<button
									style="background-color: white; width: 200px; border-radius: 15px; height: 40px; margin-top: 15px;">
									<spring:message code="message.main.campingFindBtn" />
								</button>
							</div>
						</div>
						<div style="width: 65%; height: 100%;">
							<div
								style="background-color: white; height: 100%; border-radius: 10px;">
								결과아아아아</div>
						</div>
					</div>
				</div>
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

							<!-- 메인 최신 글목록에서 제목누르면 해당게시글상세로 이동 -->
							<ul>
								<c:forEach var="v" items="${datas}">
									<li>${v.bCate}|<a href="commuDetail.do?bNum=${v.bNum}">${v.bTitle}</a></li>
								</c:forEach>
							</ul>

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
							<!-- 메인 좋아요순 글목록에서 제목누르면 해당게시글상세로 이동 -->
							<ul>
								<c:forEach var="v" items="${datas}">
									<li>${v.bCate}|<a href="commuDetail.do?bNum=${v.bNum}">${v.bTitle}</a></li>
								</c:forEach>
							</ul>

						</div>
					</div>
				</div>


			</div>

			<!--  Sidebar 커스텀태그 활용 -->
			<kwon:sideInfo />
		</div>
	</div>


	<%@ include file="./footer.jsp"%>

	<!-- 채팅 스크립투 -->
	<script type="text/javascript">
		//채팅 서버 주소
		let url = "ws:///localhost:8088/app/chatserver";
		// 웹 소켓
		let ws;

		// 연결하기
		$(document).ready(function() {
			$('#btnConnect').click(function() {
				console.log('[로그1] Chat.jsp');
				// 유저명 확인
				if ($('#user').val().trim() != '') {
					console.log('[로그2] Chat.jsp');
					// 연결
					ws = new WebSocket(url);

					// 소켓 이벤트 매핑
					ws.onopen = function(evt) {
						console.log('서버 연결 성공');
						print($('#user').val(), '님이 입장했습니다.');

						// 현재 사용자가 입장했다고 서버에게 통지(유저명 전달)
						// -> 1#유저명
						ws.send('1#' + $('#user').val() + '#');

						$('#user').attr('readonly', true);
						$('#btnConnect').attr('disabled', true);
						$('#btnDisconnect').attr('disabled', false);
						$('#msg').attr('disabled', false);
						$('#msg').focus();
					};

					ws.onmessage = function(evt) {
						// print('', evt.data);
						let index = evt.data.indexOf("#", 2);
						let no = evt.data.substring(0, 1);
						let user = evt.data.substring(2, index);
						let txt = evt.data.substring(index + 1);

						if (no == '1') {
							print2(user);
						} else if (no == '2') {
							let member = evt.data.split(':', 2);
							let user = member[0].split('#', 2);
							let txt = evt.data.split(':', 2);
							print(user[1], txt[1]);

						} else if (no == '3') {
							print3(user);
						}
						$('#list').scrollTop($('#list').prop('scrollHeight'));
					};

					ws.onclose = function(evt) {
						console.log('소켓이 닫힙니다.');
					};

					ws.onerror = function(evt) {
						console.log(evt.data);
					};
				} else {
					alert('유저명을 입력하세요.');
					$('#user').focus();
				}
			})
		});

		// 메세지 전송 및 아이디
		function print(user, txt) {
			let temp = '';
			temp += '<div style="font-size:3px; margin-bottom:3px;">';
			temp += '[' + user + '] ';
			temp += txt;
			temp += ' <span style="color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';

			$('#list').append(temp);
		}

		// 다른 client 접속
		function print2(user) {
			let temp = '';
			temp += '<div style="font-size:3px; margin-bottom:3px;">';
			temp += "'" + user + "' 님이 접속했습니다.";
			temp += ' <span style="color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';

			$('#list').append(temp);
		}

		// client 접속 종료
		function print3(user) {
			let temp = '';
			temp += '<div style="font-size:3px; margin-bottom:3px;">';
			temp += "'" + user + "' 님이 종료했습니다.";
			temp += ' <span style="color:#777;">'
					+ new Date().toLocaleTimeString() + '</span>';
			temp += '</div>';

			$('#list').append(temp);
		}

		$(document).ready(function() {
			$('#user').keydown(function() {
				if (event.keyCode == 13) {
					$('#btnConnect').click();
				}
			})
		});

		//메세지 입력 자기 채팅창
		$(document).ready(function() {
			$('#msg').keydown(function() {
				if (event.keyCode == 13) {
					if (ws.readyState === WebSocket.OPEN) {
						ws.send('2#' + $('#user').val() + '#' + $(this).val()); //서버에게
						print($('#user').val(), $(this).val()); //본인 대화창에
					}
					/*
					else {
					   // handle error - WebSocket is not open
					
					//서버에게 메시지 전달
					//2#유저명#메시지
					ws.send('2#' + $('#user').val() + '#' + $(this).val()); //서버에게
					print($('#user').val(), $(this).val()); //본인 대화창에
					 */
					$('#msg').val('');
					$('#msg').focus();

				}
			})
		});

		$(document).ready(function() {
			$('#btnDisconnect').click(function() {
				ws.send('3#' + $('#user').val() + '#');
				ws.close();

				$('#user').attr('readonly', false);
				$('#user').val('');

				$('#btnConnect').attr('disabled', false);
				$('#btnDisconnect').attr('disabled', true);

				$('#msg').val('');
				$('#msg').attr('disabled', true);
			})
		});
	</script>
	<!— core  —>
	<script src="assets/vendors/jquery/jquery-3.4.1.js"></script>
	<script src="assets/vendors/bootstrap/bootstrap.bundle.js"></script>

	<!— JoeBLog js —>
	<script src="assets/js/joeblog.js"></script>
	<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
	<script>
      function test() {
        alert("Enter Key 입력 감지 \n함수 실행.");
      }
      
      /*  */
     
     $("select[name=language]").change(function(){
    	 console.log($(this).val());
    	 var lan=$(this).val();
    	 location.href='main.do?lang='+lan;
     })
     
    
    </script>



</body>
</html>