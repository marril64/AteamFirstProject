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
 * Servlet implementation class ReviewrUpdateForm
 */
@WebServlet("/reviewrupdateform")
public class ReviewrUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewrUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String reviewNum = request.getParameter("reviewNum");
		// 정수로 바꿔줘야함.
		int reviewrNum = Integer.parseInt(reviewNum);
		
    ReviewrDAO dao = ReviewrDAO.getInstance();
	ReviewrVO review = dao.getreviewrDetail(reviewrNum);
	System.out.println(review);
	// 바인딩해주세요.
	request.setAttribute("reviewr", review);
	// 포워딩해주세요.(/board/boardDetail.jsp로)
	RequestDispatcher dp = request.getRequestDispatcher("/review/reviewrUpdateForm.jsp");
	dp.forward(request, response);
	}

}
