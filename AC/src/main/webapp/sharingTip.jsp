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

.blog-media {
	padding-top: 50px;
}

.text-left a:hover {
	color: #ccc !important;
}

.left {
	text-align: left;
	padding: 20px 0 0 40px;
}

.row {
    /* display: -webkit-box; */
    /* display: -webkit-flex; */
    display: -ms-flexbox;
    /* display: flex; */
    -webkit-flex-wrap: wrap;
    -ms-flex-wrap: wrap;
    flex-wrap: wrap;
    margin-right: -15px;
    margin-left: -15px;
}
#title{
border:1px solid black;
}
#content{
border:1px solid black;
}
#else{
border:1px solid black;
}

</style>

</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">

	<%@ include file="./header.jsp"%>


	<div class="container">
		<div class="page-container">
			<div class="page-content">


				<div class="row" style="display: flow-root;">
					<div class="card text-center mb-5">
						<div class="card-header p-0" style="    margin-bottom: 20px;">
							<div class="blog-media">
								<div class="text-left">
									<h2>커뮤니티</h2>
									<p style="">다양한 정보를 공유하고 캠핑의 질을 상승시켜보세요.</p>
								</div>
								<div class="  loginHere">
									<a
										class="flex h-9 items-center space-x-1 rounded-md bg-blue-500 py-2 px-3 text-white shadow-sm hover:bg-blue-400 sm:pr-4"
										href="/community/new"  style="    width: 14%;
    background-color: #a0ba83;"><svg
											xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24"
											fill="currentColor" aria-hidden="true" class="h-4 w-4">
											<path
												d="M21.731 2.269a2.625 2.625 0 00-3.712 0l-1.157 1.157 3.712 3.712 1.157-1.157a2.625 2.625 0 000-3.712zM19.513 8.199l-3.712-3.712-12.15 12.15a5.25 5.25 0 00-1.32 2.214l-.8 2.685a.75.75 0 00.933.933l2.685-.8a5.25 5.25 0 002.214-1.32L19.513 8.2z"></path></svg><span
										class="inline text-sm font-medium hover:no-underline sm:leading-5">작성하기</span></a>
								</div>

							</div>
						</div>
								<hr>
						
						<table>
                           <thead>
                              <tr style="    border-bottom: 2rem solid;
    border-color: transparent;">
                                 <th  style="padding-left: 5px;">번호</th>
                                 <th  style="width:60%;">제목</th>
                                 <th style="width:auto;">등급/닉네임</th>
                                 <th  style="width:6%" >조회수</th>
                                 <th >작성일</th>
                              </tr>
                           </thead>
                           <tbody>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >1</td>
                                 <td  ><a href="#" style="color:black;">이슬이를 처단하라  </a><span style="    font-size: small; color:red;">  [310]	 </span></td>
                                <td  ><img src="./assets/imgs/level2.png" style="display:inline; width:25px; padding-bottom:3px;"/> <span>BJ 띵킹</span></td>
                                 <td >10</td>
                                 <td >2023.02.25.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td scope="col" >2</td>
                                 <td >커뮤니티</td>
                                 <td  >권지민</td>
                                 <td >김한빛</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >3</td>
                                 <td >커뮤니티</td>
                                 <td  >권지민</td>
                                 <td >이민호</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >4</td>
                                 <td  >커뮤니티</td>
                                 <td >권지민</td>
                                 <td >이승률</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >5</td>
                                 <td >커뮤니티</td>
                                 <td  >권지민</td>
                                 <td >김형진</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >6</td>
                                 <td  >커뮤니티</td>
                                 <td >권지민</td>
                                 <td >김이슬</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           <tr style="    border-bottom: 5px solid;
    border-color: transparent;">
                            <td  >7</td>
                                 <td  >커뮤니티</td>
                                 <td >권지민</td>
                                 <td>손민성</td>
                                 <td >2020.12.21.</td>
                           </tr>
                           
                           </tbody>
						
						</table>
						<!--게시글 끝.  -->









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