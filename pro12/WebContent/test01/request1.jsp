<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "이순신");
request.setAttribute("address", "서울시 강남구");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 데이이터 바인딩</title>
</head>
<body>
	<%
		RequestDispatcher dispatch = request.getRequestDispatcher("request2.jsp");
	dispatch.forward(request, response);
	%>
</body>
</html>