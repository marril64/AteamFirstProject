package kr.co.ict;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;
import kr.co.ict.domain.ReviewrVO;

/**
 * Servlet implementation class ReviewrUpdate
 */
@WebServlet("/reviewrupdate")
public class ReviewrUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewrUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reviewName = request.getParameter("reviewName");
		String content = request.getParameter("content");
		String ruser = request.getParameter("ruser");
		String score = request.getParameter("score");

		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
		int scores = Integer.parseInt(score);
		
		
		ReviewrDAO dao = ReviewrDAO.getInstance();
		ReviewrVO review = dao.reviewupdate(ruser, reviewName, content, scores);
		
		request.setAttribute("review", review);
		// 포워딩해주세요.(/board/boardDetail.jsp로)

		response.sendRedirect("http://localhost:8181/AteamFirstProject/getreviewrdetail?reviewNum=" + reviewNum);
	

	}

}
