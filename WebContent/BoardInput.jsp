<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<h1>글 작성</h1>
	<hr>
	<form action="Input.do" method="post">
		<table>
			<tr><td>작성자</td><td><input type="text" name="author"></td></tr>
			<tr><td>제목</td><td><input type="text" name="title"></td></tr>
			<tr><td>내용</td><td><textarea rows="10" cols="50" name="content"></textarea></td></tr>
		</table>
		<p>
		<input type="submit" value="전송">
		<input type="button" value="취소" onclick="location.href='Main.jsp'">
	</form>
</body>
</html>