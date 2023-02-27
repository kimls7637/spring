<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="kwon"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
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
<title><spring:message code="message.navigation.header"/></title>
<!-- font icons -->
<link rel="stylesheet"
	href="assets/vendors/themify-icons/css/themify-icons.css">
<link rel="icon" href="./assets/imgs/favicon.png" />
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<link rel="stylesheet" href="assets/css/search.css">
<style type="text/css">
.text-left {
	text-align: left;
}

.top {
	padding-top: 34px;
}

.pn {
	padding-top: 50px;
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
	padding: 20px 0px 5px 0px;
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
	padding-bottom: 20px
}

.btn-primary {
	color: white;
	background-color: #a0ba83;
}



</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<%@ include file="./header.jsp"%>


	<div class="container">
		<div class="page-container">
			<div class="page-content" >
				<div class="card">
					<div class="card-header text-center">
						<div class="top">
							<h5 class="card-title"><spring:message code="message.navigation.title"/></h5>
						</div>
					</div>
					<div class="campingSearch">
						<!-- <div class="blog-media">
							<img src="assets/imgs/blog-6.jpg" alt="" class="w-100"> <a
								href="#" class="badge badge-primary">#Salupt</a>
						</div> -->
						<select name="region">
							<option value="지역"><spring:message code="message.navigation.region"/></option>
							<option value="지역"><spring:message code="message.navigation.region"/></option>
							<option value="지역"><spring:message code="message.navigation.region"/></option>
							<option value="지역"><spring:message code="message.navigation.region"/></option>
						</select> <select name="city">
							<option value="시/구"><spring:message code="message.navigation.city"/></option>
							<option value="시/구"><spring:message code="message.navigation.city"/></option>
							<option value="시/구"><spring:message code="message.navigation.city"/></option>
							<option value="시/구"><spring:message code="message.navigation.city"/></option>
						</select>
					</div>
				</div>

				<div class="row">
					<div class="col-lg-6">
						<div class="card text-center mb-5">
							<div class="card-header p-0">
								<div class="blog-media">
									<div class="text-left"><spring:message code="message.navigation.list"/></div>
									<hr>
									<img src="assets/imgs/blog-2.jpg" alt="" class="w-100">

								</div>
							</div>
							<div class="card-body px-0">
								<h5 class="card-title mb-2">Voluptates Corporis Placeat</h5>
								<small class="small text-muted">January 20 2019 <span
									class="px-2">-</span> <a href="#" class="text-muted">34
										Comments</a>
								</small>
								<p class="my-2">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Eos saepe dolores et nostrum porro odit
									reprehenderit animi, est ratione fugit aspernatur ipsum.
									Nostrum placeat hic saepe voluptatum dicta ipsum beatae.</p>
							</div>

							<div class="card-footer p-0 text-center">
								<a href="single-post.html" class="btn btn-outline-dark btn-sm">READ
									MORE</a>
							</div>
						</div>
					</div>
					<div class="col-lg-6">
						<div class="card text-center mb-5">
							<div class="card-header p-0">
								<div class="blog-media">
									<div class="text-left"><spring:message code="message.navigation.likeList"/></div>
									<hr>
									<img src="assets/imgs/blog-3.jpg" alt="" class="w-100">

								</div>
							</div>
							<div class="card-body px-0">
								<h5 class="card-title mb-2">Dolorum Dolores Itaque</h5>
								<small class="small text-muted">January 19 2019 <span
									class="px-2">-</span> <a href="#" class="text-muted">64
										Comments</a>
								</small>
								<p class="my-2">Lorem ipsum dolor sit amet, consectetur
									adipisicing elit. Eos saepe dolores et nostrum porro odit
									reprehenderit animi, est ratione fugit aspernatur ipsum.
									Nostrum placeat hic saepe voluptatum dicta ipsum beatae.</p>
							</div>

							<div class="card-footer p-0 text-center">
								<a href="single-post.html" class="btn btn-outline-dark btn-sm">READ
									MORE</a>
							</div>
						</div>
					</div>
				</div>


			</div>

			<!--  Sidebar 커스텀태그 활용 -->
			<kwon:sideInfo member="" />
		</div>
	</div>


	<%@ include file="./footer.jsp"%>



</body>
</html>
