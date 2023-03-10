<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>ACENSE : 관리자 게시글 관리</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="admin.assets/vendors/mdi/css/materialdesignicons.min.css">
<link rel="stylesheet" href="admin.assets/vendors/css/vendor.bundle.base.css">
<!-- endinject -->
<link rel="stylesheet"
	href="admin.assets/vendors/jvectormap/jquery-jvectormap.css">
<link rel="stylesheet"
	href="admin.assets/vendors/flag-icon-css/css/flag-icon.min.css">
<link rel="stylesheet"
	href="admin.assets/vendors/owl-carousel-2/owl.carousel.min.css">
<link rel="stylesheet"
	href="admin.assets/vendors/owl-carousel-2/owl.theme.default.min.css">
<!-- Plugin css for this page -->
<!-- End plugin css for this page -->
<!-- inject:css -->
<!-- endinject -->
<!-- Layout styles -->
<link rel="stylesheet" href="admin.assets/css/style.css">
<!-- End layout styles -->
<link rel="shortcut icon" href="admin.assets/imgs/favicon.png" />
<style>
.text-color {
	color: white !important;
}

.text-color {
	color: white;
}

.btn-tomung {
	border: none;
	background-color: #ffffff00;
	color: white;
	font-size: smaller;
}

.btn-tomung:hover {
	color: darkgray;
}

a {
	color: white;
}

