package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.ProjectUserVO;
import kr.co.ict.domain.StoreInfoVO;

/**
 * Servlet implementation class userBookmarkForm
 */
@WebServlet("/userBookmarkForm")
public class userBookmarkForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBookmarkForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();
		
		int userNum = Integer.parseInt(request.getParameter("userNum"));
		
		List<StoreInfoVO> store = dao.getUserBookmark(userNum);
		
		System.out.println(store);
		
		
		
		RequestDispatcher dp = request.getRequestDispatcher("firstProject/userBookmark.jsp");
		dp.forward(request, response);
	}

}
