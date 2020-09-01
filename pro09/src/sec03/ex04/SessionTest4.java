package sec03.ex04;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/login")
public class SessionTest4 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doHandle(request, response);
	}

	private void doHandle(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String user_id = request.getParameter("user_id");		//로그인 창에서 전송된 아이디와 비밀번호를 가져온다.
		String user_pw = request.getParameter("user_pw");
		if (session.isNew()) {									//최초 요청시 수행
			if (user_id != null) {								//로그인 창에서 서블릿으로 요청햇다면 아이디가 null이
				session.setAttribute("user_id", user_id);		//아니므로 세션에 아이디를 바인딩 한다.
				out.println("<a href='login'>로그인 상태 확인</a>");
			} else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!");
				session.invalidate();
			}
		} else {													//재 요청시 세션에서 아이디를 가져와 이전에
			user_id = (String) session.getAttribute("user_id");		// 로그인 했는지 여부를 확인한다.
			if (user_id != null && user_id.length() != 0) {
				out.print("안녕하세요 " + user_id + "님!!");
			} else {
				out.println("<a href='login2.html'>다시 로그인 하세요!!</a>");
				session.invalidate();
			}
		}

	}

}