a:hover {
	color: darkgray;
}
</style>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:../../partials/_sidebar.html -->
		<nav class="sidebar sidebar-offcanvas" id="sidebar">
			<div
				class="sidebar-brand-wrapper d-none d-lg-flex align-items-center justify-content-center fixed-top">
				<a class="sidebar-brand brand-logo" href="admin.jsp"
					style="color: white; font-weight: 600; padding-left: 60px;     text-decoration: none;
					">A C
					E N S E</a> <a class="sidebar-brand brand-logo-mini" href="admin.jsp"
					style="color: white; font-weight: 600; padding-left: 27px;">A</a>
			</div>
			<ul class="nav">
				<li class="nav-item profile">
					<div class="profile-desc">
						<div class="profile-pic">
							<div class="count-indicator">
								<img class="img-xs rounded-circle "
									src="assets/imgs/favicon.png" alt="로고"> <span
									class="count bg-success"></span>
							</div>
							<div class="profile-name">
								<h5 class="mb-0 font-weight-normal">Sixsense</h5>
								<span>admin</span>
							</div>
						</div>
						
					</div>
				</li>
				<li class="nav-item nav-category"><span class="nav-link"></span>
				</li>
				<li class="nav-item menu-items"><a class="nav-link"
					href="boardCtrl.jsp"> <span class="menu-icon"> <i
							class="mdi mdi-speedometer"></i>
					</span> <span class="menu-title">게시글관리</span>
				</a></li>
				<li class="nav-item menu-items"><a class="nav-link"
					href="memberCtrl.jsp"> <span class="menu-icon"> <i
							class="mdi mdi-table-large"></i>
					</span> <span class="menu-title">회원관리</span>
				</a></li>

			</ul>
		</nav>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:../../partials/_navbar.html -->
			<nav class="navbar p-0 fixed-top d-flex flex-row">
				<div
					class="navbar-brand-wrapper d-flex d-lg-none align-items-center justify-content-center">
					<a class="navbar-brand brand-logo-mini" href="admin.jsp"><img style="width: 35px;
  height: 35px;"
						src="assets/imgs/favicon.png" alt="logo" /></a>
				</div>
				<div
					class="navbar-menu-wrapper flex-grow d-flex align-items-stretch">
					<button class="navbar-toggler navbar-toggler align-self-center"
						type="button" data-toggle="minimize">
						<span class="mdi mdi-menu"></span>
					</button>
					<ul class="navbar-nav w-100">
					</ul>
					<ul class="navbar-nav navbar-nav-right">


						<li class="nav-item dropdown border-left"><a
							class="nav-link count-indicator dropdown-toggle"
							id="notificationDropdown" href="#" data-toggle="dropdown"> <i
								class="mdi mdi-bell"></i> <span class="count bg-danger"></span>
						</a>
							<div
								class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
								aria-labelledby="notificationDropdown">
								<h6 class="p-3 mb-0">Notifications</h6>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item preview-item">
									<div class="preview-thumbnail">
										<div class="preview-icon bg-dark rounded-circle">
											<i class="mdi mdi-calendar text-success"></i>
										</div>
									</div>
									<div class="preview-item-content">
										<p class="preview-subject mb-1">Event today</p>
										<p class="text-muted ellipsis mb-0">Just a reminder that
											you have an event today</p>
									</div>
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item preview-item">
									<div class="preview-thumbnail">
										<div class="preview-icon bg-dark rounded-circle">
											<i class="mdi mdi-settings text-danger"></i>
										</div>
									</div>
									<div class="preview-item-content">
										<p class="preview-subject mb-1">Settings</p>
										<p class="text-muted ellipsis mb-0">Update dashboard</p>
									</div>
								</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item preview-item">
									<div class="preview-thumbnail">
										<div class="preview-icon bg-dark rounded-circle">
											<i class="mdi mdi-link-variant text-warning"></i>
										</div>
									</div>
									<div class="preview-item-content">
										<p class="preview-subject mb-1">Launch Admin</p>
										<p class="text-muted ellipsis mb-0">New admin wow!</p>
									</div>
								</a>
								<div class="dropdown-divider"></div>
								<p class="p-3 mb-0 text-center">See all notifications</p>
							</div></li>
						<li class="nav-item dropdown"><a class="nav-link"
							id="profileDropdown" href="#" data-toggle="dropdown">
								<div class="navbar-profile">
									<img class="img-xs rounded-circle"
										src="assets/imgs/favicon.png" alt="로고">
									<p class="mb-0 d-none d-sm-block navbar-profile-name">Sixsense</p>
									<i class="mdi mdi-menu-down d-none d-sm-block"></i>
								</div>
						</a>
							<div
								class="dropdown-menu dropdown-menu-right navbar-dropdown preview-list"
								aria-labelledby="profileDropdown">
								<h6 class="p-3 mb-0">Profile</h6>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item preview-item">
									<div class="preview-thumbnail">
										<div class="preview-icon bg-dark rounded-circle">
											<i class="mdi mdi-logout text-danger"></i>
										</div>
									</div>
									<div class="preview-item-content">
										<p class="preview-subject mb-1">Log out</p>
									</div>
								</a>
								<div class="dropdown-divider"></div>
								<p class="p-3 mb-0 text-center">Advanced settings</p>
							</div></li>
					</ul>
					<button
						class="navbar-toggler navbar-toggler-right d-lg-none align-self-center"
						type="button" data-toggle="offcanvas">
						<span class="mdi mdi-format-line-spacing"></span>
					</button>
				</div>
			</nav>
			<!-- partial -->
			<div class="main-panel">
				<div class="content-wrapper">
					<div class="page-header">
						<h3 class="page-title"></h3>
						<nav aria-label="breadcrumb">
							<ol class="breadcrumb">
								<li class="breadcrumb-item">board</li>
								<li class="breadcrumb-item active text-color"
									aria-current="page">board tables</li>
							</ol>
						</nav>
					</div>


					<div class="row">
						<!--왼쪽 시작 -->
						<div class="col-lg-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"
										style="display: inline-block; margin-bottom: 30px;">댓글 목록</h4>
									<div style="float: right; display: inline-block;">
									<a href="recent.do"><button id="recent">최신순</button></a>
										/
										<a href="report.do"><button id="report">신고순</button></a>
									</div>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th class="text-color">날짜</th>
													<th class="text-color">내용</th>
													<th class="text-color">작성자</th>
													<th class="text-color">신고수</th>
												</tr>
											</thead>
											<tbody>
											<c:forEach var="v" items="${boardCtrlReport}">
												<tr>
													<td class="text-color">${v.bDate }</td>
													<td class="text-color"><a href="detailBoard?bnum=${v.bNum}">${v.bContent }</a></td>
													<td class="text-color">${v.bNickname }</td>
													<td class="text-color"><div class="progress">
															<div class="progress-bar bg-danger" role="progressbar"
																style="width: ${v.reportCnt}%" aria-valuenow="50" aria-valuemin="0"
																aria-valuemax="50"></div>
														</div></td>
													<td class="text-color">${v.reportCnt}</td>
												</tr>
												
												</c:forEach>
												
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!-- 왼쪽 끝 -->

						<!-- 오른 -->
						<div class="col-lg-6 grid-margin stretch-card">
							<div class="card">
								<div class="card-body">
									<h4 class="card-title"
										style="display: inline-block; margin-bottom: 30px;">게시글
										목록</h4>
									<div style="float: right; display: inline-block;">
										<a href="recent.do"><button id="recent">최신순</button></a>
										/
										<a href="report.do"><button id="report">신고순</button></a>
									</div>
									<div class="table-responsive">
										<table class="table">
											<thead>
												<tr>
													<th class="text-color">날짜</th>
													<th class="text-color">제목</th>
													<th class="text-color">작성자</th>
													<th class="text-color">신고수</th>
												</tr>
											</thead>
											<tbody>
												
													<c:forEach var="v" items="${boardCtrlBoard}">
												<tr>
													<td class="text-color">${v.bDate }</td>
													<td class="text-color"><a href="detailBoard?bnum=${v.bNum}">${v.bTitle }</a></td>
													<td class="text-color">${v.bNickname }</td>
													<td class="text-color"><div class="progress">
															<div class="progress-bar bg-danger" role="progressbar"
																style="width: ${v.reportCnt}%" aria-valuenow="50" aria-valuemin="0"
																aria-valuemax="50"></div>
														</div></td>
													<td class="text-color">${v.reportCnt}</td>
												</tr>
												
												</c:forEach>
												
												
											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
						<!-- 오른쪽 끝 -->
					</div>
				</div>
				<!-- content-wrapper ends -->
				<!-- partial:../../partials/_footer.html -->
				<!-- <footer class="footer">
            <div class="d-sm-flex justify-content-center justify-content-sm-between">
              <span class="text-muted d-block text-center text-sm-left d-sm-inline-block">Copyright © bootstrapdash.com 2020</span>
              <span class="float-none float-sm-right d-block mt-1 mt-sm-0 text-center"> Free <a href="https://www.bootstrapdash.com/bootstrap-admin-template/" target="_blank">Bootstrap admin templates</a> from Bootstrapdash.com</span>
            </div>
          </footer> -->
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<script src="assets/vendors/js/vendor.bundle.base.js"></script>
	<!-- endinject -->
	<!-- Plugin js for this page -->
	<script src="admin.assets/vendors/chart.js/Chart.min.js"></script>
	<script src="admin.assets/vendors/progressbar.js/progressbar.min.js"></script>
	<script src="admin.assets/vendors/jvectormap/jquery-jvectormap.min.js"></script>
	<script
		src="admin.assets/vendors/jvectormap/jquery-jvectormap-world-mill-en.js"></script>
	<script src="admin.assets/vendors/owl-carousel-2/owl.carousel.min.js"></script>
	<!-- End plugin js for this page -->
	<!-- inject:js -->
	<script src="admin.assets/js/off-canvas.js"></script>
	<script src="admin.assets/js/hoverable-collapse.js"></script>
	<script src="admin.assets/js/misc.js"></script>
	<script src="admin.assets/js/settings.js"></script>
	<script src="admin.assets/js/todolist.js"></script>
	<!-- endinject -->
	<!-- Custom js for this page -->
	<script src="admin.assets/js/dashboard.js"></script>
	<!-- End custom js for this page -->
</body>
</html>