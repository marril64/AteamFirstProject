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
 * Servlet implementation class userUpdateForm
 */
@WebServlet("/userUpdate")
public class userUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();

		String id = request.getParameter("id");
		
		if (id != null) {
			String pw = request.getParameter("pw");
			String nick = request.getParameter("nick");
			int phone = Integer.parseInt(request.getParameter("phone"));
			
			dao.userUpdateCheck(id, pw, nick, phone);
			System.out.println("회원정보가 수정되었습니다.");
			ProjectUserVO user = dao.getUserInfo(id);
			System.out.println("회원정보 변경으로 세션을 재발급합니다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp");
		} else {
			System.out.println("로그인이 필요한 서비스입니다.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm");
		}
	}

}
