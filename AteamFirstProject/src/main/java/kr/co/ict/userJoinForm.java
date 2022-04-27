package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;

/**
 * Servlet implementation class userJoinForm
 */
@WebServlet("/userJoinForm")
public class userJoinForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userJoinForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String id = request.getParameter("id");
		String idcheck = request.getParameter("idcheck");
		String pw = request.getParameter("pw");
		String pwcheck = request.getParameter("pwcheck");
		String nick = request.getParameter("nick");
		int phone = Integer.parseInt(request.getParameter("phone"));
		
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		if (dao.userJoinCheck(id, pw, phone, nick)) {
			System.out.println("가입되었습니다.");
		} else {
			System.out.println("아이디나 닉네임이 중복되었습니다.");
		}
		
	}

}
