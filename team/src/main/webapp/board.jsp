<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>
<!--
	Editorial by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>상세 페이지</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Main -->
		<div id="main">
			<div class="inner">

				<!-- Header -->
				<header id="header">
					<a href="logout.do" class="logo"><strong>로그아웃</strong></a>
					<ul class="icons">
						<li><a href="#" class="icon brands fa-twitter"><span
								class="label">Twitter</span></a></li>
						<li><a href="#" class="icon brands fa-facebook-f"><span
								class="label">Facebook</span></a></li>
						<li><a href="#" class="icon brands fa-snapchat-ghost"><span
								class="label">Snapchat</span></a></li>
						<li><a href="#" class="icon brands fa-instagram"><span
								class="label">Instagram</span></a></li>
						<li><a href="#" class="icon brands fa-medium-m"><span
								class="label">Medium</span></a></li>
					</ul>
				</header>

				<!-- Content -->
				<section>
					<header class="main">
						<h1>상세 페이지</h1>
					</header>

					<span class="image main"><img src="images/pic.png"
						alt="귀여운 티모 이미지" /></span> ${data.bid} <br> ${data.title} <br>
					${data.writer} <br> ${data.content} <br>

					<c:if test="${member.mid == data.writer}">
						<input type="button" value="수정" class="button big"
							onclick="location.href='updateBoard.do?bid=${data.bid}'" />
						<input type="button" value="삭제" class="button big" id="del" />
					</c:if>
					<a href="main.do">메인으로 돌아가기</a>

					<script src="https://code.jquery.com/jquery-3.6.3.min.js"></script>
					<script type="text/javascript">
						$('#del').on('click', function(e) {
							e.preventDefault();
							console.log('${board.bId}');
							if (confirm('정말 삭제하시겠습니까?')) {
								alert('삭제되었습니다.');
								location.href = 'deleteBoard.do?bid=${data.bid}';
							} else {
								alert('취소되었습니다.');
							}
						});
					</script>

					<hr class="major" />

					<h2>Interdum sed dapibus</h2>
					<p>Donec eget ex magna. Interdum et malesuada fames ac ante
						ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
						dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas
						enim auctor sit amet. Pellentesque leo mauris, consectetur id
						ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia
						malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium
						pulvinar mauris. Curabitur sapien risus, commodo eget turpis at,
						elementum convallis elit. Pellentesque enim turpis, hendrerit.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos. Etiam
						tristique libero eu nibh porttitor fermentum. Nullam venenatis
						erat id vehicula viverra. Nunc ultrices eros ut ultricies
						condimentum. Mauris risus lacus, blandit sit amet venenatis non,
						bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
						euismod in lectus. Pellentesque habitant morbi tristique senectus
						et netus et malesuada fames ac turpis egestas. In non lorem sit
						amet elit placerat maximus. Pellentesque aliquam maximus risus,
						vel sed vehicula. Interdum et malesuada fames ac ante ipsum primis
						in faucibus. Pellentesque venenatis dolor imperdiet dolor mattis
						sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit
						amet. Pellentesque leo mauris, consectetur id ipsum sit amet,
						fersapien risus, commodo eget turpis at, elementum convallis elit.
						Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

					<hr class="major" />

					<h2>Magna etiam veroeros</h2>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos. Etiam
						tristique libero eu nibh porttitor fermentum. Nullam venenatis
						erat id vehicula viverra. Nunc ultrices eros ut ultricies
						condimentum. Mauris risus lacus, blandit sit amet venenatis non,
						bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
						euismod in lectus. Pellentesque habitant morbi tristique senectus
						et netus et malesuada fames ac turpis egestas. In non lorem sit
						amet elit placerat maximus. Pellentesque aliquam maximus risus,
						vel sed vehicula.</p>
					<p>Interdum et malesuada fames ac ante ipsum primis in
						faucibus. Pellentesque venenatis dolor imperdiet dolor mattis
						sagittis. Praesent rutrum sem diam, vitae egestas enim auctor sit
						amet. Pellentesque leo mauris, consectetur id ipsum sit amet,
						fersapien risus, commodo eget turpis at, elementum convallis elit.
						Pellentesque enim turpis, hendrerit tristique lorem ipsum dolor.</p>

					<hr class="major" />

					<h2>Lorem aliquam bibendum</h2>
					<p>Donec eget ex magna. Interdum et malesuada fames ac ante
						ipsum primis in faucibus. Pellentesque venenatis dolor imperdiet
						dolor mattis sagittis. Praesent rutrum sem diam, vitae egestas
						enim auctor sit amet. Pellentesque leo mauris, consectetur id
						ipsum sit amet, fergiat. Pellentesque in mi eu massa lacinia
						malesuada et a elit. Donec urna ex, lacinia in purus ac, pretium
						pulvinar mauris. Curabitur sapien risus, commodo eget turpis at,
						elementum convallis elit. Pellentesque enim turpis, hendrerit.</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.
						Duis dapibus rutrum facilisis. Class aptent taciti sociosqu ad
						litora torquent per conubia nostra, per inceptos himenaeos. Etiam
						tristique libero eu nibh porttitor fermentum. Nullam venenatis
						erat id vehicula viverra. Nunc ultrices eros ut ultricies
						condimentum. Mauris risus lacus, blandit sit amet venenatis non,
						bibendum vitae dolor. Nunc lorem mauris, fringilla in aliquam at,
						euismod in lectus. Pellentesque habitant morbi tristique senectus
						et netus et malesuada fames ac turpis egestas. In non lorem sit
						amet elit placerat maximus. Pellentesque aliquam maximus risus,
						vel sed vehicula.</p>

				</section>

			</div>
		</div>

		<!-- Sidebar -->
		<div id="sidebar">
			<div class="inner">

				<!-- Search -->
				<section id="search" class="alt">
					<form method="post" action="#">
						<input type="text" name="query" id="query" placeholder="Search" />
					</form>
				</section>

				<!-- Menu -->
				<nav id="menu">
					<header class="major">
						<h2>Menu</h2>
					</header>
					<ul>
						<li><a href="index.html">Homepage</a></li>
						<li><a href="generic.html">Generic</a></li>
						<li><a href="elements.html">Elements</a></li>
						<li><span class="opener">Submenu</span>
							<ul>
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul></li>
						<li><a href="#">Etiam Dolore</a></li>
						<li><a href="#">Adipiscing</a></li>
						<li><span class="opener">Another Submenu</span>
							<ul>
								<li><a href="#">Lorem Dolor</a></li>
								<li><a href="#">Ipsum Adipiscing</a></li>
								<li><a href="#">Tempus Magna</a></li>
								<li><a href="#">Feugiat Veroeros</a></li>
							</ul></li>
						<li><a href="#">Maximus Erat</a></li>
						<li><a href="#">Sapien Mauris</a></li>
						<li><a href="#">Amet Lacinia</a></li>
					</ul>
				</nav>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Ante interdum</h2>
					</header>
					<div class="mini-posts">
						<article>
							<a href="#" class="image"><img src="images/pic07.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic08.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
						<article>
							<a href="#" class="image"><img src="images/pic09.jpg" alt="" /></a>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore aliquam.</p>
						</article>
					</div>
					<ul class="actions">
						<li><a href="#" class="button">More</a></li>
					</ul>
				</section>

				<!-- Section -->
				<section>
					<header class="major">
						<h2>Get in touch</h2>
					</header>
					<p>Sed varius enim lorem ullamcorper dolore aliquam aenean
						ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin
						sed aliquam facilisis ante interdum. Sed nulla amet lorem feugiat
						tempus aliquam.</p>
					<ul class="contact">
						<li class="icon solid fa-envelope"><a href="#">information@untitled.tld</a></li>
						<li class="icon solid fa-phone">(000) 000-0000</li>
						<li class="icon solid fa-home">1234 Somewhere Road #8254<br />
							Nashville, TN 00000-0000
						</li>
					</ul>
				</section>

				<!-- Footer -->
				<footer id="footer">
					<p class="copyright">
						&copy; Untitled. All rights reserved. Demo Images: <a
							href="https://unsplash.com">Unsplash</a>. Design: <a
							href="https://html5up.net">HTML5 UP</a>.
					</p>
				</footer>

			</div>
		</div>

	</div>

	<!-- Scripts -->
	<script src="assets/js/jquery.min.js"></script>
	<script src="assets/js/browser.min.js"></script>
	<script src="assets/js/breakpoints.min.js"></script>
	<script src="assets/js/util.js"></script>
	<script src="assets/js/main.js"></script>

</body>
</html>