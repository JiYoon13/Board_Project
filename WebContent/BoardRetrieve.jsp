<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<body>
	<table border="1">
		<tr><td>글번호</td><td>${data.num }</td></tr>
		<tr><td>조회수</td><td>${data.readcnt }</td></tr>
		<tr><td>날짜</td><td>${data.writeday }</td></tr>
		<tr><td>작성자</td><td>${data.author }</td></tr>
		<tr><td>제목</td><td>${data.title }</td></tr>
		<tr><td>내용</td><td>${data.content }</td></tr>
	</table>
	<a href="Main.jsp">메인화면</a>&emsp;&emsp;
	<a href="Replyui.do?num=${data.num }">답변달기</a>
</body>
</html>