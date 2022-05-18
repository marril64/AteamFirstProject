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
 * Servlet implementation class userLogin
 */
@WebServlet("/userLogin")
public class userLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		if (dao.passwordCheck(id, pw)) {
			ProjectUserVO user = dao.getUserInfo(id);
			System.out.println("로그인 되었습니다. 세션을 발급합니다.");
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp");
		} else {
			System.out.println("없는 아이디이거나 비밀번호가 잘못되었습니다.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userLoginFail.jsp");
		}
	}

}
