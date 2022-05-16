package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class userLogout
 */
@WebServlet("/userLogout")
public class userLogout extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userLogout() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		
		if (yes != null) {
			HttpSession session = request.getSession();
			System.out.println("로그아웃으로 인해 세션을 파기합니다.");
			session.invalidate();
			response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm");
		} else if (no != null) {
			response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm");
		}
	}

}
