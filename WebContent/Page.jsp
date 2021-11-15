<%@page import="com.board.PageDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BOARD</title>
</head>
<body>
	<%
		PageDTO	pdto = (PageDTO)request.getAttribute("page");
		int curpage = pdto.getCurpage();
		int perpage = pdto.getPerpage();
		int totalcnt = pdto.getTotalcnt();
		int totalpage = totalcnt / perpage;
		
		if(totalcnt % perpage != 0)
			totalpage ++;
		
		for(int i=1; i<=totalpage; i++){
			if(curpage == i)
				out.print("<font color='red'>" + i + "</font>&nbsp;&nbsp;");
			else
				out.print("<a href='List.do?curpage="+i+"'>"+i+"</a>&nbsp;&nbsp;");
		}
	%>
</body>
</html>