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
<<<<<<< HEAD
=======
		request.setCharacterEncoding("utf-8");
>>>>>>> fbe50eca4c03ee9edb07b2940db41d60c75990a2
		String reviewrName = request.getParameter("reviewrName");
		String content = request.getParameter("content");
		String ruser = request.getParameter("ruser");
		String score = request.getParameter("score");
<<<<<<< HEAD
=======
		int reviewNum = Integer.parseInt(request.getParameter("reviewNum"));
>>>>>>> fbe50eca4c03ee9edb07b2940db41d60c75990a2
		int scores = Integer.parseInt(score);
		
		
		ReviewrDAO dao = ReviewrDAO.getInstance();
		ReviewrVO review = dao.reviewupdate(ruser, reviewrName, content, scores);
		
		request.setAttribute("reviewr", review);
		// 포워딩해주세요.(/board/boardDetail.jsp로)
<<<<<<< HEAD
		RequestDispatcher dp = request.getRequestDispatcher("/review/reviewrDetail.jsp");
		dp.forward(request, response);
=======
		response.sendRedirect("/AteamFirstProject/getreviewrdetail?reviewNum=" + reviewNum);
>>>>>>> fbe50eca4c03ee9edb07b2940db41d60c75990a2
	}

}
