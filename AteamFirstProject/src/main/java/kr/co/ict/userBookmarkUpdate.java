package kr.co.ict;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ProjectUserDAO;
import kr.co.ict.domain.StoreInfoVO;

/**
 * Servlet implementation class userBookmarkUpdate
 */
@WebServlet("/userBookmarkUpdate")
public class userBookmarkUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userBookmarkUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		ProjectUserDAO dao = ProjectUserDAO.getInstance();

		String yes = request.getParameter("yes");
		String no = request.getParameter("no");
		int userNum = Integer.parseInt(request.getParameter("userNum"));

		if (yes != null) {
			int storeNum = Integer.parseInt(request.getParameter("storeNum"));
			
			dao.bookmarkUpdate(userNum, storeNum);
			List<StoreInfoVO> store = dao.getUserBookmark(userNum);
			request.setAttribute("store", store);
			RequestDispatcher dp = request.getRequestDispatcher("firstProject/userBookmark.jsp");
			dp.forward(request, response);
		} else if (no != null) {
			List<StoreInfoVO> store = dao.getUserBookmark(userNum);
			request.setAttribute("store", store);
			RequestDispatcher dp = request.getRequestDispatcher("firstProject/userBookmark.jsp");
			dp.forward(request, response);
		}
	}

}
