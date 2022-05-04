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
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("id");
		String id = request.getParameter("id");
		
		if (sId != null && sId.equals(id)) {
			String pw = request.getParameter("pw");
			String nick = request.getParameter("nick");
			int phone = Integer.parseInt(request.getParameter("phone"));
			
			ProjectUserDAO dao = ProjectUserDAO.getInstance();
			
			dao.userUpdateCheck(id, pw, nick, phone);
			System.out.println("회원정보가 수정되었습니다.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/firstProject/userInfo.jsp");
		} else {
			System.out.println("로그인이 필요한 서비스입니다.");
			response.sendRedirect("http://localhost:8181/AteamFirstProject/userLoginForm");
		}
	}

}
