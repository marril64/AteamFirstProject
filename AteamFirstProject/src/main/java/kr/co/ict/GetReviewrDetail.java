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
 * Servlet implementation class GetReviewrDetail
 */
@WebServlet("/getreviewrdetail")
public class GetReviewrDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetReviewrDetail() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strBoardNum = request.getParameter("reviewNum");
		// 정수로 바꿔줘야함.
		int reviewrNum = Integer.parseInt(strBoardNum);
		// 바뀐 글 번호가 잘 나오는지 체크
		System.out.println("조회예정인 글번호 : " + reviewrNum);
		// DAO를 생성하세요.
		ReviewrDAO dao = ReviewrDAO.getInstance();
		// DAO에서 호출한 디테일 글 정보를 저장해주세요.
		ReviewrVO reviewr = dao.getreviewrDetail(reviewrNum);
		// 얻어온 글 정보를 디버깅해주세요.
		System.out.println(reviewr);
		// 바인딩해주세요.
		request.setAttribute("reviewr", reviewr);
		// 포워딩해주세요.(/board/boardDetail.jsp로)
		RequestDispatcher dp = request.getRequestDispatcher("/review/reviewrDetail.jsp");
		dp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
