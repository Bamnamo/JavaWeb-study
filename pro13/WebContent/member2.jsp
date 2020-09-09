<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    import="java.util.*,
    sec01.ex01.*"
    %>
    
    <%
    request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="m" class="sec01.ex01.MemberBean" scope="page" /> <!--유즈빈 액션 태그로 id가 m인 MemberBean 객체를 만듭니다.-->
    
    <%
    String id=request.getParameter("id");
    String pwd=request.getParameter("pwd");
    String name=request.getParameter("name");
    String email=request.getParameter("email");
    
    m.setId(id);				// userBean에 전송된 회원 정보를 설정합니다.
    m.setPwd(pwd);
    m.setName(name);
    m.setEmail(email);
    
    MemberDAO memberDAO=new MemberDAO();
    memberDAO.addMember(m);				//회원 정보를 추가 한 후 목록으로 출력합니다.
    List memberList=memberDAO.listMembers();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 목록창</title>
</head>
<body>
<table align="center" width="100%">
		<tr align="center" bgcolor="#99ccff">
			<td width="7%">아이디</td>
			<td width="7%">비밀번호</td>
			<td width="5%">이름</td>
			<td width="11%">이메일</td>
			<td width="5%">가입일</td>
		</tr>
		<%
			if (memberList.size() == 0) {
		%>
		<tr>
			<td colspan="5">
				<p align="center">
					<b><span style="font-size: 9pt;"> 등록된 회원이 없습니다.</span></b>
				</p>
			</td>
		</tr>
		<%
			} else {
		for (int i = 0; i < memberList.size(); i++) {
			MemberBean bean = (MemberBean) memberList.get(i);
		%>
		<tr align="center">
			<td><%=bean.getId()%></td>
			<td><%=bean.getPwd()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getEmail()%></td>
			<td><%=bean.getJoinDate()%></td>
		</tr>
		<%
			} // end for

		} // end if
		%>
		<tr height="1" bgcolor="#99ccff">
			<td colspan="5"></td>
		</tr>
	</table>

</body>
</html>