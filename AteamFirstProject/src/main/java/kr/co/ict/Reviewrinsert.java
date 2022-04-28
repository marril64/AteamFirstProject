package kr.co.ict;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.domain.ReviewrDAO;

/**
 * Servlet implementation class Reviewrinsert
 */
@WebServlet("/reviewrinsert")
public class Reviewrinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reviewrinsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reviewName =request.getParameter("reviewrName");
		String ruser =request.getParameter("ruser");
		String content =request.getParameter("content");
		String score = request.getParameter("score");
		int scores = Integer.parseInt(score);
		String boardNum = request.getParameter("boardNum");
		int boardNums = Integer.parseInt(boardNum);
		
		ReviewrDAO dao = ReviewrDAO.getInstance();
		dao.reviewrInsert(reviewName, content, ruser, scores, boardNums);
        response.sendRedirect("http://localhost:8181/AteamFirstProject/getreviewrlist");
	
	}

}
