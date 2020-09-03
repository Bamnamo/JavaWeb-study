package sec03.ex03;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/sess3")
public class SessionTest3 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(); 
		out.println("세션 아이디: " + session.getId() + "<br>");
		out.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>"); 
		out.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>"); 												
		out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");     // 유효시간을 재설정한 후 유효 시간을출력
		if (session.isNew()) {
			out.print("새 세션이 만들어졌습니다."); 
		}
		session.invalidate(); //invalidate()를 호출하여 생성된 세션객체를 강제로 삭제합니다.
	}
}