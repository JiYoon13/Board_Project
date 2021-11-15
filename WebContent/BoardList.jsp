<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
<body>
	<h1>목록 화면</h1>
	<hr>
	<table>
		<tr>
			<td colspan="3">
				<form action="Search.do" method="post">
					<select name="sname">
						<option value="author">작성자</option>
						<option value="title">제목</option>
					</select>
					<input type="text" name="svalue">
					<input type="submit" value="찾기">
				</form>
			</td>
		</tr>
	</table>

	<table border="1">
		<thead>
			<tr><th>글번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th><th>비고</th><th>비고</th></tr>
		</thead>
		<c:forEach items="${alist }" var="my">
		<tbody>
			<tr>
				<td>${my.num }</td>
				<td>
				<c:forEach begin="1" end="${my.repindent }"><%="&emsp;" %></c:forEach>
				<a href="Retrieve.do?num=${my.num }">${my.title }</a></td>
				<td>${my.author }</td>
				<td>${my.writeday }</td>
				<td>${my.readcnt }</td>
				<td><a href="BoardModify.jsp?num=${my.num }&author=${my.author }">수정</a></td>
				<td><a href="Delete.do?num=${my.num }">삭제</a></td>
			</tr>
		</tbody>
		</c:forEach>
	</table>
	<p><p>
	<a href="Main.jsp">메인화면</a>
</body>
</html>