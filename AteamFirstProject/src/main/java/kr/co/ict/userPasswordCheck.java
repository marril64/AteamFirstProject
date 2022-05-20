package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ProjectUserVO;

/**
 * Servlet implementation class userPasswordCheck
 */
@WebServlet("/userPasswordCheck")
public class userPasswordCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userPasswordCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		// HttpSession session = request.getSession();

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String newPw = request.getParameter("newPw");
		String nick = request.getParameter("nick");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		if (dao.passwordCheck(id, pw)) {
			dao.userUpdateCheck(id, newPw, nick, phone);
			System.out.println("회원정보가 수정되었습니다.");
			ProjectUserVO user = dao.getUserInfo(id);
			System.out.println("회원정보 변경으로 세션을 재발급합니다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userUpdateSuccess.jsp");
		} else {
			System.out.println("비밀번호를 다시 입력해주십시오.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp");
		}
	}

}
