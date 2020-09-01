package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class SessionTest5 extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession();
		String user_id = req.getParameter("user_id");
		String user_pw = req.getParameter("user_pw");
		if (session.isNew()) {
			if (user_id != null) {
				session.setAttribute("user_id", user_id);
				String url = resp.encodeURL("login");					//변수 url에 encodeURL()이용하여 응답시 미리 jsessionId를 저장합니다.
				out.println("<a href=" + url + ">로그인 상태 확인</a>");	// 로그인 상태 확인 클릭시 jsessionId를 서블릿으로 다시 전송
			} else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!");
				session.invalidate();
			}
		} else {
			user_id = (String) session.getAttribute("user_id");
			if (user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님!!");
			} else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}

	}

}
