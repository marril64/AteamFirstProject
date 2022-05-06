package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;

/**
 * Servlet implementation class userDeleteForm
 */
@WebServlet("/userDelete")
public class userDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userDelete() {
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
		
		if (dao.userDelete(id, pw)) {
			System.out.println("정상적으로 탈퇴되었습니다.");
			HttpSession session = request.getSession();
			session.invalidate();
			System.out.println("세션을 파기합니다.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm");
		} else {
			System.out.println("id와 pw를 다시 확인해주십시오.");
		}
	}

}
