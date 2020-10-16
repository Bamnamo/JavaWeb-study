package com.spring.ex03;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.spring.ex01.MemberVO;

@WebServlet("/mem3.do")
public class MemberServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(requset, response);
	}

	@Override
	protected void doPost(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(requset, response);
	}

	private void doHandle(HttpServletRequest requset, HttpServletResponse response)
			throws ServletException, IOException {
		requset.setCharacterEncoding("utf-8");
		MemberDAO dao = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String action = requset.getParameter("action");
		String nextPage = "";

		if (action == null || action.equals("listMembers")) {
			List<MemberVO> membersList = dao.selectAllMemberList();
			requset.setAttribute("membersList", membersList);
			nextPage = "test02/listMembers.jsp";
		} else if (action.equals("selectMemberById")) {
			String id = requset.getParameter("value");
			memberVO = dao.selectMemberById(id);
			requset.setAttribute("member", memberVO);
			nextPage = "test02/memberInfo.jsp";
		} else if (action.equals("selectMemberByPwd")) {
			int pwd = Integer.parseInt(requset.getParameter("value"));
			List<MemberVO> membersList = dao.selectMemberByPwd(pwd);
			requset.setAttribute("membersList", membersList);
			nextPage = "/test02/listMembers.jsp";
		}

		RequestDispatcher dispatch = requset.getRequestDispatcher(nextPage);
		dispatch.forward(requset, response);

	}

}
