<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 출력 창</title>
</head>
<body>
<%
String userID=request.getParameter("userID");
if(userID.length()==0){
%>
<jsp:forward page="login.jsp" />
<%} %>
<h1> 환영합니다 <%=userID %></h1>
</body>
</html>