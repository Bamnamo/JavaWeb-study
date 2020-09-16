<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util. *, sec02.ex1.*"
    isELIgnored="false"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:useBean id="m" class="sec02.ex1.MemberBean"></jsp:useBean>
<jsp:setProperty property="*" name="m"/>
<%
MemberDAO memDAO=new MemberDAO();
memDAO.addMember(m);
List memberList=memDAO.listMembers();
request.setAttribute("memberList", memberList);
%>
<title></title>
</head>
<body>
<jsp:forward page="membersList.jsp" />

</body>
</html>