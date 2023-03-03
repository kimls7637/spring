<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Start your development with JoeBLog landing page.">
<meta name="author" content="Devcrud">
<title>ACENSE : 나의 댓글</title>
<!-- font icons -->
<link rel="stylesheet"
	href="assets/vendors/themify-icons/css/themify-icons.css">
	<link rel="icon" href="./assets/imgs/favicon.png" />
<!-- Bootstrap + JoeBLog main styles -->
<link rel="stylesheet" href="assets/css/joeblog.css">
<style>
.listA a:hover{
color:#a0ba83;
}
</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="40" id="home">




	<%@ include file="./header.jsp"%>

	<aside class="lg:col-span-3 lg:pr-16"
		style="width: 20%; margin-left: 17%; margin-top: 5%; display: flex; float: left;">
		<div>
			<h2 class="text-xl font-semibold leading-6">내 계정</h2>
		</div>
		<nav class="my-4 space-y-2 lg:my-10">
			<a
				class="text-gray-500 group flex items-center rounded-md px-3 py-2 font-medium hover:bg-gray-200 hover:text-gray-800 dark:hover:bg-gray-700 dark:hover:text-gray-300"
				href="myPage.do"><svg xmlns="http://www.w3.org/2000/svg"
					fill="none" viewBox="0 0 24 24" stroke-width="1.5"
					stroke="currentColor" aria-hidden="true"
					class=" text-gray-400 dark:text-gray-600 -ml-1 mr-3 h-6 w-6 shrink-0 group-hover:text-gray-800 dark:group-hover:text-gray-200">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M4.5 12a7.5 7.5 0 0015 0m-15 0a7.5 7.5 0 1115 0m-15 0H3m16.5 0H21m-1.5 0H12m-8.457 3.077l1.41-.513m14.095-5.13l1.41-.513M5.106 17.785l1.15-.964m11.49-9.642l1.149-.964M7.501 19.795l.75-1.3m7.5-12.99l.75-1.3m-6.063 16.658l.26-1.477m2.605-14.772l.26-1.477m0 17.726l-.26-1.477M10.698 4.614l-.26-1.477M16.5 19.794l-.75-1.299M7.5 4.205L12 12m6.894 5.785l-1.149-.964M6.256 7.178l-1.15-.964m15.352 8.864l-1.41-.513M4.954 9.435l-1.41-.514M12.002 12l-3.75 6.495"></path></svg><span
				class="truncate">정보변경</span></a> <a
				class="text-gray-500 group flex items-center rounded-md px-3 py-2 font-medium hover:bg-gray-200 hover:text-gray-800 dark:hover:bg-gray-700 dark:hover:text-gray-300"
				href="myBList.do?id=${member.id}"><svg xmlns="http://www.w3.org/2000/svg"
					fill="none" viewBox="0 0 24 24" stroke-width="1.5"
					stroke="currentColor" aria-hidden="true"
					class=" text-gray-400 dark:text-gray-600 -ml-1 mr-3 h-6 w-6 shrink-0 group-hover:text-gray-800 dark:group-hover:text-gray-200">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M4.5 12a7.5 7.5 0 0015 0m-15 0a7.5 7.5 0 1115 0m-15 0H3m16.5 0H21m-1.5 0H12m-8.457 3.077l1.41-.513m14.095-5.13l1.41-.513M5.106 17.785l1.15-.964m11.49-9.642l1.149-.964M7.501 19.795l.75-1.3m7.5-12.99l.75-1.3m-6.063 16.658l.26-1.477m2.605-14.772l.26-1.477m0 17.726l-.26-1.477M10.698 4.614l-.26-1.477M16.5 19.794l-.75-1.299M7.5 4.205L12 12m6.894 5.785l-1.149-.964M6.256 7.178l-1.15-.964m15.352 8.864l-1.41-.513M4.954 9.435l-1.41-.514M12.002 12l-3.75 6.495"></path></svg><span
				class="truncate">나의게시글</span></a>
				<a
				class="bg-gray-200 text-gray-800 dark:bg-gray-700 dark:text-gray-200 group flex items-center rounded-md px-3 py-2 font-medium hover:bg-gray-200 hover:text-gray-800 dark:hover:bg-gray-700 dark:hover:text-gray-300"
				aria-current="page" href="myCList.do?id=${member.id}"><svg
					xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24"
					stroke-width="1.5" stroke="currentColor" aria-hidden="true"
					class="text-gray-600 dark:text-gray-400 -ml-1 mr-3 h-6 w-6 shrink-0 group-hover:text-gray-800 dark:group-hover:text-gray-200">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M17.982 18.725A7.488 7.488 0 0012 15.75a7.488 7.488 0 00-5.982 2.975m11.963 0a9 9 0 10-11.963 0m11.963 0A8.966 8.966 0 0112 21a8.966 8.966 0 01-5.982-2.275M15 9.75a3 3 0 11-6 0 3 3 0 016 0z"></path></svg><span
				class="truncate">나의댓글</span></a> <a
				class="text-gray-500 group flex items-center rounded-md px-3 py-2 font-medium hover:bg-gray-200 hover:text-gray-800 dark:hover:bg-gray-700 dark:hover:text-gray-300"
				href="deleteMember.do"><svg xmlns="http://www.w3.org/2000/svg"
					fill="none" viewBox="0 0 24 24" stroke-width="1.5"
					stroke="currentColor" aria-hidden="true"
					class=" text-gray-400 dark:text-gray-600 -ml-1 mr-3 h-6 w-6 shrink-0 group-hover:text-gray-800 dark:group-hover:text-gray-200">
					<path stroke-linecap="round" stroke-linejoin="round"
						d="M4.5 12a7.5 7.5 0 0015 0m-15 0a7.5 7.5 0 1115 0m-15 0H3m16.5 0H21m-1.5 0H12m-8.457 3.077l1.41-.513m14.095-5.13l1.41-.513M5.106 17.785l1.15-.964m11.49-9.642l1.149-.964M7.501 19.795l.75-1.3m7.5-12.99l.75-1.3m-6.063 16.658l.26-1.477m2.605-14.772l.26-1.477m0 17.726l-.26-1.477M10.698 4.614l-.26-1.477M16.5 19.794l-.75-1.299M7.5 4.205L12 12m6.894 5.785l-1.149-.964M6.256 7.178l-1.15-.964m15.352 8.864l-1.41-.513M4.954 9.435l-1.41-.514M12.002 12l-3.75 6.495"></path></svg><span
				class="truncate">탈퇴</span></a>
		</nav>
	</aside>
	<div>
		<form
			class="divide-y divide-gray-500/30 dark:divide-gray-500/70 lg:col-span-9">
			<div class="my-10 lg:my-0 lg:pl-20">
				<h2 class="text-xl font-semibold leading-6">나의 댓글</h2>
				<!-- 게시글번호 / 제목 / 작성날짜 띄우기 -->
				<div class="my-10 flex flex-col lg:flex-row"
					style="border-left: 1px solid black; padding-left: 2%;">
					<div class="flex-grow space-y-6" style="width: 65%;">
						<div>
							<!-- ddd -->
							<div class="mt-10">
								<div class="mb-9 sm:mb-16">
									<ul class="divide-y divide-gray-500/30 dark:divide-gray-500/70">
									<c:forEach var="v" items="${myCommentList}">
										<li class="py-5"
											style="border: 1px solid #dee2e6; padding: 20px !important; border-radius: 20px; margin-bottom:10px;"><div
												class="flex flex-1 items-center">
												<div class="w-full space-y-2">
													<div class="flex items-center gap-x-2">
														<div
															class="flex flex-1 items-center gap-x-1.5 text-sm font-normal">
															
															<div class="text-gray-500">${v.bTitle}</div>
														</div>
														<div
															class="hidden text-sm font-normal text-gray-500 sm:block">${v.cDate}</div>
													</div>
													<div class="listA">
														<a
															class="line-clamp-1 w-fit break-all text-sm font-semibold text-gray-900 hover:text-blue-500 hover:no-underline dark:text-gray-100 dark:hover:text-blue-200 sm:text-base"
															href="/article/1405086">${v.cContent}</a>
													</div>
													
												</div>
											</div></li>
											</c:forEach>
									</ul>
								</div>
								<div
									class="my-4 flex justify-center border-t border-gray-500/30 dark:border-gray-500/70"></div>
							</div>

							<!-- ddd -->
						</div>

					</div>
				</div>
				
			</div>
		</form>
	</div>
	<%@ include file="./footer.jsp"%>



</body>
</html>
