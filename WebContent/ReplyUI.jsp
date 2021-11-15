<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<h1>답변 작성</h1>
	<hr>
	<form action="Reply.do" method="post">
		<input type="hidden" name="num" value="${rdata.num }">
		<input type="hidden" name="reproot" value="${rdata.reproot }">
		<input type="hidden" name="repstep" value="${rdata.repstep }">
		<input type="hidden" name="repindent" value="${rdata.repindent }">
		<table>
			<tr><td colspan="2">글 번호: ${rdata.num }&emsp;&emsp; 조회수: ${rdata.readcnt }</td></tr>
			<tr><td>제목</td><td><input type="text" name="r_title" value="${rdata.title }"></td></tr>
			<tr><td>작성자</td><td><input type="text" name="r_author"></td></tr>
			<tr><td>내용</td><td><textarea rows="2" cols="22" name="r_content"></textarea></td></tr>
		</table>
		<br>
		<input type="submit" value="답변">
	</form>
</body>
</html>