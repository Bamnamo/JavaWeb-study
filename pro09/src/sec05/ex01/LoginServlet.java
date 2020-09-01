package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doHandle(req, resp);
	}

	private void doHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		String user_id = req.getParameter("user_id");
		String user_pwd = req.getParameter("user_pwd");
		MemberVO memberVO = new MemberVO();				//MemberVO 객체를 생성하고 속성에 아이디와 비밀번호를 설정합니다
		memberVO.setId(user_id);
		memberVO.setPwd(user_pwd);
		MemberDAO dao = new MemberDAO();				
		boolean result = dao.isExisted(memberVO);			//MemberDAO의 isExisted() 메서드를 호출하면서 memberVO를 전달합니다.
		

		if (result) {
			HttpSession session = req.getSession();
			session.setAttribute("isLogon", true);		// 조회한 결과가 true이면 isLogOn 속성을 true로 세션에 저장합니다.
			session.setAttribute("login.id", user_id);	// 조회한 결과가 true이면 아이디와 비밀번호를 세션에 저장합니다.
			session.setAttribute("login.pwd", user_pwd);
			out.print("<html><body>");
			out.print("안녕하세요 " + user_id + "님!!<br>");
			out.print("<a href='show'>회원정보 보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body><center>회원 아이디가 틀립니다.");
			out.print("<a href=;login3.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}
}
