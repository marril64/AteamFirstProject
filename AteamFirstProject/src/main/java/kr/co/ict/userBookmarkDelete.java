package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;

/**
 * Servlet implementation class userBookmarkDelete
 */
@WebServlet("/userBookmarkDelete")
public class userBookmarkDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBookmarkDelete() {
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
			ProjectUserDAO dao = ProjectUserDAO.getInstance();
			
			int userNum = Integer.parseInt(request.getParameter("userNum"));
			int storeNum = Integer.parseInt(request.getParameter("storeNum"));
			
			dao.bookmarkDelete(userNum, storeNum);
			
			response.sendRedirect("");
		} else if (no != null) {
			response.sendRedirect("");
		}
	}

}
