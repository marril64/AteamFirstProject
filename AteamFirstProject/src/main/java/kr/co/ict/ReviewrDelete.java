package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.ReviewrVO;

/**
 * Servlet implementation class ReviewrDelete
 */
@WebServlet("/reviewrdelete")
public class ReviewrDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewrDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reviewNum = request.getParameter("reviewNum");
		System.out.println(reviewNum);
		// 정수로 바꿔줘야함.
		int reviewrNum = Integer.parseInt(reviewNum);
		ReviewrDAO dao = ReviewrDAO.getInstance();
		ReviewrVO board = dao.reviewDelete(reviewrNum);
		response.sendRedirect("http://localhost:8181/AteamFirstProject/getreviewrlist");
	}

}
