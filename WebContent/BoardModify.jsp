<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<%
	request.setCharacterEncoding("utf-8");
	int num = Integer.parseInt(request.getParameter("num"));
	String author = request.getParameter("author");
	
	HttpSession hs = request.getSession();
	hs.setAttribute("num", num);
%>
<body>
	<form action="Modify.do" method="post">
		<table>
			<tr><td>글번호</td><td>${param.num }</td></tr>
			<tr><td>제목</td><td><input type="text" name="title"></td></tr>
			<tr><td>작성자</td><td>${param.author }</td></tr>
			<tr><td>내용</td><td><textarea rows="10" cols="50" name="content"></textarea></td></tr>
		</table>
		<input type="submit" value="수정">
	</form>
</body>
</html>