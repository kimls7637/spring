<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
<style>
form {
	display: flex;
	flex-direction: column;
	width: 50%;
}
</style>
</head>
<body>
	<form method="post" action="insertInsta.do" enctype="multipart/form-data">
		<input type="text" id="id" placeholder="id" name="writer"/> 
		<input type="password" id="pw" placeholder="pw" name="title"/>
		<textarea id="content" name="content" ></textarea>
		<input type="file" id="file" name="uploadFile" />
		<img src="" id="preview" style="width: 200px;">
		<button>인스타</button>
	</form>
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