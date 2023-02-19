<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
<style>
  .ck-editor__editable { height: 400px; }
  .ck-content { font-size: 12px; }
</style>
</head>
<body>
    <h1>CKEditor</h1>
    <form action="" method="POST">
      <textarea name="text" id="editor"></textarea>
    <p><input type="submit" value="전송"></p>
    </form>
    <script>
    ClassicEditor.create( document.querySelector( '#editor' ), {
    	removePlugins: [ 'Heading' ],
        language: "ko"
      } );
    </script>
</body>
</html>